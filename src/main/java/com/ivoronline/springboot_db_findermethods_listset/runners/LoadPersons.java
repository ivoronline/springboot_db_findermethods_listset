package com.ivoronline.springboot_db_findermethods_listset.runners;

import com.ivoronline.springboot_db_findermethods_listset.entities.Person;
import com.ivoronline.springboot_db_findermethods_listset.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoadPersons implements CommandLineRunner {

  @Autowired
  PersonRepository personRepository;

  //====================================================================================
  // RUN
  //====================================================================================
  @Override
  @Transactional
  public void run(String... args) {
    personRepository.save(new Person("John" , 20));
    personRepository.save(new Person("John" , 25));
    personRepository.save(new Person("Bill" , 30));
    personRepository.save(new Person("Nancy", 40));
  }

}



