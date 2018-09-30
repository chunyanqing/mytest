package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils 
{
	public static void addCookie(String key,String value,HttpServletResponse response){
		try
		{
			Cookie cookie = new Cookie(key, URLEncoder.encode(value, "utf-8"));
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void addCookie(String key,String value,int maxAge,HttpServletResponse response){
		try
		{
			Cookie cookie = new Cookie(key, URLEncoder.encode(value, "utf-8"));
			cookie.setMaxAge(maxAge);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void removeCookie(String key,HttpServletResponse response){
		addCookie(key, "", 0, response);
	}
	
	public static void modifyCookie(String key,String value,HttpServletResponse response){
		addCookie(key, value, response);
	}
	
	public static String findCookie(String key,HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals(key))
				{
					try 
					{
						return URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}
}
