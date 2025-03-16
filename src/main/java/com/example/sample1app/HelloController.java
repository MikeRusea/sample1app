package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {  
  @RequestMapping("/{month}")
  public ModelAndView index(@PathVariable int month, ModelAndView mav){
      mav.setViewName("index");
      mav.addObject("msg", + month + "月は？");
      mav.addObject("month", month);
    return mav;
  }
}
