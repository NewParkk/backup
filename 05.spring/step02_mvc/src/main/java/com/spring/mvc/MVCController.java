package com.spring.mvc;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import user.dto.User;

@Controller
public class MVCController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1 () {
		System.out.println("MVCController : test1");
	}
	
	@RequestMapping(value ="/test2", method = RequestMethod.GET)
	public void test2 (HttpServletRequest request) {
		System.out.println("MVCController : test2");
		String id = request.getParameter("id");
		System.out.println(id);
	}
	@RequestMapping(value =  "/test3", method = RequestMethod.GET)
	public void test3 (@RequestParam String id) {
		System.out.println("MVCController : test3");
		System.out.println(id);
	}
	
	// /test4?id=dev&age=28 ---> User 객체생성?
	
	@RequestMapping(value =  "/test4", method = RequestMethod.GET)
	public void test4 (@RequestParam String id,@RequestParam Integer age) {
		
		// User객체
		User user = new User().builder()
								.id(id)
								.age(age)
								.build();
		System.out.println(user);
	}
	@RequestMapping(value = "/test5", method =RequestMethod.POST)
	// /test5?id=dev&age=28 ---> User 객체생성?
	// @ModelAttribute : get -> params --> O
	//				   : get -> body (form-data, urlencoded) --> X
	//				   : post -> body (form-data) --> X
	//				   : post -> body (urlencoded) --> O
	public void test5(@ModelAttribute User user) {
		System.out.println("MVCController : test5");
		System.out.println(user);
	}
	
	// http://localhost:8080/mvc/test6
	@RequestMapping(value =  "/test6", consumes = {MediaType.APPLICATION_JSON_VALUE},method = RequestMethod.POST)
	public void test6 (@RequestBody User user) {
		System.out.println("MVCController : test6");
		System.out.println(user);
	}
	
	// http://localhost:8080/mvc/test7/dept/10
	@RequestMapping(value = "/test7/dept/{deptno}", method =RequestMethod.GET)
	public void test7(@PathVariable int deptno) {
		System.out.println("MVCController : test7");
		System.out.println(deptno);
	}
	
	// http://localhost:8080/mvc/test8
	@RequestMapping(value= "/test8", method =RequestMethod.GET)
	public String test8(Model model) {
		model.addAttribute("id", "dev");
		return "test8";
	}
	
	// http://localhost:8080/mvc/test9
	@RequestMapping(value= "/test9", method =RequestMethod.GET)
	public ModelAndView test9(Model model, ModelAndView mv) {
		model.addAttribute("id", "dev");
		
		// mv
		mv.addObject("name", "it");
		mv.setViewName("test9");
		
		return mv;
	}
	
	// http://localhost:8080/mvc/test10?id=dev&age=28
	@ResponseBody
	@RequestMapping(value= "/test10", method =RequestMethod.GET)
	public User test10(@ModelAttribute User user) {
		user.setAge(29);
		return user;
	}
	
	
	// http://localhost:8080/mvc/test11
	@RequestMapping(value= "/test11", method =RequestMethod.GET)
	public ResponseEntity<String> test11() {
		
		String data = "{\"id\" : \"dev\", \"age\" : 28}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<String>(data, headers, HttpStatus.OK);
	}
	
	@GetMapping(value= {"/test12", "/test012"},
				consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.MULTIPART_FORM_DATA_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public void test12() {
		System.out.println("test12");
		
		/*
		 * consumes : client로부터 전달받은 데이터의 타입 정하는 속성
		 * produces : client로 전달예정인 데이터의 타입 정하는 속성
		 */
		
	}
	
	
	
	
	
}
