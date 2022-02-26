package com.mba.projects.springprojforms001.camunda.service;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.mba.projects.springprojforms001.dto.Register;

import camundajar.impl.scala.collection.Map;

import java.net.URI;

import java.net.URISyntaxException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class SendMail implements JavaDelegate {
	private final Logger LOGGER = Logger.getLogger(SendMail.class.getName());
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		/*
		LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "activityName='" + execution.getCurrentActivityName() + "'"
	            + ", activityId=" + execution.getCurrentActivityId()
	            + ", processDefinitionId=" + execution.getProcessDefinitionId()
	            + ", processInstanceId=" + execution.getProcessInstanceId()
	            + ", businessKey=" + execution.getProcessBusinessKey()
	            + ", executionId=" + execution.getId()
	            + ", variables=" + execution.getVariables()
	            + " \n\n");
		*/
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI url = new URI("http://localhost:8000/api/send-mail");
		
		Register objReg = new Register();
		objReg.setName("Mohamed BEN AMOR");
		objReg.setEmail("med.benamor@eniso.u-sousse.tn");
		objReg.setPassword("pass");
		objReg.setPrice(11);

		HttpEntity<Register> requestEntity = new HttpEntity<>(objReg, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Register> responseEntity = restTemplate.postForEntity(url, requestEntity, Register.class);

		
		System.out.println("Status Code: " + responseEntity.getStatusCode());	
		System.out.println("Name: " + responseEntity.getBody().getName());	
		System.out.println("Email: " + responseEntity.getBody().getEmail());	
		System.out.println("Price: " + responseEntity.getBody().getPrice());		
		System.out.println("Password: " + responseEntity.getBody().getPassword());
		System.out.println("Location: " + responseEntity.getHeaders().getLocation());
		
		
	    
	}

}
