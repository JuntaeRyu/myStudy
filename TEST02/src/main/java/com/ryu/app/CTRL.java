package com.ryu.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // component도 가능하지만 가독성을 위해 controller를 사용
public class CTRL {

	@RequestMapping("/") // 루트 요청
	public @ResponseBody String root() {
		return "롬복 예제입니다!";
		// VR xxx
		// 문자열 "값"
	}
	
	@RequestMapping("/test") // 루트 요청
	public String test(VO vo, Model model) {
						// 커맨드 객체
		System.out.println("vo : "+vo);
		model.addAttribute("apple" , vo.getId());
		return "test";
		// /WEB-INF/views/test.jsp
	}
}
