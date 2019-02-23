package com.sunway.dao;

import com.sunway.entity.AppUser;

import java.util.List;

public interface AppUserDao {

    public AppUser getDataById(AppUser bean);

    public List<AppUser> getAllData(AppUser bean, int pageIndex, int pageSize);

    public boolean execDelete(AppUser bean);

    public boolean execInsert(AppUser bean);

    public boolean execUpdate(AppUser bean);
}
