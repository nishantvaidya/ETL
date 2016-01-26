package com.etl.beans;

import com.etl.constants.MessageEnum;

/**
 * @author NISHANT VAIDYA
 *
 */
public class MessageType {
	private MessageEnum type;
	
	
	public MessageEnum getType() {
		return type;
	}
	public void setType(MessageEnum type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String message;
	private String code;

}
