package com.etl.tool;

import java.util.Map.Entry;

import com.etl.beans.FileDataBean;
import com.etl.extraction.ExtractionDecorator;
import com.etl.extraction.FileSystemExtractionImpl;
import com.etl.load.FileSystemLoadImpl;
import com.etl.transformation.PrintWordsCountDecorator;
import com.etl.transformation.UpperCaseTransformationImpl;
/**
 * 
 * 
 * @author NISHANT
 * Thread class implement runnable interface .
 * 
 * This programme perform etl for files in different thread.
 * Date 26/Jan/2016
 *
 */

public class ETLThread implements Runnable {
	private final String path;
	private final String fileName;
	private final String uploadPath;

	ETLThread(String path, String fileName, String uploadPath) {
		this.path = path;
		this.fileName = fileName;
		this.uploadPath = uploadPath;
	}

	@Override
	public void run() {
		execute(path, fileName, uploadPath);

	}

	public void execute(String path, String fileName, String uploadPath) {

		// Declaring file data bean variable.This hold raw data and transform
		// data
		FileDataBean fileData = null;
		// Loading data in file data bean from the give directory file

		fileData = new ExtractionDecorator(new FileSystemExtractionImpl(path
				+ fileName)).loadFile();
		switch (fileData.getMessage().getType()) {
		case ERROR:
			System.out.println("There is issue in retrieving the file ");
			System.out.println("Root Cause is ' "
					+ fileData.getMessage().getMessage() + "'");
			break;
		case WARNING:
			System.out.println("file is empty");
			break;
		default:
			new PrintWordsCountDecorator(new UpperCaseTransformationImpl())
					.transform(fileData);
			boolean success = new FileSystemLoadImpl(uploadPath, fileName)
					.load(fileData);
			if (!fileData.getWords().isEmpty()) {
				for (Entry<String, Integer> entry : fileData.getWords()
						.entrySet()) {
					System.out.println("Number of occurrence for the Word '"
							+ entry.getKey() + "' is " + entry.getValue());
				}

			}
			if (success) {
				System.out.println("File '" + uploadPath + fileName
						+ "' has uploaded successfully");
			}

		}

	}

}
