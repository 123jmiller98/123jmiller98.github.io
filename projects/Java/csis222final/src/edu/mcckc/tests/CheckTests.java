package edu.mcckc.tests;
import edu.mcckc.dao.*;
import org.junit.*;

public class CheckTests
{

   @Test
    public void testProductConstructor()
    {
        try
        {
            Check check = new Check(-1, "Payless", 1.23, "345", 1234,"12/16/44");
            Assert.assertNotNull(check);

        } catch(Exception ex)
        {
            Assert.assertTrue(false);

        }

    }



    @Test
    public void testProductValues()
    {
        try
        {
            Check check = new Check(-1, "Payless", 1.23, "345", 1234,"12/16/44");
            Assert.assertNotNull(check);
            Assert.assertEquals(-1, check.getId());
            Assert.assertEquals("Payless", check.getPaidTo());
            Assert.assertEquals(1.23, check.getCheckAmount(), 0.001);
            Assert.assertEquals("345", check.getAccountNumber());
            Assert.assertEquals(1234, check.getSequenceNumber());
            Assert.assertEquals("12/16/44", check.getCheckDate());


        } catch(Exception ex)
        {
            Assert.assertTrue(false);

        }

    }


    @Test
    public void testProductBadName()
    {
        try
        {
            Check check = new Check(-1, "", 1.23, "345", 1234,"12/16/44");
            Assert.assertTrue(false);

        } catch(Exception ex)
        {
            Assert.assertTrue(true);

        }

    }


    @Test
    public void testProductBadCheckAmount()
    {
        try
        {
            Check check = new Check(-1, "Payless", -1.23, "345", 1234,"12/16/44");
            Assert.assertTrue(false);

        } catch(Exception ex)
        {
            Assert.assertTrue(true);

        }
    }


    @Test
    public void testProductBadAccountNumber()
    {
        try
        {
            Check check = new Check(-1, "Payless", 1.23, "", 1234,"12/16/44");
            Assert.assertTrue(false);

        } catch(Exception ex)
        {
            Assert.assertTrue(true);

        }

    }

    @Test
    public void testProductBadSequenceNumber()
    {
        try
        {
            Check check = new Check(-1, "Payless", 1.23, "", -1234,"12/16/44");
            Assert.assertTrue(false);

        } catch(Exception ex)
        {
            Assert.assertTrue(true);

        }

    }

    @Test
    public void testProductBadCheckDate()
    {
        try
        {
            Check check = new Check(-1, "Payless", 1.23, "1234", -1234,"");
            Assert.assertTrue(false);

        } catch(Exception ex)
        {
            Assert.assertTrue(true);

        }

    }









}
