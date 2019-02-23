package com.sunway.controller;

import com.sunway.entity.AppUser;
import com.sunway.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/pwd")
public class AppUserPwdCtrl {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoChangePwd(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("UsersPwd");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelAndView.addObject("userid", userDetails.getUsername());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/crud")
    public String execChangePwd(HttpServletRequest request, AppUser uBean, @RequestParam("newPwd") String newPwd) {
        boolean bRtn = false;
        bRtn = appUserService.execChangePwd(uBean.getUsername(), uBean.getPassword(), newPwd);
        return String.valueOf(bRtn);
    }
}
