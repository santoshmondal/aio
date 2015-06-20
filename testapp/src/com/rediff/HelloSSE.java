package com.rediff;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloSSE")
public class HelloSSE extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/event-stream");
	     response.setCharacterEncoding("UTF-8");
	 
	        PrintWriter writer = response.getWriter();
	        int upVote = 0;
	        int downVote = 0;
	        /*for (int i = 0; i < 5; i++) {
	 
	            upVote = upVote + (int) (Math.random() * 10);
	            downVote = downVote + (int) (Math.random() * 10);
	 
	            writer.write("event:up_vote\n");
	            writer.write("data: " + upVote + "\n\n");
	 
	            writer.write("event:down_vote\n");
	            writer.write("data: " + downVote + "\n\n");
	 
	            writer.flush();
	             
	            try {
	                Thread.sleep(10000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println("EVERY 10 SECONDS!!");
	        }*/
	        
	        
	        upVote = upVote + (int) (Math.random() * 10);
            downVote = downVote + (int) (Math.random() * 10);
 
            writer.write("event:up_vote\n");
            writer.write("data: " + upVote + "\n\n");
 
            writer.write("event:down_vote\n");
            writer.write("data: " + downVote + "\n\n");
 
            writer.flush();
             
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("EVERY 10 SECONDS!!");
	        writer.close();
	}

}
