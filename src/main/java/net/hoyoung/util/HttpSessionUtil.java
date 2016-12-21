package net.hoyoung.util;

import javax.servlet.http.HttpSession;

import net.hoyoung.domain.User;

public class HttpSessionUtil {

	public static final String USER_SESSION_KEY = "sessionUser";
	
	public static boolean isLogin(HttpSession session){
		Object sessionUser = session.getAttribute(USER_SESSION_KEY);
		if(sessionUser == null){
			return false;
		}
		return true;
	}
	
	public static User getUserFromSessionUser(HttpSession session){
		if(!isLogin(session)){
			return null;
		}
		
		return (User)session.getAttribute(USER_SESSION_KEY);
	}
}
