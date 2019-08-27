package com.project.taste.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.taste.bo.Page;
import com.project.taste.bo.Video_User;
import com.project.taste.model.User;
import com.project.taste.model.Video;
import com.project.taste.service.UserService;
import com.project.taste.service.impl.VideoServiceImpl;
import com.project.taste.util.*;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/video")
@Api(tags = "视频控制器")
public class VideoController {
    @Autowired
    VideoServiceImpl videoService;
    @Autowired
    UserService userService;
    HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://106.13.207.98:9091/solr/video").build();

    //增量
    String deltaImport = "http://106.13.207.98:9091/solr/video/dataimport?command=delta-import&verbose=false&clean=false&commit=true&optimize=false&core=taste&name=dataimport";

    //全量
    String fullImport = "http://106.13.207.98:9091/solr/video/dataimport?command=full-import&verbose=false&clean=true&commit=true&optimize=false&core=taste&name=dataimport";


    /**
     * 查询所有视频
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryall")
    public Object queryVideoAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        JsonResult result=null;
        try{
            String update = HttpClientHelper.sendPost(deltaImport);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery("*:*");
            solrQuery.setRows(videoService.selectVideoNum());
            solrQuery.addSort("videoTime", SolrQuery.ORDER.desc);
            QueryResponse response = httpSolrClient.query(solrQuery);
            List list = new ArrayList<>();
            SolrDocumentList results = response.getResults();
            for (SolrDocument obj : results){
                Video_User video_user = VideoUserUtil.put(obj, userService);
                list.add(video_user);
            }
            ListPageUtil listPageUtil = new ListPageUtil(list,pageNum,pageSize);
            Page page = new Page();
            page.setLastPage(listPageUtil.getLastPage());
            page.setNextPage(listPageUtil.getNextPage());
            page.setNowPage(listPageUtil.getNowPage());
            page.setPageSize(listPageUtil.getPageSize());
            page.setTotalCount(listPageUtil.getTotalCount());
            page.setTotalPage(listPageUtil.getTotalPage());
            page.setPagedList(listPageUtil.getPagedList());
            if(results.size()>0 && results!=null){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",page);
            }else {
                result = new JsonResult(Constants.STATUS_FAIL, "查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常"+e.getMessage());
        }
        return result;
    }

    /**
     * 根据用户ID查询该用户上传的视频数量
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/qyerynum/userid")
    public Object queryVideoNum(String userId){
        JsonResult result=null;
        try{
            int num=videoService.queryVideoNum(userId);
            if(num!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",num);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 根据视频ID查询视频详情
     * @param videoId
     * @return
     */
    @ResponseBody
    @RequestMapping("/querybyid")
    public Object queryVideoById(String videoId){
        JsonResult result=null;
        try{
            Video video=videoService.queryVideoById(videoId);
            if(video!=null){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",video);
            }else {
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 根据用户id查询用户上传所有视频
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/query/userid")
    public Object queryVideoAllByid(@Param("userId") String userId,@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "8") Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Video> list = videoService.queryVideoAllByid(userId);
            PageInfo pageInfo = new PageInfo(list);
            if(list.size()>0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",pageInfo);
            }else{
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return result;
    }

    /**
     * 根据视频标题查询视频
     * @param video
     * @return
     */
    @ResponseBody
    @RequestMapping("/querybytitle")
    public Object selectByPrimaryKey(Video video, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        JsonResult result=null;
        try{
            HttpClientHelper.sendPost(deltaImport);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setRows(videoService.selectVideoNum());
            solrQuery.addSort("videoTime", SolrQuery.ORDER.desc);
            solrQuery.set("q", video.getVideoTitle());
            //默认域
            solrQuery.set("df", "videoTitle");
            //高亮
            //打开开关
            solrQuery.setHighlight(true);
            //指定高亮域
            solrQuery.addHighlightField("videoTitle,videoContent");
            //设置前缀
            solrQuery.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            solrQuery.setHighlightSimplePost("</span>");
            QueryResponse response = httpSolrClient.query(solrQuery);
            Map<String, Map<String, List<String>>> highlight = response.getHighlighting();
            List<Map<String, Object>> list = new ArrayList<>();
            SolrDocumentList results = response.getResults();
            for (SolrDocument obj : results){
                obj.put("highlight",highlight.get(obj.get("id")));
                list.add(obj);
            }
            ListPageUtil listPageUtil = new ListPageUtil(list,pageNum,pageSize);
            if(results.size()>0 && results!=null){
                result=new JsonResult(Constants.STATUS_SUCCESS,"查询成功",listPageUtil);
            }else {
                result=new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"暂无数据");
        }
        return result;
    }


    /**
     * 添加视频
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(Video video){
        JsonResult result=null;
        try{
            int s=videoService.insertSelective(video);
            if(s!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"添加成功",s);
            }else {
                result=new JsonResult(Constants.STATUS_FAIL,"添加失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"添加异常");
        }
        return result;
    }

    /**
     * 删除视频
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object updateByPrimaryKey(String videoId){
        JsonResult result=null;
        try{
            int s=videoService.updateByPrimaryKey(videoId);
            if(s!=0){
                result=new JsonResult(Constants.STATUS_SUCCESS,"删除成功",s);
            }else {
                result=new JsonResult(Constants.STATUS_FAIL,"删除失败");
            }
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"删除异常");
        }
        return result;
    }

    /**
     * 根据类别ID查视频
     */
    @ResponseBody
    @RequestMapping("/select/categoryid")
    public JsonResult selectByCategoryId(String videoCategoryId, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize){
        JsonResult js;
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<Video> list = videoService.selectAllByCategoryId(videoCategoryId);
            PageInfo pageInfo = new PageInfo(list);
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功", pageInfo);
            }else {
                js = new JsonResult(Constants.STATUS_FAIL,"查询失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 查询视频数量
     */
    @ResponseBody
    @RequestMapping("/select/num")
    public JsonResult selectVideoNum(){
        JsonResult js;
        try{
            int i = videoService.selectVideoNum();
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",i);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

    /**
     * 根据日期查数量
     * @return
     */
    @ResponseBody
    @RequestMapping("/select/bytime")
    public JsonResult selectByTime(){
        JsonResult js;
        try{
            List list = videoService.selectNumByTime();
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            js = new JsonResult(Constants.STATUS_ERROR,"查询异常");
        }
        return js;
    }

}

