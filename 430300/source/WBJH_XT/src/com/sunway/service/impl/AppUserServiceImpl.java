package com.sunway.service.impl;

import com.sunway.dao.AppUserDao;
import com.sunway.dao.BaseDao;
import com.sunway.entity.AppUser;
import com.sunway.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private AppUserDao appUserDao;

    @Override
    public AppUser getDataById(AppUser bean) {
        return appUserDao.getDataById(bean);
    }

    @Override
    public List<AppUser> getAllData(AppUser bean, int pageIndex, int pageSize) {
        return appUserDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public boolean execDelete(AppUser bean) {
        return appUserDao.execDelete(bean);
    }

    @Override
    public boolean execInsert(AppUser bean) {
        return appUserDao.execInsert(bean);
    }

    @Override
    public boolean execUpdate(AppUser bean) {
        return appUserDao.execUpdate(bean);
    }

    @Override
    public boolean execChangePwd(String uName, String oldPwd, String newPwd) {
        boolean bResult = false;
        AppUser user = (AppUser)baseDao.getDataById(AppUser.class, uName);
        if(uName.equals(user.getUsername()) && oldPwd.equals(user.getPassword())){
            user.setPassword(newPwd);
            bResult = baseDao.execUpdate(user);
        }
        return bResult;
    }
}
