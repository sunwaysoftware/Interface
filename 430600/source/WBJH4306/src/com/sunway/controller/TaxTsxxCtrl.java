package com.sunway.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.entity.TaxTsxx;
import com.sunway.service.TaxTsxxService;
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
@RequestMapping(value = "/tax/ts")
public class TaxTsxxCtrl {

    @Autowired
    private TaxTsxxService TaxTsxxService;

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("TaxTsView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request, TaxTsxx pageBean){
        if(null==pageBean.getTssj())
            pageBean.setTssj(DateUtil.getNowDate());
        List<TaxTsxx> tsxxList = TaxTsxxService.getAllData(pageBean,1, 500);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(tsxxList);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/crud")
    public String saveData(HttpServletRequest request, TaxTsxx pageBean){
        boolean bRtn = false;
        bRtn = TaxTsxxService.execInsert(pageBean);
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/crud")
    public String editData(HttpServletRequest request, TaxTsxx pageBean){
        boolean bRtn = false;
        bRtn = TaxTsxxService.execUpdate(pageBean);
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/crud/{id}")
    public String deleteData(@PathVariable String id){
        boolean bRtn = false;
        bRtn = TaxTsxxService.execDelete(new TaxTsxx(id));
        return String.valueOf(bRtn);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud/{id}")
    public ModelAndView gotoEditPage(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("TaxTsEdit");
        TaxTsxx tsxx = new TaxTsxx(id);
        tsxx = TaxTsxxService.getDataById(tsxx);
        if(tsxx !=null && !tsxx.getYwh().isEmpty()){
            modelAndView.addObject("statusYHW", "readonly");
            modelAndView.addObject("vo", tsxx);
            modelAndView.addObject("method",  "<input type=\"hidden\" name=\"_method\" value=\"PUT\"/>");
        }
        return modelAndView;
    }
    
}
