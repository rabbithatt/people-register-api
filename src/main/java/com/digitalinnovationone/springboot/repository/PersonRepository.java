package com.digitalinnovationone.springboot.repository;

import com.digitalinnovationone.springboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
