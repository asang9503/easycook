package com.eco.easycook.util;

import com.eco.easycook.pojo.EcStory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:阿桑
 * Date:2018/12/13/013
 * Description: 内部使用严禁外泄
 */

@Component
public class StringImgToListImg {

    public List<EcStory> getListImgUrl(List<EcStory> storyList) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < storyList.size(); i++) {

            if (storyList.get(i).getImgs() != null) {
                String url = storyList.get(i).getImgs().getEcSimgurl();

                String[] urls = url.split(",");

                for (String img : urls) {

                    list.add(img);
                }
            }
            storyList.get(i).setImg(list);
        }

        return storyList;
    }

}
