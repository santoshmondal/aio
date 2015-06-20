package com.helloworld.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helloworld.pojos.Person;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		Person userForm = new Person();
		model.put("userForm", userForm);

		List<String> professionList = new ArrayList<>();
		professionList.add("Developer");
		professionList.add("Designer");
		professionList.add("IT Manager");
		model.put("professionList", professionList);

		return "registration";
	}

	@RequestMapping(value="/process", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Person person, Map<String, Object> model) {

		System.out.println("ID: " + person.getId());
		System.out.println("EMAIl: " + person.getEmail());

		return "index";
	}
}
