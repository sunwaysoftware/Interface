package com.sunway.controller;

import com.google.gson.Gson;
import com.sunway.entity.AppAuthority;
import com.sunway.entity.AppUser;
import com.sunway.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/sys/users")
public class AppUserCtrl {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("UsersView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request) {
        AppUser user = new AppUser();
        List<AppUser> userList = appUserService.getAllData(user, 1, 500);
        Gson gson = new Gson();
        String tmp = gson.toJson(userList);
        return tmp;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/crud")
    public String saveData(HttpServletRequest request, AppUser uBean) {
        boolean bRtn = false;
        String[] roles = request.getParameterValues("authority");
        if (null != roles) {
            for (int i = 0; i < roles.length; i++) {
                AppAuthority au = new AppAuthority();
                au.setAuthority(roles[i]);
                uBean.getRoles().add(au);
                au = null;
            }
        }
        bRtn = appUserService.execInsert(uBean);
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/crud")
    public String editData(HttpServletRequest request, AppUser uBean) {
        boolean bRtn = false;
        String[] roles = request.getParameterValues("authority");
        if (null != roles) {
            for (int i = 0; i < roles.length; i++) {
                AppAuthority au = new AppAuthority();
                au.setAuthority(roles[i]);
                uBean.getRoles().add(au);
                au = null;
            }
        }
        bRtn = appUserService.execUpdate(uBean);
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/crud/{id}")
    public String deleteData(@PathVariable String id) {
        boolean bRtn = false;
        bRtn = appUserService.execDelete(new AppUser(id));
        return String.valueOf(bRtn);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud/{id}")
    public ModelAndView gotoEditPage(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("UsersEdit");
        AppUser user = new AppUser(id);
        user = appUserService.getDataById(user);
        if (user != null && !user.getUsername().isEmpty()) {
            modelAndView.addObject("statusYHW", "readonly");
            modelAndView.addObject("vo", user);
            modelAndView.addObject("method", "<input type=\"hidden\" name=\"_method\" value=\"PUT\"/>");
        }
        return modelAndView;
    }

}
