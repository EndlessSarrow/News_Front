package cn.et.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;


/**
 * 将新闻详情页响应给浏览器
 * @author Administrator
 *
 */
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowDetails() {}
    
    /**
     * 要完成的任务：
     * 	接收请求，响应页面
     */
    
    public static final String HTML_PATH = "E:/Learning/temp/171027/";
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String htmlName = request.getParameter("htmlName");
		byte [] bs = FileUtils.readFileToByteArray(new File(HTML_PATH + htmlName));
		response.getOutputStream().write(bs);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
