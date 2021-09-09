package com.ivoronline.springboot_db_findermethods_listset.repositories;

import com.ivoronline.springboot_db_findermethods_listset.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PersonRepository extends JpaRepository<Person, Integer> {
  List<Person> findListByAgeLessThan(Integer age);
  Set<Person>  findSetByAgeLessThan (Integer age);
}
