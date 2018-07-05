package com.erocha.person.gateways;

import com.erocha.person.domains.Person;
import com.erocha.person.gateways.repository.PersonRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class PersonGateway {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public Page<Person> findByNameOrIdentityDocumentOrEmailOrDateBirth(String name, String identityDocument,
                                                                       String email, LocalDate dateBirth, PageRequest pageRequest) {

        return repository.findByNameOrIdentityDocumentOrEmailOrDateBirth(name, identityDocument, email, dateBirth, pageRequest);
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public void remove(Person person) {
        repository.delete(person);
    }

    public void remove(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Person> findById(Integer id) {
        return repository.findById(id);
    }


}
