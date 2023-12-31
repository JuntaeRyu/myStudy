package test;

public class Person {
	private String name;
	private Phone phone;
	
	public Person() {
		System.out.println("Person 기본생성자 호출됨");
	}
	
	public Person(String name, Phone phone) {	// 오버로딩
		this.name = name;
		this.phone = phone;
		System.out.println("Person 생성지 호출됨");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + "]";
	}
	
	public void print() {
		phone.call(name);	// this 키워드는 생략가능
	}
	
	
}
