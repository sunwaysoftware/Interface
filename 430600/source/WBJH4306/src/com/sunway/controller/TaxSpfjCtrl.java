package com.sunway.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.entity.TaxSpfj;
import com.sunway.service.TaxSpfjService;
import com.sunway.util.DateUtil;
import com.sunway.util.MakeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "tax/fj")
public class TaxSpfjCtrl {
    private static Logger logger = LogManager.getLogger(TaxSpfjCtrl.class);
    @Autowired
    private TaxSpfjService taxSpfjService;
    private static String uploadPath = "/uploadFiles/tax/";

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public ModelAndView gotoViewPage(HttpServletRequest request) {
        logger.info("{}跳转进入【税票附件】页面", request.getRemoteUser());
        ModelAndView modelAndView = new ModelAndView("TaxFjView");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/viewlist", produces = "text/html;charset=UTF-8")
    public String loadView(HttpServletRequest request, TaxSpfj pageBean) {
        if (null == pageBean.getSprq())
            pageBean.setSprq(DateUtil.getNowDate());
        List<TaxSpfj> bList = taxSpfjService.getAllData(pageBean, 1, 500);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(bList);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/crud")
    public String saveData(HttpServletRequest request, TaxSpfj pageBean, @RequestParam(value = "file", required = false) CommonsMultipartFile file) {
        boolean bRtn = false;
        try {
            pageBean = uploadFile(request, file, pageBean);
            taxSpfjService.execInsert(pageBean);
            bRtn = true;
        } catch (Exception e) {
            logger.error("保存时异常：", e);
        }
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/crud")
    public String editData(HttpServletRequest request, TaxSpfj pageBean, @RequestParam(value = "file", required = false) CommonsMultipartFile file) {
        boolean bRtn = false;
        try {
            //------- 删除原有上传文件 -------------
            String absPath = request.getServletContext().getRealPath(uploadPath + pageBean.getLjdz());
            File delFile = new File(absPath);
            delFile.delete();
            //--------------------------------------
            pageBean = uploadFile(request, file, pageBean);
            taxSpfjService.execUpdate(pageBean);
            bRtn = true;
        } catch (Exception e) {
            logger.error("更新时异常：", e);
        }
        return String.valueOf(bRtn);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/crud/{id}")
    public String deleteData(HttpServletRequest request, @PathVariable String id) {
        boolean bRtn = false;
        try{
            TaxSpfj bean = new TaxSpfj(id);
            bean = taxSpfjService.getDataById(bean);
            String absPath = request.getServletContext().getRealPath(uploadPath + bean.getLjdz());
            File delFile = new File(absPath);
            taxSpfjService.execDelete(new TaxSpfj(id));
            delFile.delete();
            bRtn = true;
        } catch (Exception e) {
            logger.error("删除时异常：", e);
        }
        return String.valueOf(bRtn);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud/{id}")
    public ModelAndView gotoEditPage(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("TaxFjEdit");
        TaxSpfj bean = new TaxSpfj(id);
        bean = taxSpfjService.getDataById(bean);
        if (bean != null && !bean.getYwh().isEmpty()) {
            modelAndView.addObject("vo", bean);
            modelAndView.addObject("method", "<input type=\"hidden\" name=\"_method\" value=\"PUT\"/>");
        }
        return modelAndView;
    }

    /**
     * 保存上传的文件
     * @param request
     */
    private TaxSpfj uploadFile(HttpServletRequest request, CommonsMultipartFile file, TaxSpfj pageBean) {
        String fileNm = System.currentTimeMillis()+ "_" + file.getOriginalFilename();
        String filePath = String.format("TAX%s/TAX%s", MakeUtil.currentMonthF(), fileNm);
        String absPath = request.getServletContext().getRealPath(uploadPath + filePath);
        try {
            File newFile = new File(absPath);
            file.transferTo(newFile);
            pageBean.setFilename(fileNm);
            pageBean.setLjdz(filePath);
        } catch (IOException e) {
            logger.error("上传文件失败！", e);
        } finally {

        }
        return pageBean;
    }
}
