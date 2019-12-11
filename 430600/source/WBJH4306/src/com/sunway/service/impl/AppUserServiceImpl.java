package com.sunway.service.impl;

import com.sunway.dao.AppUserDao;
import com.sunway.dao.BaseDao;
import com.sunway.entity.AppUser;
import com.sunway.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserDao appUserDao;

    @Override
    public AppUser getDataById(AppUser bean) {
        return appUserDao.getById(bean.getUsername());
    }

    @Override
    public List<AppUser> getAllData(AppUser bean, int pageIndex, int pageSize) {
        return appUserDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public boolean execDelete(AppUser bean) {
        boolean bRtn = true;
        try {
            appUserDao.execDelete(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execInsert(AppUser bean) {
        boolean bRtn = true;
        try {
            appUserDao.execInsert(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execUpdate(AppUser bean) {
        boolean bRtn = true;
        try {
            appUserDao.execUpdate(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execChangePwd(String uName, String oldPwd, String newPwd) {
        boolean bResult = false;
        AppUser user = (AppUser)appUserDao.getById(uName);
        if(uName.equals(user.getUsername()) && oldPwd.equals(user.getPassword())){
            user.setPassword(newPwd);
            appUserDao.execUpdate(user);
            bResult = true;
        }
        return bResult;
    }
}
