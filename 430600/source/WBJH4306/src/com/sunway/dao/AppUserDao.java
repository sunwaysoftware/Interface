package com.sunway.dao;

import com.sunway.entity.AppUser;

import java.util.List;

public interface AppUserDao extends BaseDao<AppUser> {

    public List<AppUser> getAllData(AppUser bean, int pageIndex, int pageSize);

}
