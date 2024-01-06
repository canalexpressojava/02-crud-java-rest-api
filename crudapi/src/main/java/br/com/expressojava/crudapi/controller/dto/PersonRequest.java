package br.com.expressojava.crudapi.controller.dto;

import br.com.expressojava.crudapi.domain.Person;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRequest {
    @JsonProperty("id")
    private long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("idade")
    private int age;
    @JsonProperty("telefone")
    private String phone;

    public PersonRequest(long id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person toModel() {
        return new Person(id, name, age, phone);
    }
}
