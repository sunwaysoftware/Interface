package com.sunway.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.entity.TaxShxx;
import com.sunway.service.TaxShjgDictService;
import com.sunway.service.TaxShxxService;
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
@RequestMapping(value = "/tax/sh")
public class TaxShxxCtrl {
    private static Logger log = LogManager.getLogger(TaxShxxCtrl.class);

    @Autowired
    private TaxShxxService taxShxxService;
    @Autowired
    private TaxShjgDictService taxShjgDictService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("TaxShView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request, TaxShxx pageBean){
        if(null==pageBean.getShsj())
            pageBean.setShsj(DateUtil.getNowDate());
        List<TaxShxx> tsxxList = taxShxxService.getAllData(pageBean,1, 500);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(tsxxList);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/crud")
    public String saveData(HttpServletRequest request, TaxShxx pageBean){
        boolean bRtn = false;
        bRtn = taxShxxService.execInsert(pageBean);
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/crud")
    public String editData(HttpServletRequest request, TaxShxx pageBean){
        boolean bRtn = false;
        bRtn = taxShxxService.execUpdate(pageBean);
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/crud/{id}")
    public String deleteData(@PathVariable String id){
        boolean bRtn = false;
        bRtn = taxShxxService.execDelete(new TaxShxx(id));
        return String.valueOf(bRtn);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud/{id}")
    public ModelAndView gotoEditPage(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("TaxShEdit");
        modelAndView.addObject("shjgList", taxShjgDictService.getAllData());
        TaxShxx tsxx = new TaxShxx(id);
        tsxx = taxShxxService.getDataById(tsxx);
        if(tsxx !=null && !tsxx.getYwh().isEmpty()){
            modelAndView.addObject("vo", tsxx);
            modelAndView.addObject("method",  "<input type=\"hidden\" name=\"_method\" value=\"PUT\"/>");
        }
        return modelAndView;
    }
}
