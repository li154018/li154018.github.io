package com.entity;

public class Message {
    private String title;
    private String detail;
    private String send_time;
    private String sender;
    private String recipient;
    private String shenfen;
    
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getdetail() {
		return detail;
	}
	public void setdetail(String detail) {
		this.detail = detail;
	}
	public String getsend_time() {
		return send_time;
	}
	public void setsend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getsender() {
		return sender;
	}
	public void setsender(String sender) {
		this.sender = sender;
	}
	public String getrecipient() {
		return recipient;
	}
	public void setrecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getshenfen() {
		return shenfen;
	}
	public void setshenfen(String shenfen) {
		this.shenfen = shenfen;
	}
}
