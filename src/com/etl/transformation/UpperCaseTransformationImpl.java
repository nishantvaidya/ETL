package com.etl.transformation;

import java.util.ArrayList;

import com.etl.beans.FileDataBean;

/**
 * @author NISHANT VAIDYA
 *
 */
public class UpperCaseTransformationImpl implements TransformationInterface {

	@Override
	public void transform(FileDataBean data) {
		if (data != null && data.getData() != null && !data.getData().isEmpty()) {
			transformToUpperCase(data);
		}
	}

	private void transformToUpperCase(FileDataBean data) {
		ArrayList<String> uppercaseData = null;
		uppercaseData = new ArrayList<String>();
		for (String st : data.getData()) {
			uppercaseData.add(st.toUpperCase());
		}

		data.setData(uppercaseData);
	}

}
