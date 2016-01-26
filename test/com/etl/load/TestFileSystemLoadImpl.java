package com.etl.load;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.etl.beans.FileDataBean;

/**
 * @author NISHANT VAIDYA
 *
 */
public class TestFileSystemLoadImpl extends TestCase {
	private LoadInterface loadInterface;
	private String filePath= "C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\upload";
	private String fileName= "data_UpperCase.txt";
	
	
	@Override
	protected void setUp() throws Exception {
		loadInterface = new FileSystemLoadImpl(filePath,fileName);
	}
	
	public void test_load(){
		boolean load ;
		FileDataBean fileDataBean = new FileDataBean();
		ArrayList<String> data = new ArrayList<String>();
		data.add("Hi this Is Test Programme.");
		data.add("Hi this Is hello Programme.");
		fileDataBean.setData(data);
		load =loadInterface.load(fileDataBean);
		assertTrue(load);
		
		
		
		
	}

}
