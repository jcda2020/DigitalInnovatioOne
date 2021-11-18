package one.digitalinnovation.personMyApi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import one.digitalinnovation.personMyApi.dto.request.PersonDTO;
import one.digitalinnovation.personMyApi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personMyApi.entity.Person;
import one.digitalinnovation.personMyApi.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	
	@Mock 
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonDTOThenReturnSavedMessage() {
		
		PersonDTO personDTO = createFakeDTO();
		
		Person expectedSavedPerson = createFakeEntity();
		
		MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
	}
	
	private MessageResponseDTO createExpectedMessageResponse(Long id) {
		
		return MessageResponseDTO.builder()
				.message("Created Person with ID" + id)
				.build();
	}

}
