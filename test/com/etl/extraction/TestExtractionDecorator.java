package com.etl.extraction;

import junit.framework.TestCase;

import com.etl.beans.FileDataBean;
import com.etl.constants.Constant;
import com.etl.constants.MessageEnum;

/**
 * @author NISHANT VAIDYA
 *
 */
public class TestExtractionDecorator extends TestCase {
	private ExtractionDecorator extraction;
	
	
	
	public void test_loadFile_notExist(){
		String path = "C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\file_not_exist.txt";//getPath("empty.txt");
				FileDataBean fileDataBean = null;
		extraction = new ExtractionDecorator(new FileSystemExtractionImpl(path));
		fileDataBean = extraction.loadFile();
		assertEquals(fileDataBean.getMessage().getType(), MessageEnum.ERROR);
		assertEquals(fileDataBean.getMessage().getCode(), Constant.MESSAGE_CODE_FNF);
		assertEquals(fileDataBean.getMessage().getMessage(), Constant.MESSAGE_DSC_FNF);
		
	}
	
	public void test_loadFile_Empty(){
		String path = "C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\empty.txt";//getPath("empty.txt");
		FileDataBean fileDataBean = null;
		extraction = new ExtractionDecorator(new FileSystemExtractionImpl(path));
		fileDataBean = extraction.loadFile();
		assertEquals(fileDataBean.getMessage().getType(), MessageEnum.WARNING);
		assertEquals(fileDataBean.getMessage().getCode(), Constant.MESSAGE_CODE_EMP);
		assertEquals(fileDataBean.getMessage().getMessage(), Constant.MESSAGE_DSC_EMP);
		
	}
	
	public void test_loadFile(){
		String path = "C:\\Users\\NISHANT\\workspace\\ETL\\test\\com\\etl\\resources\\data.txt";// getPath("data.txt");
		FileDataBean fileDataBean = null;
		extraction = new ExtractionDecorator(new FileSystemExtractionImpl(path));
		fileDataBean = extraction.loadFile();
		assertFalse(fileDataBean.getData().isEmpty());
		
	}
	
	private String getPath(String fileName){
		return TestExtractionDecorator.class.getClassLoader().getResource(fileName).getPath();
		
	}

}
