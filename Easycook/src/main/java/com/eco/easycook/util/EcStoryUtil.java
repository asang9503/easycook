package com.eco.easycook.util;

import com.eco.easycook.pojo.EcComment;
import com.eco.easycook.pojo.EcSee;
import com.eco.easycook.pojo.EcStory;
import com.eco.easycook.pojo.EcVote;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author:阿桑
 * Date:2018/12/10/010
 * Description: 内部使用严禁外泄
 */
@Component
public class EcStoryUtil {

    public List<EcStory> getStory(List<EcStory> lists, List<EcComment> list, List<EcSee> listSee, List<EcVote> listVote) {

        //判断故事是否为空
        if (lists.get(0) != null) {

            //循环遍历故事
            for (int i = 0; i < lists.size(); i++) {

                int storyId = lists.get(i).getEcSid();

                //判断评论是否为空
                if (list.get(0) != null) {
                    //根据故事id循环插入评论数量
                    for (int j = 0; j <list.size(); j++) {

                        int storyIds = list.get(j).getStoryId();

                        if (storyId == storyIds) {

                            lists.get(i).setEcCommentCount(list.get(j).getCounts());
                            break;
                        }
                    }

                }


                //判断点赞是否为空
                if (list.get(0) != null) {
                    //根据故事id循环插入点赞数量
                    for (int m = 0; m < listVote.size(); m++) {
                        int vStoryId = listVote.get(m).getStoryid();

                        if (storyId == vStoryId) {
                            lists.get(i).setEcVoteCount(listVote.get(m).getVoteCount());
                            break;
                        }
                    }

                }


                //判断观看是否为空
                if (list.get(0) != null) {
                    //根据故事id循环插入观看数量
                    for (int n = 0; n < listSee.size(); n++) {

                        int sStoryId = listSee.get(n).getEcSeestoryid();

                        if (storyId == sStoryId) {
                            lists.get(i).setSeeCount(listSee.get(n).getSeeCount());
                            break;
                        }
                    }

                }
            }

        }

        return lists;
    }
}
