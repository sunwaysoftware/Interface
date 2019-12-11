package com.sunway.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.entity.BdcCq;
import com.sunway.entity.BdcQlr;
import com.sunway.service.BdcCqService;
import com.sunway.service.BdcQlrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/bdc/cq")
public class BdcCqCtrl {
    @Autowired
    private BdcCqService bdcCqService;
    @Autowired
    private BdcQlrService bdcQlrService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("BdcCqView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request, BdcCq pageBean){
        List<BdcCq> cqList = bdcCqService.getAllData(pageBean,1, 500);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(cqList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud/{id}")
    public ModelAndView gotoEditPage(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("BdcCqEdit");
        BdcCq cq = bdcCqService.getDataById(new BdcCq(id));
        BdcQlr qlr = new BdcQlr();
        qlr.setYwh(cq.getYwh());
        List<BdcQlr> qlrs = bdcQlrService.getDataByYwh(qlr);
        modelAndView.addObject("vo", cq);
        modelAndView.addObject("voQlr", qlrs);
        return modelAndView;
    }    
    
}
