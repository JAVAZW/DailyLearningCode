package com.zw.cloud;



import rx.Observable;
import rx.Observer;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommandRunMain {
	
	public static void main(String[] args) throws InterruptedException {
		RunCommand runCommand = new RunCommand("observe method");
		runCommand.observe();
		
		RunCommand runCommand1 = new RunCommand("toObservable method");
		Observable<String> ob = runCommand1.toObservable();
		ob.subscribe(new Observer<String>(){

			public void onCompleted() {
				System.out.println("completed----");
			}

			public void onError(Throwable arg0) {
				
			}

			public void onNext(String t) {
				System.out.println("####"+t);
				
			}
			
		});
		
		Thread.sleep(10000);
	}

	static class RunCommand extends HystrixCommand<String>{
		String msg;
		protected RunCommand(String msg) {
			super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
			this.msg = msg;
		}
		@Override
		protected String run() throws Exception {
			System.out.println(msg);
			return "success";
		}

	} 
}
