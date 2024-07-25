package com.ivoronline.springboot_db_findermethods_listset.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivoronline.springboot_db_findermethods_listset.entities.Person;
import com.ivoronline.springboot_db_findermethods_listset.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class MyController {

  @Autowired PersonRepository personRepository;

  //====================================================================================
  // GET LIST
  //====================================================================================
  @ResponseBody
  @RequestMapping("getList")
  List<Person> getList() throws JsonProcessingException {

    //GET RECORDS
    List<Person> persons = personRepository.findListByAgeLessThan(100);

    //GET PERSON FROM LIST
    Person person0     = persons.get(0);
    String person0JSON = new ObjectMapper().writeValueAsString(person0);
    System.out.println(person0JSON);

    //ITERATE THROUGH LIST
    for(Person person : persons) {
      String personJSON = new ObjectMapper().writeValueAsString(person);
      System.out.println(personJSON);
    }

    //RETURN RECORDS
    return persons;

  }

  //====================================================================================
  // GET SET
  //====================================================================================
  @ResponseBody
  @RequestMapping("getSet")
  Set<Person> getSet() throws JsonProcessingException {

    //GET RECORDS
    Set<Person> persons = personRepository.findSetByAgeLessThan(100);

    //ITERATE THROUGH SET
    for(Person person : persons) {
      String personJSON = new ObjectMapper().writeValueAsString(person);
      System.out.println(personJSON);
    }

    //RETURN RECORDS
    return persons;

  }
  
  //====================================================================================
  // GET MAP
  //====================================================================================
  @ResponseBody
  @RequestMapping("getMap")
  Collection<Person> getMap() throws JsonProcessingException {

    //GET RECORDS INTO MAP
    List<Integer> ids = List.of(1, 3, 4);
    List<Person>  personList = personRepository.findAllById(ids);
    Map<Integer, Person> persons = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

    //GET PERSON FROM MAP
    Person bill        = persons.get(3);
    String billJSON = new ObjectMapper().writeValueAsString(bill);
    System.out.println(billJSON);

    //ITERATE THROUGH MAP
    for(Person person : persons.values()) {
      String personJSON = new ObjectMapper().writeValueAsString(person);
      System.out.println(personJSON);
    }

    //RETURN RECORDS
    return persons.values();

  }
  
}
