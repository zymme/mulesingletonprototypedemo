package com.pinnacol.prototypedemo;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondFlowProtoCallable implements Callable {

	@Autowired
	private PersonService personService;
	
	public SecondFlowProtoCallable() {}
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		MuleMessage message = eventContext.getMessage();
		
		if(this.personService != null) {
			
			System.out.println("personService name contains : " + this.personService.getName());
			
		}
		else {
			throw new IllegalStateException("personService object is null");
		}
		
		return message;
	}

}
