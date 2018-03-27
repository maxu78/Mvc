package com.mx.controller;

import com.mx.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    @ResponseBody
    public Object index() throws Exception {
        System.out.println(indexService.index1());
        return indexService.index();
    }
}
