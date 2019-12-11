package com.sunway.dao;

import java.io.Serializable;

public interface BaseDao<T> {

    public T getById(Serializable id);
    public void execDelete(T t);
    public void execUpdate(T t);
    public void execInsert(T t);

}
