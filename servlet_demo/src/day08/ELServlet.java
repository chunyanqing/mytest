package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * EL用于获取作用域对象中的值演示
 * EL操作对象的方式演示
 *
 */
public class ELServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException 
	{
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();

		request.setAttribute("req", "requestValue");
		session.setAttribute("sess", "sessionValue");
		application.setAttribute("app", "applicationValue");

		// 当request和session中用同一个key时
		// 在jsp页面中用EL表达式根据此key取值时
		// 如果用${req }取到的是request中的值
		// 用${sessionScope.req}取到的是session的值
		session.setAttribute("req", "sessionReqValue");

	    // User(Integer id, String name, String pwd, 
				// Integer age, String hobby, String info, String sex) 
		User u = new User(11, "张三", "123", 66, null, "", null);

		request.setAttribute("user", u);

		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < 5; i++) {
			User us = new User();
			us.setAge(30 + i);
			userList.add(us);
		}
		request.setAttribute("userList", userList);

		// 注意这里如果是重定向的话	
		// request.setAttribute("req", "requestValue");
		// request的值就白放了
		request.getRequestDispatcher("/day08/el.jsp")
				.forward(request, response);

	}

}
