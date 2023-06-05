package com.vti;

//SINGLETON: Duy nhất(chỉ khởi tạo một lần)
public class DemoSingleton {//Eager singleton
	
	private static DemoSingleton instance = new DemoSingleton();
		
	public static DemoSingleton getInstance() {
		return instance;
	}
	
	private DemoSingleton() {
		
	}
	
	public void connectDb() {
		System.out.println("Connect db...");
	}
}
