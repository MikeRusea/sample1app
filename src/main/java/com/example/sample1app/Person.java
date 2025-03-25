package com.example.sample1app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id; // Longオブジェクトを使用

    @Column(length = 50, nullable = false)
    @NotBlank(message = "{jakarta.validation.constraints.NotBlank.message}")
    private String name;

    @Column(length = 200, nullable = true)
    @Email(message = "{jakarta.validation.constraints.Email.message}")
    private String mail;

    @Column(nullable = true)
    @Min(value = 0, message = "{jakarta.validation.constraints.Min.message}")
    @Max(value = 200, message = "{jakarta.validation.constraints.Max.message}")
    private Integer age;

    @Column(nullable = true)
    private String memo;

    // ゲッターとセッター
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}