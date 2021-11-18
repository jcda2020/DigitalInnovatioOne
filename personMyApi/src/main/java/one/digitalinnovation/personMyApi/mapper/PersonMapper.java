package one.digitalinnovation.personMyApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import one.digitalinnovation.personMyApi.dto.request.PersonDTO;
import one.digitalinnovation.personMyApi.entity.Person;

@Mapper 
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyy")
    
	Person toModel(PersonDTO personDto);
	
	PersonDTO toDTO(Person person);
}
