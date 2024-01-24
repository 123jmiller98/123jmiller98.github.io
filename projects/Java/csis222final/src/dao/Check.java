package edu.mcckc.dao;

import java.util.Date;

public class Check
{

    private int id;
    private String paidTo;
    private double checkAmount;
    private String accountNumber;
    private int sequenceNumber;
    private String checkDate;


    public Check(int id, String paidTo, double checkAmount, String accountNumber, int sequenceNumber, String checkDate) throws Exception
    {

        setId(id);
        setPaidTo(paidTo);
        setCheckAmount(checkAmount);
        setAccountNumber(accountNumber);
        setSequenceNumber(sequenceNumber);
        setCheckDate(checkDate);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPaidTo()
    {
        return paidTo;
    }

    public void setPaidTo(String paidTo) throws AppException
    {
        if (paidTo.trim().length() == 0)
        {
            throw new AppException("Paid To cannot be blank");
        }
        this.paidTo = paidTo;
    }

    public double getCheckAmount()
    {
        return checkAmount;
    }

    public void setCheckAmount(double checkAmount) throws AppException
    {
        if(checkAmount < 0)
        {
            throw new AppException("Check amount must be positive");
        }
        this.checkAmount = checkAmount;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) throws AppException
    {
        if(accountNumber.isBlank())
        {
            throw new AppException("Account number cannot be blank");
        }
        this.accountNumber = accountNumber;
    }

    public int getSequenceNumber()
    {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) throws AppException
    {
        if(sequenceNumber < 0)
        {
            throw new AppException("Sequence number must be positive");
        }
        this.sequenceNumber = sequenceNumber;
    }

    public String getCheckDate()
    {
        return checkDate;
    }

    public void setCheckDate(String checkDate) throws AppException
    {
        if(checkDate.isBlank())
        {
            throw new AppException("Date cannot be blank");
        }
        this.checkDate = checkDate;
    }

    @Override
    public String toString()
    {
        return "Check{" +
                "id=" + id +
                ", paidTo='" + paidTo + '\'' +
                ", amount=" + checkAmount +
                ", accountNumber='" + accountNumber + '\'' +
                ", sequenceNumber=" + sequenceNumber +
                ", date=" + checkDate +
                '}';
    }
}
