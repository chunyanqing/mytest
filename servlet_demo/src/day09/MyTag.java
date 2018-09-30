package day09;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * JSTL自定义标签
 * 
 * 写一个类继承SimpleTagSupport,重写doTag
 */
public class MyTag extends SimpleTagSupport
{
	// 信息(内容)
	private String info;
	
	// 数量
	private int num;

	/**
	 * 写一个类继承SimpleTagSupport,重写doTag
	 */
	@Override
	public void doTag() {
		/*
		 * 在JSP中使用pageContext可以获取到其他的内置对象
		 * 
		 * 通过pageContext获取输出流对象JspWriter(JSP内置对象out)
		 */
		// JspContext jspContext = getJspContext();
		// 将JspContext强转成PageContext
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		for (int i = 0; i < num; i++) {
			try {
				out.print(info + "<br/>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
