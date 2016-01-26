package com.etl.extraction;

import com.etl.beans.FileDataBean;

/**
 * @author NISHANT VAIDYA
 *
 */
public class ExtractionDecorator implements ExtractionInterface {
	
	protected ExtractionInterface extractionInterface;
	
	public ExtractionDecorator(ExtractionInterface extractionInterface){
		this.extractionInterface = extractionInterface;
	}

	@Override
	public FileDataBean loadFile() {
		// TODO Auto-generated method stub
		 return extractionInterface.loadFile();
	}

}
