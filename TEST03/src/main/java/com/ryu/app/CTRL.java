package com.ryu.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CTRL {

	@RequestMapping("/")
	public @ResponseBody String root() {
		return "루트요청";
	}
	
	// request 자체가 not POJO인 servlet 객체이기때문에 활용도가 낮다
	// ★
	@RequestMapping("/test")
	public String test(VO vo) {
		System.out.println("vo: "+vo);
		// 커맨드객체를 이용하여 model을 활용하지 않고도 값 출력가능
		
		return "test";
	}

	@RequestMapping("/test01")
	public String test02(HttpServletRequest request, Model model) {
		model.addAttribute("apple", request.getParameter("id"));
		return "test";
	}	// request 자체가 not POJO인 Servlet 객체이기 때문에 활용도가 낮다
	
	@RequestMapping("/test02")
	public String test02(@RequestParam("id")String id,@RequestParam("name")String name, Model model) {
		model.addAttribute("apple", id);
		return "test";
	}	// 가독성이 커맨드 객체를 사용할 때보다 별로임(그치만 성능은 크게 다르지않음)

	@RequestMapping("/test03/{id}/{name}")
	public String test03(@PathVariable String id, @PathVariable String name, Model model) {
		model.addAttribute("apple", id);
		return "test";
	}	// URL에 데이터를 바로 보내는 방법 ☆ PathVariable을 사용
}
