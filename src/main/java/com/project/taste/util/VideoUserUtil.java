package com.project.taste.util;

import com.project.taste.bo.Video_User;
import com.project.taste.model.User;
import com.project.taste.service.UserService;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VideoUserUtil {

    public static Video_User put(SolrDocument obj, UserService userService) throws ParseException {
        Video_User video_user = new Video_User();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", java.util.Locale.US);
        video_user.setVideoId((obj.get("id").toString()));
        video_user.setVideoTitle(obj.get("videoTitle").toString());
        video_user.setVideoCategoryId(obj.get("videoCategoryId").toString());
        video_user.setVideoTime(sdf.parse(obj.get("videoTime").toString()));
        video_user.setVideoStatus(Integer.valueOf(obj.get("videoStatus").toString()));
        video_user.setVideoContent(obj.get("videoContent").toString());
        video_user.setVideoUrl(obj.get("videoUrl").toString());
        video_user.setVideoUserId(obj.get("videoUserId").toString());
        User user = userService.selectById(obj.get("videoUserId").toString());
        video_user.setUser(user);
        return video_user;
    }

}
