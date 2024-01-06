package br.com.expressojava.crudapi.persistence;

import br.com.expressojava.crudapi.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonPersistence {
    Optional<Person> getById(long id);
    List<Person> getAll();
    void create(Person person);
    void update(Person person);
    void deleteById(long id);
}
