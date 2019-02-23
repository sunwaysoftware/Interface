package com.sunway.dao;

public interface BaseDao {

    public Object getDataById(Class pClass ,String id);
    public boolean execUpdate(Object bean);
    public boolean execInsert(Object bean);
    public boolean execDelete(Object bean);

}
