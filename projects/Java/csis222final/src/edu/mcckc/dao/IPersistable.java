package edu.mcckc.dao;

import java.util.List;

public interface IPersistable
{

    public Check saveOne(Object obj) throws Exception;
    public Object selectOne(Object obj) throws Exception;
    public void deleteOne(Object obj) throws Exception;

    public void saveMany(List<Object> objList) throws Exception;
    public List<Object> selectMany(Object obj) throws Exception;
    public void deleteMany(List<Object> objList) throws Exception;

}
