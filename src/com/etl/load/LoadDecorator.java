package com.etl.load;

import com.etl.beans.FileDataBean;

/**
 * @author NISHANT VAIDYA
 *
 */
public class LoadDecorator implements LoadInterface{
	
	private LoadInterface loadInterface;
	
	public LoadDecorator(LoadInterface loadInterface){
		this.loadInterface = loadInterface;
	}

	@Override
	public boolean load(FileDataBean fileData) {
		
		return loadInterface.load( fileData);
	}

}
