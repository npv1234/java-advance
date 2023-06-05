package com.vti;

//SINGLETON: Duy nhất(chỉ khởi tạo một lần)
public class DemoSingleton2 {//Lazy singleton
	
	private static DemoSingleton2 instance;
		
	public static DemoSingleton2 getInstance() {
		if (instance == null) {
			instance = new DemoSingleton2();
		}
		return instance;
	}
	
	private DemoSingleton2() {
		System.out.println("DemoSingleton2 created...");
	}
	
	public void connectDb() {
		System.out.println("Connect db...");
	}
}
