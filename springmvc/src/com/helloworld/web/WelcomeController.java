package com.helloworld.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	
	@RequestMapping(value = "/1")
	public String index1(Model model) {

		model.addAttribute("title", "TITLE1");
 
		return "index";
	}
	
	
	@RequestMapping(value = "/2")
	public ModelAndView index2() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("title", "titl2");
 
		return model;
	}
	
	
	
	@RequestMapping(value = "/3")
	public String index3(Map<String, Object> model, @RequestParam("id")String id) {
		model.put("title", "TITLE 3" +id);
		
		return "index";
	}
	
	
	@RequestMapping(value = "/4")
	public String index4(Map<String, Object> model, HttpServletRequest request) {
		String id = request.getParameter("id");
		model.put("title", "TITLE 4" + id);
		
		return "index";
	}
	
	
	@RequestMapping(value = "/5")
	public String index5(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("title", "TITLE 5");
		
		return "index";
	}
	
	
	@RequestMapping(value = "/6")
	public String index5(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		model.put("title", "TITLE 6");
		
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		model.put("title", "TITLE!!");
		model.put("msg", "MESSAGE!!");
 
		return "index";
	}
	
	
	
}
