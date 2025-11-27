package com.healthcare.dao;

import java.util.List;

public interface DAO<T> {
    T findById(int id) throws Exception;
    List<T> findAll() throws Exception;
    boolean save(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(int id) throws Exception;
}
