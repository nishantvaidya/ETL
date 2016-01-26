package com.etl.constants;

public enum MessageEnum {

	ERROR(1), WARNING(2),SUCCESS(3);

	private int value;

	private MessageEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	

}
