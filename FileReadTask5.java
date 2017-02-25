package com.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileReadTask5 {

    public static void main(String[] args) {
        
        
        Path path=null;
        if(args.length!=1)
        {
            System.out.println("please enter the atleast one parameter as fully qualified path for file");
        
        System.exit(0);
        }

        path=new Path(args[0]);
        FSDataInputStream in=null;
        
        try
        {
            Configuration conf=new Configuration();
            FileSystem fs=FileSystem.get(path.toUri(),conf);
            if(fs.exists(path))
            {
            if(fs.isFile(path))
            {
            in=fs.open(path);
            IOUtils.copyBytes(in, System.out, 4096);
            
            System.out.println("End of file reached here");
            }
            else
            {
                System.out.println("please enter the file not directory");
            }
            }
            else
            {
                System.out.println("File Doesnot exists");
            }
            
        }
        catch(Exception e)
        {
            
        }
        
    }

}
