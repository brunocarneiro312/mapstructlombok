package com.sandbox.mapstructlombok.mapper;

import com.sandbox.mapstructlombok.dto.PersonDTO;
import com.sandbox.mapstructlombok.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    private final PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

    @Test
    @DisplayName("Dado uma personDTO, quando mapear para person, então retorna uma person.")
    void toPerson() {

        // given
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(UUID.randomUUID().toString());
        personDTO.setName("TestName");
        personDTO.setEmail("testname@email.com");

        // when
        Person person = mapper.toPerson(personDTO);

        // then
        assertAll("Testando parsing para Person...",
                () -> assertNotNull(person, "A pessoa não deveria estar nula"),
                () -> assertNotNull(person.getId(), "O ID não deveria estar nulo"),
                () -> assertEquals(personDTO.getName(), person.getName(), "Os nomes deveriam ser iguais"),
                () -> assertEquals(personDTO.getEmail(), person.getEmail(), "Os emails deveriam ser iguais"));
    }

    @Test
    @DisplayName("Dado uma person, quando mapear para personDTO, então retorna uma personDTO.")
    void toDTO() {
    }
}