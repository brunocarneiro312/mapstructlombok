package com.sandbox.mapstructlombok.mapper;

import com.sandbox.mapstructlombok.dto.PersonDTO;
import com.sandbox.mapstructlombok.model.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {
    Person toPerson(PersonDTO dto);
    PersonDTO toDTO(Person person);
}
