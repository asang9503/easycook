package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.*;
import com.eco.easycook.pojo.*;
import com.eco.easycook.service.EcStoryService;
import com.eco.easycook.util.EcStoryUtil;
import com.eco.easycook.util.ResponseVoUtil;
import com.eco.easycook.util.token.SystemCon;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nvarchar
 */
@Service
public class EcStoryServiceImpl implements EcStoryService {

    @Autowired
    private EcStoryMapper mapper;

    @Autowired
    private EcCommentMapper commentMapper;

    @Autowired
    private EcVoteMapper voteMapper;

    @Autowired
    private EcSeeMapper seeMapper;

    @Autowired
    private EcStoryimgMapper storyimgMapper;

    @Autowired
    private EcStoryUtil tryUtil;

    private JedisPool jedisPool = new JedisPool("120.79.198.64",6379);
    private JedisUtil jedisUtil = new JedisUtil(jedisPool,"root");


    /**
     *根据用户id查询关注用户的故事
     * @param id 当前登录用户id
     * @return
     */
    @Override
    public ResponseVo<EcStory> showStoryWithAttention(String pageNum, String pageSize, Integer id, String token) {

        //验证token和前段传来的参数
        if (jedisUtil.getHash(SystemCon.TOKENHASH,"token:" + token) != null && id != null && id !=0) {
            //获取故事评论数量
            List<EcComment> list = commentMapper.selectCommentCountById(id);
            //获取关注的故事
            List<EcStory> lists = mapper.selectByUserId(id);
            //获取故事点赞数量
            List<EcVote> listVote = voteMapper.selectVoteCountById(id);
            //获取故事观看数量
            List<EcSee> listSee = seeMapper.selectSeeCountById(id);
            //调用分页
            PageInfo<EcStory> info = new PageInfo<>(tryUtil.getStory(lists, list, listSee, listVote));

            ResponseVo<EcStory> vo = new ResponseVo<>(1000, "success", info);

            return vo;

        } else {

            return ResponseVoUtil.setERROR("登陆后才能查看");

        }

    }

    /**
     *
     * 查询点赞最多的故事（发现故事）
     * @param type 故事类型（发现故事/最新故事）
     * @return
     */
    @Override
    public ResponseVo<EcStory> showStoryWithType(String pageNum, String pageSize, String type) {
        //判断前端传来的参数是否可用
        if (type == null || type == "") {

            return ResponseVoUtil.setERROR("网络异常请重新刷新");
        } else {
            ResponseVo<EcStory> vo;
            //获取故事评论数量
            List<EcComment> list = commentMapper.selectCommentCount();
            //获取最新故事
            List<EcStory> listPutTime = mapper.selectWithPutTime();
            //获取点赞最多故事
            List<EcStory> listVoteNum = mapper.selectWithVoteNum();
            //获取故事点赞数量
            List<EcVote> listVote = voteMapper.selectVoteCount();
            //获取故事观看数量
            List<EcSee> listSee = seeMapper.selectSeeCount();
            switch (type) {

                //查询出最新发布的故事
                case "最新": vo = new ResponseVo<>(1000, "success", tryUtil.getStory(listPutTime, list, listSee, listVote));
                    break;
                //查询出当前（最火）点赞对多的故事
                case "最热": vo = new ResponseVo<>(1000, "success", tryUtil.getStory(listVoteNum, list, listSee, listVote));
                    break;

                default:
                    vo = ResponseVoUtil.setERROR("网络异常请重新刷新");

                    break;

            }
            //封装到返回方法中
            return vo;
        }
        //return new ResponseVo<>(1000, "success", mapper.selectWithVoteNum());
    }

    /**
     *
     * 查询最新的故事（最新故事）
     * @return
     */
    @Override
    public ResponseVo<EcStory> showStoryWithNew() {
        return new ResponseVo<>(1000, "success", mapper.selectWithPutTime());
    }

    /**
     *
     * @param story 故事对象
     * @return
     */
    @Override
    public ResponseVo<EcStory> saveStory(EcStory story, String[] fileName, String token) {

        if (jedisUtil.getHash(SystemCon.TOKENHASH,"token:" + token) != null && story != null && fileName[0] !=null) {

            List<EcStoryimg> list = new ArrayList<>();

            EcStoryimg storyimg = new EcStoryimg();

            for (String imgUrl : fileName) {

                storyimg.setEcSimgurl(imgUrl);

                storyimg.setStoryid(story.getEcSid());

                list.add(storyimg);
            }

            storyimgMapper.inserts(list);

            return new ResponseVo<>(1000, "success", mapper.insert(story));
        } else {
            return ResponseVoUtil.setERROR("请填写内容");
        }

    }
}
