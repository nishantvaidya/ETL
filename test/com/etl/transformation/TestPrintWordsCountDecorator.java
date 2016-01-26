package com.etl.transformation;

import java.util.ArrayList;

import com.etl.beans.FileDataBean;

import junit.framework.TestCase;

/**
 * @author NISHANT VAIDYA
 *
 */
public class TestPrintWordsCountDecorator extends TestCase {
	private PrintWordsCountDecorator printDecorator;
	
	public void test_printWordCounts(){
		FileDataBean fileDataBean = new FileDataBean();
		ArrayList<String> data = new ArrayList<String>();
		data.add("Hi this Is Test Programme.");
		data.add("Hi this Is hello Programme.");
		fileDataBean.setData(data);
		printDecorator = new PrintWordsCountDecorator(new UpperCaseTransformationImpl());
		printDecorator.transform(fileDataBean);
		assertEquals(fileDataBean.getWords().get("hi").intValue(),2 );
		assertEquals(fileDataBean.getWords().get("this").intValue(),2 );
		assertEquals(fileDataBean.getWords().get("is").intValue(),2 );
		assertEquals(fileDataBean.getWords().get("programme").intValue(),2 );
		assertEquals(fileDataBean.getWords().get("test").intValue(),1 );
		assertEquals(fileDataBean.getWords().get("hello").intValue(),1 );
		
		
	}
	@Override
	protected void tearDown()  {
		printDecorator = null;
	}

}
