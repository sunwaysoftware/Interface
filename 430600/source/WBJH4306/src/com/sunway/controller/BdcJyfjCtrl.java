/**
 * 
 */
package com.sunway.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.entity.BdcJyfj;
import com.sunway.service.BdcJyfjService;
import com.sunway.util.DateUtil;

/**
 * @author andy.gao
 *
 */
@Controller
@RequestMapping(value = "/bdc/fj")
public class BdcJyfjCtrl {
    private static Logger logger = LogManager.getLogger(BdcJyfjCtrl.class);
    @Autowired
    private BdcJyfjService bdcJyfjService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request){
        logger.info("{}跳转进入【交易附件】页面", request.getRemoteUser());
        ModelAndView modelAndView = new ModelAndView("BdcJyfjView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request, BdcJyfj pageBean){
        List<BdcJyfj> jyfjList = bdcJyfjService.getAllData(pageBean,1, 500);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(jyfjList);
    }

	
	
	
}
