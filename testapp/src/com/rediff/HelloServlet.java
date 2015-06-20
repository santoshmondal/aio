package com.rediff;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns={"/HelloServlet"}, asyncSupported=true)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext asyncContext = request.startAsync();
		System.out.println("MAIN_THREAD_START :: " + Thread.currentThread().getName());
		
		asyncContext.addListener(new AsyncListener() {
			
			@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
				System.out.println("ON TIMEOUT :: ");
				
			}
			
			@Override
			public void onStartAsync(AsyncEvent arg0) throws IOException {
				System.out.println("ON START :: ");				
			}
			
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				System.out.println("ON ERROR :: ");				
			}
			
			@Override
			public void onComplete(AsyncEvent arg0) throws IOException {
				System.out.println("ON COMPLETE :: ");
				
			}
		});
		
		asyncContext.start(new Runnable() {
			@Override
			public void run() {
				ServletRequest request2 = asyncContext.getRequest();
				ServletResponse response2 = asyncContext.getResponse();
				
				try {
					Thread.sleep(10000);
					
					response2.getWriter().println("Hello Servlet!!" + request2.getParameter("param"));
					asyncContext.complete();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		System.out.println("MAIN_THREAD_END :: " + Thread.currentThread().getName());
	}

}
