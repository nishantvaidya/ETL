package com.etl.load;

import com.etl.beans.FileDataBean;

/**
 * @author NISHANT VAIDYA
 *
 */
public interface LoadInterface {
	
	public boolean load(FileDataBean fileData);

}
