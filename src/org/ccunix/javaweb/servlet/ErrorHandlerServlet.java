package org.ccunix.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandlerServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//停了   不让调用doPost和doGet了
		//request.getRequestDispatcher("errorPage.html").forward(request, response);
		//处理
		
		Throwable throwable = (Throwable)
		        request.getAttribute("javax.servlet.error.exception");
		        Integer statusCode = (Integer)
		        request.getAttribute("javax.servlet.error.status_code");
		        String servletName = (String)
		        request.getAttribute("javax.servlet.error.servlet_name");
		        if (servletName == null){
		            servletName = "Unknown";
		        }
		        String requestUri = (String)
		        request.getAttribute("javax.servlet.error.request_uri");
		        if (requestUri == null){
		            requestUri = "Unknown";
		        }
		        // 设置响应内容类型
		        response.setContentType("text/html;charset=UTF-8");
		    
		        PrintWriter out = response.getWriter();
		        String title = "菜鸟教程 Error/Exception 信息";
		       
		        String docType = "<!DOCTYPE html>\n";
		        out.println(docType +
		            "<html>\n" +
		             "<head><title>" + title + "</title></head>\n" +
		             "<body bgcolor=\"#f0f0f0\">\n");
		           out.println("<h1>菜鸟教程异常信息实例演示</h1>");
		           if (throwable == null && statusCode == null){
		              out.println("<h2>错误信息丢失</h2>");
		              out.println("请返回 <a href=\"" + 
		            response.encodeURL("http://localhost:8080/") + 
		                "\">主页</a>。");
		           }else if (statusCode != null) {
		              out.println("错误代码 : " + statusCode);
		        }else{
		              out.println("<h2>错误信息</h2>");
		              out.println("Servlet Name : " + servletName + 
		                              "</br></br>");
		              out.println("异常类型 : " + 
		                              throwable.getClass( ).getName( ) + 
		                              "</br></br>");
		              out.println("请求 URI: " + requestUri + 
		                              "<br><br>");
		              out.println("异常信息: " + 
		                                  throwable.getMessage( ));
		           }
		           out.println("</body>");
		           out.println("</html>");
	}
}
