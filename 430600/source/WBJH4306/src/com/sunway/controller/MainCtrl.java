package com.sunway.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.service.BdcCqService;
import com.sunway.util.MakeUtil;
import com.sunway.vo.ChartJsVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "main")
public class MainCtrl {
    private static Logger logger = LogManager.getLogger(MainCtrl.class);
    @Autowired
    private BdcCqService cqService;

    @RequestMapping(value = "/view")
    public ModelAndView checkLogin(Authentication authentication, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/MainBoard");
        // 默认获取当前年份
        List<ChartJsVo> dataChart = cqService.getCountGroupMonthByYear(Integer.valueOf(MakeUtil.currentYear()));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        modelAndView.addObject("chartData", gson.toJson(dataChart));
        // 读取登录账户
        modelAndView.addObject("loginName", authentication.getName());
        logger.info("登录系统主界面");
        return modelAndView;
    }

    @RequestMapping(value = "/nopermit")
    public ModelAndView noPermit(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/PermitNo");
        return modelAndView;
    }

}
