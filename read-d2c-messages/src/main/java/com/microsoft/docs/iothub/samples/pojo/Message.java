package com.microsoft.docs.iothub.samples.pojo;
import java.sql.Date;


public class Message {

	private String messageId;
	private String telemetricData;
	private Date date;
	private String source;
	private String isValid;
	private String deviceId;
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getTelemetricData() {
		return telemetricData;
	}
	public void setTelemetricData(String telemetricData) {
		this.telemetricData = telemetricData;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	
	
	
	
}
