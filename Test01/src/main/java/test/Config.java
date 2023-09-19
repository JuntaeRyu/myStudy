package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정 클래스
// Configuration : 프로그램의 설정을 저장해두고 환경을 구성하는 데에 사용하는 파일
@Configuration
public class Config {

	@Bean	// 스프링이 IoC 컨테이너로 관리하는 객체
	public PhoneA phoneA() {
		return new PhoneA();
	}
	@Bean	// 이름 설정을 별도로 하지않으면 person1 << 메서드명이 등록됨
	public PhoneB phoneB() {
		return new PhoneB();
	}
	
	@Bean
	public Person person1() {
		// 생성자 주입
		return new Person("작은 사람", new PhoneA());			
	}
	public Person person2() {
		// setter 주입
		Person person=new Person();
		person.setName("큰사람");
		person.setPhone(new PhoneA());
		return person;
	}
	
}
