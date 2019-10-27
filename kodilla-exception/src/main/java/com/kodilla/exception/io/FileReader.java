package com.kodilla.exception.io;

import java.lang.ClassLoader;
import java.net.URL;

public class FileReader
{
    public void readFile() throws SecurityException
    {
        try
        {
            ClassLoader classLoader = FileReader.class.getClassLoader();
            URL resource = classLoader.getResource("file/names.txt");
            System.out.println(resource);
            //File file = new File(classLoader.getResource("file/names.txt").getFile());
            //System.out.println(file.getPath());
        }
        catch (SecurityException e)
        {
            System.out.println("Exception");
        }
    }
}
