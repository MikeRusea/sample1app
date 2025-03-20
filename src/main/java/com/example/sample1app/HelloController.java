package com.example.sample1app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample1app.repositories.PersonRepository;

import jakarta.transaction.Transactional;

@Controller
public class HelloController {  

  @Autowired
  PersonRepository repository;

  @RequestMapping("/")
  public ModelAndView index(@ModelAttribute("formModel") Person person, ModelAndView mav){
      mav.setViewName("index");
      mav.addObject("title", "Hello page");
      mav.addObject("msg", "this is JPA sample data");
      Iterable<Person> list = repository.findAll();
      mav.addObject("data", list);
      return mav;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @Transactional
  public ModelAndView form(@ModelAttribute("formModel") Person person, ModelAndView mav){
    repository.save(person);
    return new ModelAndView("redirect:/");
  }

}
