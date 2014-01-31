package com.pinnacol.prototypedemo;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrototypeDemoCallable implements Callable {
	
	@Autowired
	private PersonService personService;

	
	public PrototypeDemoCallable() {}
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		MuleMessage message = eventContext.getMessage();
		
		if(this.personService != null) {
			
			System.out.println("personService name contains " + this.personService.getName());
			
			System.out.println("setting name to \"Dave\"");
			this.personService.setName("Dave");
			
			System.out.println("personService name contains : " + this.personService.getName());
			
		}
		else {
			throw new IllegalStateException("personService is null");
		}
		
		return message;
	}

}
