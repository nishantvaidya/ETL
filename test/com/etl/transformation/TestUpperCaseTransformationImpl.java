package com.etl.transformation;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.etl.beans.FileDataBean;

/**
 * @author NISHANT VAIDYA
 *
 */
public class TestUpperCaseTransformationImpl extends TestCase {
	private TransformationInterface transformation;
	
	public void test_transform(){
		FileDataBean fileDataBean = new FileDataBean();
		ArrayList<String> data = new ArrayList<String>();
		data.add("Hi this Is Test Programme.");
		data.add("Hi this Is hello Programme.");
		fileDataBean.setData(data);
		transformation = new UpperCaseTransformationImpl();
		 transformation.transform(fileDataBean);
		assertEquals(fileDataBean.getData().get(0), "HI THIS IS TEST PROGRAMME.");
		assertEquals(fileDataBean.getData().get(1), "HI THIS IS HELLO PROGRAMME.");
		
	}
	
	@Override
	protected void tearDown()  {
		transformation = null;
	}
	
	
}
