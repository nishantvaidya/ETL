package com.etl.tool;

import junit.framework.TestCase;

/**
 * @author NISHANT
 * Test class to test Etl tool
 *
 */
public class TestJob extends TestCase {
	private Job job;
	
	@Override
	protected void setUp() throws Exception {
		job = new Job();
	}
	
	public void test_execute(){
		
		String path = "C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\download\\";
		String uploadPath = "C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\upload\\";
		
		job.runJob(path, uploadPath);
	}

}
