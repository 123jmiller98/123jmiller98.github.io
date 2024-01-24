package edu.mcckc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

public class CheckDao extends ABaseDao implements IPersistable
{

    private static Logger logger = Logger.getLogger(CheckDao.class);

    private final String SELECT_ONE_SQL =   " SELECT ID, PAID_TO, AMOUNT, ACCOUNT_NUMBER, SEQUENCE_NUMBER, DATE " +
                                            " FROM CHECKS " +
                                            " WHERE ID = ?;";

    private final String SELECT_MAX_PK = "SELECT MAX(ID) FROM CHECKS; ";

    private final String SELECT_MANY_SQL =  " SELECT ID, PAID_TO, AMOUNT, ACCOUNT_NUMBER, SEQUENCE_NUMBER, DATE " +
                                            " FROM CHECKS " +
                                            " WHERE PAID_TO LIKE ?;";
    private final String INSERT_SQL =        " INSERT INTO CHECKS " +
                                            " (PAID_TO, AMOUNT, ACCOUNT_NUMBER, SEQUENCE_NUMBER, DATE) " +
                                            " VALUES " +
                                            " (?, ?, ?, ?, ?);   SELECT last_insert_rowid();";

    // this extra SELECT in the INSERT string grabs the value of the primary key that was autoincremented

    private final String UPDATE_SQL =   " UPDATE CHECKS " +
                                        " SET PAID_TO = ?, " +
                                        " AMOUNT = ?, " +
                                        " ACCOUNT_NUMBER = ?, " +
                                        " SEQUENCE_NUMBER = ?, " +
                                        " DATE = ? " +
                                        " WHERE ID = ?;";
    private final String DELETE_SQL =   " DELETE FROM CHECKS " +
                                        " WHERE ID = ?;";


    public Connection getConnection()
    {
        return conn;
    }

    public int selectMaxPk() throws Exception
    {
        int primaryKey = 0;
        createDBConnection();
        logger.debug("GETTING MAX PRIMARY KEY");

        try
        {
            sql = SELECT_MAX_PK;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                primaryKey = rs.getInt(1);
            }

            return primaryKey;

        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        } finally
        {
            dbCleanup();
        }
    }

    public CheckDao() throws Exception
    {
        super();
    }

    @Override
    public Check saveOne(Object obj) throws Exception
    {
        int id = 0;
        createDBConnection();
        Check tempObj = (Check)obj;
        logger.debug("SAVING: " + tempObj.toString());

        try
        {
            if (tempObj.getId() > 0 )
            {
                sql = UPDATE_SQL;
            }else
            {
                sql = INSERT_SQL;
            }

            ps = conn.prepareStatement(sql);
            ps.setString(1,tempObj.getPaidTo());
            ps.setDouble(2, tempObj.getCheckAmount());
            ps.setString(3,tempObj.getAccountNumber());
            ps.setInt(4,tempObj.getSequenceNumber());
            ps.setString(5,tempObj.getCheckDate());

            if (tempObj.getId() > 0 )
            {
                ps.setInt(6,tempObj.getId());
            }

            conn.setAutoCommit(true);
            ps.executeUpdate();


            // can use to get and return PK
            if(tempObj.getId()<=0)
            {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next())
                {
                    id = rs.getInt(1);
                    System.out.println(id);
                }

                tempObj.setId(id);
            }

            int count = ps.getUpdateCount();
            logger.debug("# ROWS affected: " + count);
            logger.debug("PRODUCT saved successfully");
            return tempObj;

        }catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }finally
        {
            dbCleanup();
        }


    }

    @Override
    public Object selectOne(Object obj) throws Exception
    {
        createDBConnection();
        Check tempObj = (Check) obj;
        Check rtnObj = null;
        CheckMapper mapper = null;
        logger.debug("GETTING PRODUCT with ID = " + tempObj.getId());

        try
        {
            sql = SELECT_ONE_SQL;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tempObj.getId());

            rs = ps.executeQuery();
            mapper = new CheckMapper(rs);

            while (rs.next())
            {
                rtnObj = (Check)mapper.mapSingleObject();
                logger.debug("GOT PRODUCT: " + rtnObj.toString());
            }


        }catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }finally
        {
            dbCleanup();
        }

        return rtnObj;
    }

    @Override
    public void deleteOne(Object obj) throws Exception
    {
        createDBConnection();
        Check tempObj = (Check)obj;
        logger.debug("DELETING: " + tempObj.toString());

        try
        {
            sql = DELETE_SQL;

            ps = conn.prepareStatement(sql);

            ps.setInt(1, tempObj.getId());

            conn.setAutoCommit(true);
            ps.executeUpdate();

            int count = ps.getUpdateCount();
            logger.debug("# ROWS affected: " + count);
            logger.debug("PRODUCT deleted successfully");

        }catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }finally
        {
            dbCleanup();
        }

    }

    @Override
    public void saveMany(List<Object> objList) throws Exception
    {

    }

    @Override
    public List<Object> selectMany(Object obj) throws Exception
    {
        createDBConnection();
        List<Object> objList = new ArrayList<Object>();
        Check tempObj = (Check) obj;
        Check rtnObj = null;
        CheckMapper mapper = null;
        logger.debug("GETTING PRODUCTS with NAME LIKE " + tempObj.getId());

        try
        {
            sql = SELECT_MANY_SQL;
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tempObj.getPaidTo() + "%");

            rs = ps.executeQuery();
            mapper = new CheckMapper(rs);

            while (rs.next())
            {
                rtnObj = (Check)mapper.mapSingleObject();
                objList.add(rtnObj);
                logger.debug("GOT PRODUCT: " + rtnObj.toString());
            }


        }catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }finally
        {
            dbCleanup();
        }

        return objList;
    }

    @Override
    public void deleteMany(List<Object> objList) throws Exception
    {

    }
}
