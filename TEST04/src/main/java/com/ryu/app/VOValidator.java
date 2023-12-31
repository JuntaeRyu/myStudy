package com.ryu.app;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


public class VOValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// 유효성 검사할 객체의 클래스 정보를 반환
		return VO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { //Errors errors도 커맨드 객체, 참조 변수
		// target : 유효성 검사할 객체
		// errors : 검증이 통과되지 못한 경우, 왜 통과가 안되었는지를 반환
		
		VO vo=(VO)target;
		String id=vo.getId();
		String password=vo.getPassword();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id값없음");
		if(id.length()<=5) {
			errors.rejectValue("id", "id값이 5자리 이하임");
		}
		// 전부 다 확인 가능
		// 밑에 라인을 대신해주는 코드
//		if(id.length()<=5 || id==null || id.isEmpty() || id.isBlank() || id.trim().isEmpty() || id.trim().isBlank()) {
//			System.out.println("로그 : id값이 올바르지않습니다");
//			errors.rejectValue("id", "id값없음");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password값없음");
//		if(password==null || password.isEmpty() || password.isBlank() || password.trim().isEmpty() || password.trim().isBlank()) {
//			System.out.println("로그 : password값이 올바르지않습니다");
//			errors.rejectValue("password", "password값없음");
//		}
	}

}
