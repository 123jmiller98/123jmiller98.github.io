package edu.mcckc.dao;

import org.apache.log4j.*;

import java.sql.ResultSet;

public abstract class ABaseMapper
{
    private static Logger logger = Logger.getLogger(ABaseMapper.class);

    protected ResultSet rs;

    protected abstract Object mapSingleObject() throws Exception;

    public ABaseMapper()
    {
        this.rs = null;
    }

    public ABaseMapper(ResultSet rs)
    {
        this.rs = rs;
    }

    public int mapValidInt(String columnName)
    {
        int value;
        try
        {
            value = rs.getInt(columnName);

        } catch (Exception ex)
        {
            value = 0;
            logger.error(ex.getMessage());
        }

        return value;

    }


    public double mapValidDouble(String columnName)
    {
        double value;
        try
        {
            value = rs.getDouble(columnName);

        } catch (Exception ex)
        {
            value = 0;
            logger.error(ex.getMessage());
        }

        return value;
    }

    public String mapValidString(String columnName)
    {
        String value;
        try
        {
            value = rs.getString(columnName);

        } catch (Exception ex)
        {
            value = "";
            logger.error(ex.getMessage());
        }
        return value;
    }
}
