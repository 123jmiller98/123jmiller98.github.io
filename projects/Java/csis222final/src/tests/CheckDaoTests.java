package edu.mcckc.tests;

import edu.mcckc.dao.*;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckDaoTests
{


    @Test
    public void t00_testDaoMaxPrimaryKey()
    {
        try
        {
            CheckDao dao = new CheckDao();
            int pk = dao.selectMaxPk();
            Assert.assertTrue(pk>0);
        } catch (Exception ex)
        {
            Assert.assertTrue(false);
        }

    }


    @Test
    public void t01_testDaoConsructor()
    {
        try
        {
            CheckDao dao = new CheckDao();
            Assert.assertNotNull(dao.getConnection());
            Assert.assertNotNull(dao);
        } catch (Exception ex)
        {
            Assert.assertTrue(false);
        }

    }


    @Test
    public void t02_testDaoInsert()
    {
        try
        {
            CheckDao dao = new CheckDao();
            Check check = new Check(-1, "Payless", 1.23, "12345", 1234,"12/16/44");
            check = dao.saveOne(check);
            Assert.assertTrue(check.getId()>0);


        } catch (Exception ex)
        {
            Assert.assertTrue(false);
        }

    }



    @Test
    public void t03_testDaoSelectOne()
    {
        try
        {

            CheckDao dao = new CheckDao();
            int id = dao.selectMaxPk();
            Check filter = new Check(id, "Payless", 1.23, "12345", 1234,"12/16/44");
            Check check = (Check)dao.selectOne(filter);
            Assert.assertEquals(check.getId(), id);

        } catch (Exception ex)
        {
            Assert.assertTrue(false);
        }

    }

    @Test
    public void t04_testDaoDeleteOne()
    {
        try
        {
            CheckDao dao = new CheckDao();
            int id = dao.selectMaxPk();
            Check filter = new Check(id, "Payless", 1.23, "12345", 1234,"12/16/44");
            dao.deleteOne(filter);

            Check check = (Check)dao.selectOne(filter);

            Assert.assertNull(check);

        } catch (Exception ex)
        {
            Assert.assertTrue(false);
        }

    }


    @Test
    public void t05_testDaoSelectMany()
    {
        try
        {
            CheckDao dao = new CheckDao();

            Check filter = new Check(-1, "%", 1.23, "12345", 1234,"12/16/44");


            List<Object> results = dao.selectMany(filter);

            Assert.assertTrue(results.size() > 0);

        } catch (Exception ex)
        {
            Assert.assertTrue(false);
        }

    }

}
