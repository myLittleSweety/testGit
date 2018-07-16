package com.iotek.ssm.entity;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.ha.session.SessionMessage;

public class MySessionInfo {
	private String sessionID;
	private long creationTime;
	private long lastAccessedTime;
	private String status;

	public MySessionInfo() {
		super();
	}

	public MySessionInfo(HttpSession session) {
		sessionID = session.getId();
		creationTime = session.getCreationTime();
		lastAccessedTime = session.getLastAccessedTime();
		status = (String) session.getValue("status");
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public void setAccount(String account) {
		account = account;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	public long getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MySessionInfo [sessionID=" + sessionID + ", creationTime=" + creationTime + ", lastAccessedTime="
				+ lastAccessedTime + ", status=" + status + "]";
	}

}
