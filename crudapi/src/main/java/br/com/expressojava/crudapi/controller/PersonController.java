package br.com.expressojava.crudapi.controller;

import br.com.expressojava.crudapi.controller.dto.PersonRequest;
import br.com.expressojava.crudapi.controller.dto.PersonResponse;
import br.com.expressojava.crudapi.controller.dto.PersonResponseList;
import br.com.expressojava.crudapi.domain.Person;
import br.com.expressojava.crudapi.persistence.PersonPersistence;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/person")
public class PersonController {
    private final PersonPersistence personPersistence;

    public PersonController(PersonPersistence personPersistence) {
        this.personPersistence = personPersistence;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getById(@PathVariable("id") long id){
        Optional<Person> foundPerson = personPersistence.getById(id);
        return ResponseEntity.of(PersonResponse.fromDomain(foundPerson));
    }

    @GetMapping
    public ResponseEntity<PersonResponseList> getAll(){
        List<Person> personList = personPersistence.getAll();
        return ResponseEntity.ok(PersonResponseList.fromDomain(personList));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PersonRequest personRequest){
        personPersistence.create(personRequest.toModel());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeById(@PathVariable("id") long id){
        personPersistence.deleteById(id);
    }
}
