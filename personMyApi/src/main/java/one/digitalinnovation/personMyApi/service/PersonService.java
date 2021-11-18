package one.digitalinnovation.personMyApi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personMyApi.dto.request.PersonDTO;
import one.digitalinnovation.personMyApi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personMyApi.entity.Person;
import one.digitalinnovation.personMyApi.exception.PersonNotFoundException;
import one.digitalinnovation.personMyApi.mapper.PersonMapper;
import one.digitalinnovation.personMyApi.repository.PersonRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;
	

    
    @Autowired
    public PersonService(PersonRepository personRepository) {
    	this.personRepository = personRepository; 
    	
    }

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    
  

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
    
        
        
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    
    
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
    	return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}