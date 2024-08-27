package com.practice.counter;

public class RaceConditionDemo {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread t1 = new Thread(counter, "Thread.1");
		Thread t2 = new Thread(counter, "Thread.2");
		Thread t3 = new Thread(counter, "Thread.3");

		t1.start();
		t2.start();
		t3.start();
	}

	// 하나의 count 에 여러 스레드가 접근하는 Race Condition 상태로 멀티스레드 환경에서 스레드-안전이 아니다.
	// 비동기 처리로 해결가능
	// 따라서 싱글톤 객체에서는 상태를 유지하게 설계하면 안됨
}
