package com.iotek.ssm.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Timer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.ssm.entity.MySessionInfo;

@Controller
@RequestMapping("/messenger")
public class MessengerController {
	private static final int HashMap = 0;

	@RequestMapping(value = "/sendMessage/{sessionID}", method = RequestMethod.GET)
	public String sendMessage(HttpSession session,@PathVariable("sessionID") String sessionID) {
		System.out.println("sending message");
		
		
		//向别的session发送message
		HttpSession session1 = MySessionContext.getSession(sessionID);
		List<String> messages = (List<String>) session1.getAttribute("messages");
		if (messages==null) {
			messages=new ArrayList<String>();
		}
		messages.add("hello bitch");
		session1.setAttribute("messages", messages);
		System.out.println("messages got:"+session1.getAttribute("messages"));
		sessionList(session);
		return "sessionList";
	}
	
	@RequestMapping("/getMessage")
	@ResponseBody
	public String getMessage(HttpSession session) {
		System.out.println("getting message");
		String messages = ((List<String>)session.getAttribute("messages")).toString();
		System.out.println(messages);
		return messages;
	}
	
	@RequestMapping("/sessionList")
	public String sessionList(HttpSession session) {
		ServletContext application = session.getServletContext();
		HashMap<String, MySessionInfo> sessionMap = (java.util.HashMap<String, MySessionInfo>) application.getAttribute("sessionMap");
		System.out.println(sessionMap);
		Collection<MySessionInfo> sessionSet = sessionMap.values();
		session.setAttribute("sessionSet", sessionSet);
		return "sessionList";
	}
	
}
