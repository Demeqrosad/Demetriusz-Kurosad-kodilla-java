package com.kodilla.patterns.singleton;

public final class Logger
{
    private String lastLog = "";
    private static Logger instanceOfLogger = null;

    private Logger()
    {

    }

    public static Logger getInstance()
    {
        if(instanceOfLogger == null)
        {
            synchronized (Logger.class)
            {
                if(instanceOfLogger == null)
                {
                    instanceOfLogger = new Logger();
                }
            }
        }
        return instanceOfLogger;
    }

    public void log(String log)
    {
        this.lastLog = log;
        System.out.println("Log: [" + this.lastLog + "]");
    }

    public String getLastLog()
    {
        return this.lastLog;
    }

    public static Logger getInstanceOfLogger()
    {
        return instanceOfLogger;
    }
}