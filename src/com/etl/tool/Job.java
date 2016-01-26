package com.etl.tool;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author NISHANT 
 * Main programme to run etl tool
 * This programme load txt file from directory , transform the
 *         data to upper case and then write to upper case data in a file to
 *         same directory
 * 
 */
public class Job {

	public void runJob(String dirPath, String uploadPath) {
		File dir = new File(dirPath);
		String[] files = dir.list();
		if (files.length == 0) {
			System.out.println("The directory is empty");
		} else {
			int numberOfThreads = 3;
			ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
			for (String fileName : files) {
				Runnable worker = new ETLThread(dirPath, fileName,uploadPath);
				executor.execute(worker);			
				}
			executor.shutdown();
			// Wait until all threads are finish
			while (!executor.isTerminated()) {
	 
			}
			System.out.println("\nFinished all threads");
		}

	}

	

	public static void main(String[] args) {
		Job job = new Job();
		String path = (args.length != 0 && args[0] != "") ? args[0] : "";
		String uploadPath = (args.length != 0 && args[1] != "") ? args[1] : "";
		if (path == "") {
			System.out
					.println("File Path did not supply is first argument throguh command line.");
			System.out
					.println("Looking file in default location C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\download\\");
			path = "C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\download\\";
		}
		if (uploadPath == "") {
			System.out
					.println("Upload path did not supply in second argument through command line");
			System.out
					.println("Writing files in default location C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\upload\\");
			uploadPath = "C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\upload\\";
		}
		
		job.runJob(path, uploadPath);
	}

}
