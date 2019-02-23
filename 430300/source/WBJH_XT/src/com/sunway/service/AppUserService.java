package com.sunway.service;

import com.sunway.entity.AppUser;

import java.util.List;

public interface AppUserService {
    public AppUser getDataById(AppUser bean);

    public List<AppUser> getAllData(AppUser bean, int pageIndex, int pageSize);

    public boolean execDelete(AppUser bean);

    public boolean execInsert(AppUser bean);

    public boolean execUpdate(AppUser bean);

    /**
     * 修改用户密码
     * @param uName 用户名
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return 是否成功
     */
    public boolean execChangePwd(String uName, String oldPwd, String newPwd);
}
