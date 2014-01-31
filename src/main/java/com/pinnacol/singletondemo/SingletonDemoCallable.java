package com.pinnacol.singletondemo;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SingletonDemoCallable implements Callable {

	@Autowired
	private Customer cust;
	
	public SingletonDemoCallable() {}
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		MuleMessage message = eventContext.getMessage();
		
		
		
		if(this.cust != null) {
			System.out.println("SingletonDemoCallable contains : " + cust.getMessage());
			
			System.out.println("changing message to \"My New Message!!\"");
			cust.setMessage("My New Message!!");
			
			
			System.out.println("In SingletonDemoCallable - message now contains : " + this.cust.getMessage());
		}
		else {
			throw new IllegalStateException("cust bean is null");
		}
		
		return message;
	}

}
