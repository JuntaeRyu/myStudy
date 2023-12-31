package com.ryu.app;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.Config;
import test.Person;

/////@SpringBootApplication
public class Test01Application {

	public static void main(String[] args) {
		/////SpringApplication.run(Test01Application.class, args);

		// 1. 스프링 IoC 컨테이너 구동시키기
		// 1-2. 컨테이너를 구동시킬때에 설정파일이 필요함
		//	(스프링에서는 .xml / 부트에선ㄴ .java
		ApplicationContext ac= new AnnotationConfigApplicationContext(Config.class);
		// 컨테이너는 팩토리 패턴을 기반으로 동작하고 있음


		Person person1 = (Person)ac.getBean("person1");
		person1.print();
		Person person2 = (Person)ac.getBean("person1");
		person2.print();

		// 2. 싱글톤 유지되는지 확인
		if(person1 == person2) {
			System.out.println("둘은 동일한 객체인이디");
		}
		else {
			System.out.println("둘은 동일한 객체인이디");
		}
		// 부트방식을 전부 활용 xxx
		// 개발자가 person 객체를 2개 등록 -> 싱글톤 유지 xx
		// 개발자가 (직접 new를 작성한 상황) person 객체를 2개 등록
	}
}
