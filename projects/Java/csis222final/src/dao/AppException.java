package edu.mcckc.dao;

public class AppException extends Exception
{
    public AppException()
    {
        super("Something bad happened in the Application");
    }

    public AppException(String message)
    {
        super(message);
    }
}
