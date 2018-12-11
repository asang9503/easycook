package com.eco.easycook.util;

import com.eco.easycook.ResponseVo.ResponseVo;
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


        for (int i = 0; i < lists.size(); i++) {

            int storyId = lists.get(i).getEcSid();

            for (int j = 0; j <list.size(); j++) {

                int storyIds = list.get(j).getStoryId();

                if (storyId == storyIds) {

                    lists.get(i).setEcCommentCount(list.get(j).getCounts());
                    break;
                }
            }
            for (int m = 0; m < listVote.size(); m++) {
                int vStoryId = listVote.get(m).getStoryid();

                if (storyId == vStoryId) {
                    lists.get(i).setEcVoteCount(listVote.get(m).getVoteCount());
                    break;
                }
            }

            for (int n = 0; n < listSee.size(); n++) {
                int sStoryId = listSee.get(n).getEcSeestoryid();

                if (storyId == sStoryId) {
                    lists.get(i).setSeeCount(listSee.get(n).getSeeCount());
                    break;
                }
            }


        }

        return lists;
    }
}
