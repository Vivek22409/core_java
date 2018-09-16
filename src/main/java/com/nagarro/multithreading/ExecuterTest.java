package com.nagarro.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Callable<Long>{
	
	private Long num1;
	private Long num2;	
	
	public Task(Long num1, Long num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		return num1+num2;
	}
	
}

public class ExecuterTest {
	public static void main(String arg[]) throws InterruptedException, ExecutionException{
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Task[] tasks = new Task[3];
		tasks[0] = new Task(3L,4L);
		tasks[1] = new Task(5L,6L);
		tasks[2] = new Task(7L,8L);
		
		List<Future<Long>> results = new ArrayList<Future<Long>>();
		for(int i=0; i<tasks.length;i++){
			Future<Long> tskResult= ex.submit(tasks[i]);
			results.add(tskResult);
		}
		
		Future<Long> f = ex.submit(new Task(8L,9L));
		results.add(f);
		ex.shutdown();
		
		for(Future<Long> tskResult:results){
			System.out.println(tskResult.get());
		}
	}
}
