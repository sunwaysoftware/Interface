package com.sunway.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.entity.TaxWsxx;
import com.sunway.service.TaxWsxxService;
import com.sunway.util.DateUtil;
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
@RequestMapping(value = "/tax/ws")
public class TaxWsxxCtrl {

	@Autowired
    private TaxWsxxService taxWsxxService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("TaxWsView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request, TaxWsxx pageBean){
        if(null==pageBean.getWsrq())
            pageBean.setWsrq(DateUtil.getNowDate());
        List<TaxWsxx> wsxxList = taxWsxxService.getAllData(pageBean,1, 500);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(wsxxList);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/crud")
    public String saveData(HttpServletRequest request, TaxWsxx pageBean){
        boolean bRtn = false;
        bRtn = taxWsxxService.execInsert(pageBean);
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/crud")
    public String editData(HttpServletRequest request, TaxWsxx pageBean){
        boolean bRtn = false;
        bRtn = taxWsxxService.execUpdate(pageBean);
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/crud/{id}")
    public String deleteData(@PathVariable String id){
        boolean bRtn = false;
        bRtn = taxWsxxService.execDelete(new TaxWsxx(id));
        return String.valueOf(bRtn);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud/{id}")
    public ModelAndView gotoEditPage(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("TaxWsEdit");
        TaxWsxx wsxx = new TaxWsxx(id);
        wsxx = taxWsxxService.getDataById(wsxx);
        if(wsxx != null && !wsxx.getId().isEmpty()){
            modelAndView.addObject("vo", wsxx);
            modelAndView.addObject("method",  "<input type=\"hidden\" name=\"_method\" value=\"PUT\"/>");
        }
        return modelAndView;
    }
}
