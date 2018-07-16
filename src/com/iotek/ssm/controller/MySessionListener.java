package com.iotek.ssm.controller;

import java.util.HashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.servlet4preview.ServletContext;

import com.iotek.ssm.entity.MySessionInfo;

/**
 * 一个传统的监听器
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
	private HashMap<String, MySessionInfo> sessionMap = new HashMap<String, MySessionInfo>();

	public MySessionListener() {
	}

	public void sessionCreated(HttpSessionEvent event) {
		MySessionContext.AddSession(event.getSession());
		HttpSession httpSession = event.getSession();
		ServletContext application = (ServletContext) httpSession.getServletContext();
		MySessionInfo mySession = new MySessionInfo(httpSession);
		mySession.setStatus("有效");
		sessionMap.put(mySession.getSessionID(), mySession);
		application.setAttribute("sessionMap", sessionMap);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession httpSession = event.getSession();
		ServletContext application = (ServletContext) httpSession.getServletContext();
		MySessionInfo mySession = new MySessionInfo(httpSession);
		sessionMap.remove(mySession.getSessionID(), mySession);
		application.setAttribute("sessionMap", sessionMap);
	}

}
