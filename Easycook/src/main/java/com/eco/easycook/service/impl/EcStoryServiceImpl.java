package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.*;
import com.eco.easycook.pojo.*;
import com.eco.easycook.service.EcStoryService;
import com.eco.easycook.util.EcStoryUtil;
import com.eco.easycook.util.ResponseVoUtil;
import com.eco.easycook.util.StringImgToListImg;
import com.eco.easycook.util.token.SystemCon;
import com.github.pagehelper.PageHelper;
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
    private EcStoryUtil storyUtil;

    @Autowired
    private StringImgToListImg imgUtil;

    private JedisPool jedisPool = new JedisPool("120.79.198.64",6379);

    private JedisUtil jedisUtil = new JedisUtil(jedisPool,"root");


    /**
     *根据用户id查询关注用户的故事
     * @param id 当前登录用户id
     * @return
     */
    @Override
    public ResponseVo<EcStory> showStoryWithAttention(Integer pageNum, Integer pageSize, Integer id, String token) {

        //验证token和前段传来的参数
        if (jedisUtil.getHash(SystemCon.TOKENHASH,"token:" + token) != null && id != null && id !=0) {

            //获取关注的故事
            List<EcStory> lists = mapper.selectByUserId(id);
            if(lists != null) {

                PageHelper.startPage(pageNum, pageSize);
                //获取故事评论数量
                List<EcComment> list = commentMapper.selectCommentCountById(id);
                //获取故事点赞数量
                List<EcVote> listVote = voteMapper.selectVoteCountById(id);
                //获取故事观看数量
                List<EcSee> listSee = seeMapper.selectSeeCountById(id);

                List<EcStory> newList = storyUtil.getStory(lists, list, listSee, listVote);
                //分离图片路径
                imgUtil.getListImgUrl(newList);
                //调用分页
                PageInfo<EcStory> info = new PageInfo<>(newList);

                ResponseVo<EcStory> vo = new ResponseVo<>(1000, "success", info);

                return vo;
            } else {
                return ResponseVoUtil.setERROR("没有故事");
            }
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
    public ResponseVo<EcStory> showStoryWithType(Integer pageNum, Integer pageSize, String type) {
        //判断前端传来的参数是否可用
        if (type == null || type == "") {

            return ResponseVoUtil.setERROR("网络异常请重新刷新");
        } else {
            ResponseVo<EcStory> vo;
            //获取故事评论数量
            List<EcComment> list = commentMapper.selectCommentCount();
            //获取故事点赞数量
            List<EcVote> listVote = voteMapper.selectVoteCount();
            //获取故事观看数量
            List<EcSee> listSee = seeMapper.selectSeeCount();
            switch (type) {
                //查询出最新发布的故事
                case "最热":

                    PageHelper.startPage(pageNum, pageSize);
                    //获取点赞最多故事
                    List<EcStory> noteNumList = mapper.selectWithVoteNum();

                    if (noteNumList != null) {
                        List<EcStory> newList = storyUtil.getStory(noteNumList, list, listSee, listVote);

                        imgUtil.getListImgUrl(newList);

                        //对获取到故事进行点赞最多降序排序（选择排序）
                        for (int i = 0; i < newList.size(); i++) {
                            int index = i;

                            for (int j = i + 1; j < newList.size(); j++) {
                                if (newList.get(index).getEcVoteCount() < newList.get(j).getEcVoteCount()) {
                                    index = j;
                                }
                            }
                            if (index != i) {
                                EcStory temp;
                                temp = newList.get(i);
                                newList.set(i, newList.get(index));
                                newList.set(index, temp);
                            }
                        }
                        //开启分页
                        PageInfo<EcStory> info = new PageInfo<>(newList);

                        vo = new ResponseVo<>(1000, "success", info);
                    } else {
                        vo = ResponseVoUtil.setERROR("没有故事");
                    }
                    //获取带有

                    break;

                //查询出最热的故事
                case "最新":
                    PageHelper.startPage(pageNum, pageSize);
                    //获取最新故事
                    List<EcStory> putTimeList = mapper.selectWithPutTime();

                    if (putTimeList != null) {

                        List<EcStory> newList = storyUtil.getStory(putTimeList, list, listSee, listVote);

                        imgUtil.getListImgUrl(newList);

                        PageInfo<EcStory> info1 = new PageInfo<>(newList);

                        vo = new ResponseVo<>(1000, "success", info1);
                    } else {
                        vo = ResponseVoUtil.setERROR("没有故事");
                    }
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

        //验证token以及前段传来的参数
        if (jedisUtil.getHash(SystemCon.TOKENHASH,"token:" + token) != null && story != null) {


            if (fileName.length != 0) {

                List<EcStoryimg> list = new ArrayList<>();

                EcStoryimg storyimg = new EcStoryimg();
                //循环遍历将故事表的id添加到图片对象内
                for (String imgUrl : fileName) {

                    storyimg.setEcSimgurl(imgUrl);

                    storyimg.setStoryid(story.getEcSid());

                    list.add(storyimg);
                }
                //保存图片路径
              int i =  storyimgMapper.inserts(list);

                if (i > 0) {

                    return ResponseVoUtil.setOk("success");
                } else {

                    return ResponseVoUtil.setERROR("网络不知道去哪里了....");
                }

            }

            int i = mapper.insert(story);

            if (i == 1) {
                return ResponseVoUtil.setOk("success");
            } else {
                return ResponseVoUtil.setERROR("故事发布失败....");
            }

        } else {
            return ResponseVoUtil.setERROR("请填写内容");
        }

    }
}
