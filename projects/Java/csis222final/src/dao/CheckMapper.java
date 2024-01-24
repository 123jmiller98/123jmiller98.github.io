package edu.mcckc.dao;

import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class CheckMapper extends ABaseMapper
{
    private static Logger logger = Logger.getLogger(CheckMapper.class);

    public CheckMapper()
    {
        super();
    }

    public CheckMapper(ResultSet rs)
    {
        super(rs);
    }

    @Override
    protected Object mapSingleObject() throws Exception
    {
        Check rtnObj = null;

        int id = mapValidInt("ID");
        String paidTo = mapValidString("PAID_TO");
        double amount = mapValidDouble("AMOUNT");
        String accountNumber = mapValidString("ACCOUNT_NUMBER");
        int sequenceNumber = mapValidInt("SEQUENCE_NUMBER");
        String date = mapValidString("DATE");

        try
        {
            rtnObj = new Check(id,paidTo,amount,accountNumber,sequenceNumber,date);
            logger.debug("DB PRODUCT: " + rtnObj.toString());

        }catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }


        return rtnObj;
    }
}
