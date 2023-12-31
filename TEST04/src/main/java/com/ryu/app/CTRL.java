package com.ryu.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class CTRL {

//	public boolean 모듈화(VO vo) {
//		if(vo.getId() == null || vo.getId().isEmpty() || vo.getId().isBlank() ||vo.getId().equals("")) {
//
//		}
//		if(vo.getPassword().length()<=5) {
//
//		}
//	}


	@RequestMapping("/")
	public String root() {
		return "test";
	}
	
	@RequestMapping("/test")	// requestPost 써도되지만 하나밖에없기때문에 구분 x
	public String test(@Valid VO vo, BindingResult br, Model model) {
		/////
		// VOValidator voV=new VOValidator(); 로직코드에 new가 있으면 유지보수가 힘듬
		// voV.validate(vo, br);	// br는 커맨드 객체(참조 변수) 여러개의 reject상황을 반환하기 위해 사용	<== @Valid
		if(br.hasErrors()) {
			System.out.println("발생한 에러목록");
			System.out.println(br.getAllErrors());	// for문과 잘어울림
			
			if(br.getFieldError("id") != null) {	// id에서 Error가 발생했다는 의미
				// System.out.println(br.getFieldError("id").getCode());
				System.out.println(br.getFieldError("id").getDefaultMessage());
			}
			if(br.getFieldError("password") != null) {	// password에서 Error가 발생했다는 의미
				//	System.out.println(br.getFieldError("password").getCode());
				System.out.println(br.getFieldError("password").getDefaultMessage());
			}
			
		}
		/////
		model.addAttribute("apple", vo.getId());
		return "test";
	}
	
//	@InitBinder	// (옛날 방식) 어노테이션(initbinder)을 통해 new해줌
//	protected void initBinder(WebDataBinder wdb) {
//		wdb.setValidator(new VOValidator());
//	}
	

}
