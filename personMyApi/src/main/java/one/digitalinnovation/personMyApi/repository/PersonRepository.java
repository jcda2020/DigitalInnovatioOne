package one.digitalinnovation.personMyApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.personMyApi.entity.Person;

public interface PersonRepository extends JpaRepository <Person, Long>{

}
