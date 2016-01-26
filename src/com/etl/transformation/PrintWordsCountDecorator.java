package com.etl.transformation;

import java.util.HashMap;
import java.util.Map;

import com.etl.beans.FileDataBean;

/**
 * @author NISHANT VAIDYA
 *
 */
public class PrintWordsCountDecorator extends UpperCaseTransformationImpl {

	protected TransformationInterface transformInterface;

	public PrintWordsCountDecorator(TransformationInterface transformInterface) {
		this.transformInterface = transformInterface;

	}

	@Override
	public void transform(FileDataBean data) {
		printWordCounts(data);
		// TODO Auto-generated method stub
		transformInterface.transform(data);
	}

	protected void printWordCounts(FileDataBean data) {
		Map<String, Integer> wordsMap = null;
		if (data != null && data.getData() != null && !data.getData().isEmpty()) {
			wordsMap = new HashMap<String, Integer>();
			String[] words = null;
			for (String line : data.getData()) {
				 words = line.split("[ \n\t\r.,;:!?(){}]");
				for (int counter = 0; counter < words.length; counter++) {
					String key = words[counter].toLowerCase(); 
					if (key.length() > 0) {
						if (wordsMap.get(key) == null) {
							wordsMap.put(key, 1);
						} else {
							int value = wordsMap.get(key).intValue();
							value++;
							wordsMap.put(key, value);
						}
					}
				}
			}
			if(wordsMap != null){
				data.setWords(wordsMap);
			}

		}

	}

}
