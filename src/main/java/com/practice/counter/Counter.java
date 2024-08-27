package com.practice.counter;

public class Counter implements Runnable{

	private int count = 0;

	public void increament() {
		count ++;
	}

	public void decrement() {
		count --;
	}

	public int getValue() {
		return count;
	}

	@Override
	public void run() {
		/* 동기화 처리 전
 		this.increament();
		System.out.println("Value for Thread After increment: " + this.getValue()); // Expect 1
		this.decrement();
		System.out.println("Value for Thread at Last: " + this.getValue()); // Expect 0

		*/
		synchronized (this) {
			this.increament();
			System.out.println("Value for Thread After increment: " + this.getValue()); // Expect 1
			this.decrement();
			System.out.println("Value for Thread at Last: " + this.getValue()); // Expect 0
		}
	}
}
