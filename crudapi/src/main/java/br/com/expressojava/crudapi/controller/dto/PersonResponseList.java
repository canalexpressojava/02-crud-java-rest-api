package br.com.expressojava.crudapi.controller.dto;

import br.com.expressojava.crudapi.domain.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ProblemDetail;

import java.util.List;

public class PersonResponseList {
    @JsonProperty("pessoas")
    private List<PersonResponse> personList;

    public PersonResponseList(List<PersonResponse> personList) {
        this.personList = personList;
    }

    public static PersonResponseList fromDomain(List<Person> personList) {
        List<PersonResponse> people = personList.stream()
                .map(PersonResponse::fromDomain)
                .toList();
        return new PersonResponseList(people);
    }
}
