package com.example.sample1app;

import java.util.List;
import java.util.Optional;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.PostConstruct;

import com.example.sample1app.repositories.PersonRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
public class HelloController {

    @Autowired
    PersonRepository repository;

    @RequestMapping("/")
    public ModelAndView index(@ModelAttribute("formModel") Person person, ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("title", "Hello page");
        mav.addObject("msg", "this is JPA sample data");
        List<Person> list = repository.findAll();
        mav.addObject("data", list);
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    // @Transactional
    public ModelAndView form(@ModelAttribute("formModel") @Valid @Validated Person person, BindingResult result,
            ModelAndView mav) {
        ModelAndView res;
        System.out.println(result.getFieldErrors()); // デバッグ用
        if (!result.hasErrors()) {
            repository.saveAndFlush(person);
            res = new ModelAndView("redirect:/");
        } else {
            mav.setViewName("index");
            mav.addObject("title", "Hello page");
            mav.addObject("msg", "sorry, error is occurred...");
            mav.addObject("errors", result.getFieldErrors()); // ★エラー情報を追加
            Iterable<Person> list = repository.findAll();
            mav.addObject("data", list);
            res = mav;
        }
        return res;
    }

    // 編集
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute Person person, @PathVariable Long id, ModelAndView mav) {
        mav.setViewName("edit");
        mav.addObject("title", "Edit Person");
        Optional<Person> data = repository.findById(id); // キャストを削除
        if (data.isPresent()) {
            mav.addObject("formModel", data.get());
        } else {
            // エラー処理 (例: エラーページを表示)
            mav.addObject("msg", "Person not found.");
            mav.setViewName("error"); // 必要に応じてエラーページを作成
        }
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Transactional
    public ModelAndView update(@ModelAttribute Person person, ModelAndView mav) {
        repository.saveAndFlush(person);
        return new ModelAndView("redirect:/"); // 一覧画面にリダイレクト
    }

    // 削除
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id, ModelAndView mav) {
        mav.setViewName("delete");
        mav.addObject("title", "Delete Person");
        mav.addObject("msg", "Can I delete this record?");
        Optional<Person> data = repository.findById((long) id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Transactional
    public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/");
    }

    // 初期値
    // @PostConstruct
    public void init() {
        Person p1 = new Person();
        p1.setName("taro");
        p1.setAge(39);
        p1.setMail("taro@yamada");
        repository.save(p1);

        Person p2 = new Person();
        p2.setName("hanako");
        p2.setAge(28);
        p2.setMail("hanako@sato");
        repository.save(p2);

        Person p3 = new Person();
        p3.setName("sachiko");
        p3.setAge(17);
        p3.setMail("sachiko@happy");
        repository.save(p3);
    }

    // @RestController
    // public class TestController {
    // @GetMapping("/test")
    // public String test() {
    // return "Hello, World!";
    // }
}
