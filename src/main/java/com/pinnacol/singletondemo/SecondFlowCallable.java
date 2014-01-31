package com.pinnacol.singletondemo;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondFlowCallable implements Callable {
	
	@Autowired
	private Customer cust;
	
	public SecondFlowCallable() {}

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		MuleMessage message = eventContext.getMessage();
		
		if(this.cust != null) {
			
			System.out.println("cust object in second flow message contains: " + this.cust.getMessage());
			
		}
		else {
			throw new IllegalStateException("cust object is null in SecondFlowCallable");
		}
		
		return message;
	}

}
