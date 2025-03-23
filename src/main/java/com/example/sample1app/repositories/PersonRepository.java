package com.example.sample1app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepositogit checkoutry;
import org.springframework.stereotype.Repository;

import com.example.sample1app.Person;
import java.util.List;


@Repository
public interface PersonRepository extends org.springframework.data.jpa.repository.JpaRepository<Person, Long>{
  public Optional<Person> findById(long id);
}
