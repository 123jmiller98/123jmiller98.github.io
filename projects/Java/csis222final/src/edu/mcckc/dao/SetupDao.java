package edu.mcckc.dao;

import org.apache.log4j.*;

import java.sql.SQLException;

public class SetupDao extends ABaseDao
{
    private static Logger logger = Logger.getLogger(SetupDao.class);

    public SetupDao() throws Exception
    {
        super();
    }

    public void createDatabaseTables() throws Exception
    {
        // we can create all the tables we need from here
        createProductTable();
        dbCleanup();

    }

    public void createProductTable()
    {
        try
        {
            conn.setAutoCommit(true);
            stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS CHECKS ");

            sql = "CREATE TABLE CHECKS " +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    " PAID_TO TEXT, " +
                    " AMOUNT REAL, " +
                    " ACCOUNT_NUMBER TEXT, " +
                    " SEQUENCE_NUMBER INTEGER, " +
                    " DATE TEXT); ";

            stmt.executeUpdate(sql);


            System.out.println("CHECKS table created successfully");
            logger.debug("CHECKS table created successfully");

        } catch (SQLException ex)
        {
            logger.error("SQLEX: " + ex.getMessage());

        } catch (Exception ex)
        {
            logger.error("EX: " + ex.getMessage());
        }

    }

}
