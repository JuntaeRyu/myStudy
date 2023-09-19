package test;

public class PhoneA implements Phone{

	@Override
	public void call(String name) {
		System.out.println("PhoneA : "+ name + "이(가) 전화거는중...");
	}

	
}
