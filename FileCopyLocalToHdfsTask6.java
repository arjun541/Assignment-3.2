package com.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileCopyLocalToHdfsTask6  {
    
    
    public static void main(String args[])
    {
        if(args.length!=2)
        {
            System.out.println("enter the source and destination files");
            System.exit(0);
        }
          
        
           try
           {
               Path src=new Path(args[0]);
               Path dst=new Path(args[1]);
            Configuration conf=new Configuration();
               FileSystem fs=FileSystem.get(conf);
             
              
 fs.copyFromLocalFile(src, dst);
           }
           catch(Exception e)
           {
               
           }
    }

}
