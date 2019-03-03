package com.sunway.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.entity.BdcQlr;
import com.sunway.entity.BdcZdsx;
import com.sunway.service.BdcQlrService;
import com.sunway.service.BdcZdsxService;
import com.sunway.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping(value = "/bdc/zd")
public class BdcZdsxCtrl {

    private static Logger log = LogManager.getLogger(AppUserCtrl.class);
    @Autowired
    private BdcZdsxService bdcZdsxService;
    @Autowired
    private BdcQlrService bdcQlrService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("BdcZdsxView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request, BdcZdsx pageBean){
        List<BdcZdsx> fwsxList = bdcZdsxService.getAllData(pageBean,1, 500);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(fwsxList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud/{id}")
    public ModelAndView gotoEditPage(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("BdcZdsxEdit");
        BdcZdsx zd = bdcZdsxService.getDataById(new BdcZdsx(id));
        BdcQlr qlr = new BdcQlr();
        qlr.setYwh(zd.getYwh());
        List<BdcQlr> qlrs = bdcQlrService.getDataByYwh(qlr);
        modelAndView.addObject("vo", zd);
        modelAndView.addObject("voQlr", qlrs);
        return modelAndView;
    }
}
