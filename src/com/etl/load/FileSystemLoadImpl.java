package com.etl.load;

import java.io.File;
import java.io.FileWriter;

import com.etl.beans.FileDataBean;

/**
 * @author NISHANT VAIDYA
 * 
 */
public class FileSystemLoadImpl implements LoadInterface {

	private String filePath;
	private String fileName;

	public FileSystemLoadImpl(String filePath, String fileName) {
		this.filePath = filePath;
		this.fileName = fileName;

	}

	@Override
	public boolean load(FileDataBean fileData) {
		boolean success = false;
		String lineSeparator = System.getProperty("line.separator");
		String fileSeparator = System.getProperty("file.separator");
		File files = new File(filePath);
		if (!files.exists()) {
			files.mkdir();
		}
		try {
			FileWriter fw = new FileWriter(files.getPath() + fileSeparator
					+ fileName);
			for (String data : fileData.getData()) {
				fw.write(data);
				fw.write(lineSeparator);
			}
			fw.close();
		} catch (Exception e) {
			success = false;
		}
		success = true;

		return success;
	}
}
