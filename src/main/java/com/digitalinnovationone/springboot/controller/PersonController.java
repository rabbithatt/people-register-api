package com.digitalinnovationone.springboot.controller;

import com.digitalinnovationone.springboot.dto.MessageResponseDTO;
import com.digitalinnovationone.springboot.dto.request.PersonDTO;
import com.digitalinnovationone.springboot.entity.Person;
import com.digitalinnovationone.springboot.repository.PersonRepository;
import com.digitalinnovationone.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

}
