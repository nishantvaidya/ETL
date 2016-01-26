package com.etl.extraction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.etl.beans.FileDataBean;
import com.etl.beans.MessageType;
import com.etl.constants.Constant;
import com.etl.constants.MessageEnum;

/**
 * @author NISHANT VAIDYA
 *
 */
public class FileSystemExtractionImpl implements ExtractionInterface {

	private String filePath;

	public FileSystemExtractionImpl(String filePath) {
		this.filePath = filePath;

	}

	@Override
	public FileDataBean loadFile() {
		String fileName = this.filePath;
		// This will reference one line at a time
		String line = null;
		FileDataBean fileDataBean = new FileDataBean();
		MessageType type = new MessageType();
		fileDataBean.setMessage(type);
		int i = 0;
		ArrayList<String> fileData = new ArrayList<String>();
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				i++;
				fileData.add(line);
			}
			 fileDataBean.setData(fileData);
			type.setType(MessageEnum.SUCCESS);
			
			
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			type.setCode(Constant.MESSAGE_CODE_FNF);
			type.setMessage(Constant.MESSAGE_DSC_FNF);
			type.setType(MessageEnum.ERROR);
			 
		} catch (IOException ex) {
			type.setCode(Constant.MESSAGE_CODE_TEX);
			type.setMessage(Constant.MESSAGE_DSC_TEX);
			type.setType(MessageEnum.ERROR);
		}
			
		return fileDataBean;

	}
}
