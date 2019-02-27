package com.sunway.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.entity.BdcFwsx;
import com.sunway.service.BdcFwsxService;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/bdc/fw")
public class BdcFwsxCtrl {
    private static Logger log = LogManager.getLogger(AppUserCtrl.class);
    @Autowired
    private BdcFwsxService bdcFwsxService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("BdcFwsxView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request, BdcFwsx pageBean){
        List<BdcFwsx> fwsxList = bdcFwsxService.getAllData(pageBean,1, 500);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(fwsxList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud/{id}")
    public ModelAndView gotoEditPage(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("BdcFwsxEdit");
        BdcFwsx tmp = bdcFwsxService.getDataById(new BdcFwsx(id));
        modelAndView.addObject("vo", tmp);
        return modelAndView;
    }
}
