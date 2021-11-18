package one.digitalinnovation.personMyApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {
	
	public PersonNotFoundException(Long id) {
		super("Esta não foi encontrada a pessoa com ID" + id);
		
	}

}
