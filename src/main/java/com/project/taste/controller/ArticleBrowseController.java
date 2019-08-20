package com.project.taste.controller;

import com.project.taste.service.ArticleBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleBrowseController {
    @Autowired
    ArticleBrowseService articleBrowseService;

}
