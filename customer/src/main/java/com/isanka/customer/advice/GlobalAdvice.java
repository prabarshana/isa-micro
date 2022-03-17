package com.isanka.customer.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.isanka.customer.exception.MyException;
import com.isanka.customer.exception.MyExeptionView;

@ControllerAdvice
public class GlobalAdvice {
	
	@ExceptionHandler(MyException.class)
	private ResponseEntity<MyExeptionView> handleConfli(MyException e) {
		
		MyExeptionView view = new MyExeptionView();
		view.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		view.setMessage("Shit happenned");
		view.setThrowable(e.getCause());
		
	    return new ResponseEntity<MyExeptionView>(view, HttpStatus.ACCEPTED);
	}

}
