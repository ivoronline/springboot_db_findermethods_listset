package com.ivoronline.springboot_db_findermethods_listset.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivoronline.springboot_db_findermethods_listset.entities.Person;
import com.ivoronline.springboot_db_findermethods_listset.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Set;

@Controller
public class MyController {

  @Autowired PersonRepository personRepository;

  //====================================================================================
  // GET LIST
  //====================================================================================
  @ResponseBody
  @RequestMapping("GetList")
  List<Person> getList() throws JsonProcessingException {

    //CREATE ENTITY OBJECT
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

    //RETURN SOMETHING TO BROWSER
    return persons;

  }

  //====================================================================================
  // GET SET
  //====================================================================================
  @ResponseBody
  @RequestMapping("GetSet")
  Set<Person> getSet() throws JsonProcessingException {

    //CREATE ENTITY OBJECT
    Set<Person> persons = personRepository.findSetByAgeLessThan(100);

    //ITERATE THROUGH SET
    for(Person person : persons) {
      String personJSON = new ObjectMapper().writeValueAsString(person);
      System.out.println(personJSON);
    }

    //RETURN SOMETHING TO BROWSER
    return persons;

  }

}
