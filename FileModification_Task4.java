package com.demo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.text.DateFormatter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

public class FileModification_Task4{

	
	
	public static void main(String args[]) throws Exception
	{
		Path path=null;
		
		long start_tm=0;//by default start time will be 0
		long end_tm=Long.MAX_VALUE;//default end time
		if(args.length==0)
		{
			System.out.println("provide atleast file directory ");
		System.exit(0);
		}
		if(args.length==1)
		{
			path=new Path(args[0]);
		}
		else if(args.length==2)
		{path=new Path(args[0]);
			start_tm=Long.parseLong(args[1]);
		}
		if(args.length==3)
		{path=new Path(args[0]);
		start_tm=Long.parseLong(args[1]);
		end_tm=Long.parseLong(args[2]);
	}
		
			
		try
		{
			Configuration conf=new Configuration();
			FileSystem fs=FileSystem.get(path.toUri(),conf);
			RemoteIterator<LocatedFileStatus> fs1=fs.listFiles(path, true);
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
			String time="";
			while(fs1.hasNext())
			{
				LocatedFileStatus fs2=fs1.next();
				
			//checks the condition for modification time
			if(fs2.getModificationTime()>start_tm && fs2.getModificationTime()<end_tm)
			{//prints the file whose modification time between start and end times
				System.out.println(fs2.getPath());
			}
				
				
				
			}
			
		}
		catch(Exception e)
		{
			
		}
	}
	

}
