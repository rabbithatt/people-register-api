package com.digitalinnovationone.springboot.service;

import com.digitalinnovationone.springboot.dto.MessageResponseDTO;
import com.digitalinnovationone.springboot.dto.request.PersonDTO;
import com.digitalinnovationone.springboot.entity.Person;
import com.digitalinnovationone.springboot.mapper.PersonMapper;
import com.digitalinnovationone.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper  personMapper= PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);


        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
