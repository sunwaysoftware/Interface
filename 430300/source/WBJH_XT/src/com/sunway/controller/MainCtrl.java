package com.sunway.controller;

import com.sunway.service.BdcFwsxService;
import com.sunway.util.MakeUtil;
import org.apache.log4j.MDC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "main")
public class MainCtrl {
    private static Logger logger = LogManager.getLogger(MainCtrl.class);
    @Autowired
    private BdcFwsxService fwsxService;

    @RequestMapping(value = "/view")
    public ModelAndView checkLogin(Authentication authentication, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/MainBoard");
        MDC.put("uID", authentication.getName());
        MDC.put("uIP", request.getRemoteAddr());
        // 默认获取当前年份
        List<Double> dataChart = fwsxService.getCountGroupMonthByYear(Integer.valueOf(MakeUtil.currentYear()));
        modelAndView.addObject("chartData", dataChart);
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
