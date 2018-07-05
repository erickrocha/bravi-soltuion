package com.erocha.person.usecases;

import com.erocha.person.domains.Person;
import com.erocha.person.gateways.PersonGateway;
import com.erocha.person.gateways.http.json.PersonTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GetPerson {

    @Autowired
    private PersonGateway gateway;

    public Person execute(Integer id) {
        Optional<Person> person = gateway.findById(id);
        return person.isPresent() ? person.get() : null;
    }

    public List<Person> execute() {
        return gateway.findAll();
    }

    public Page<Person> execute(String name, String identityDocument, String email,
                                LocalDate dateBirth, PageRequest pageRequest) {
        return gateway.findByNameOrIdentityDocumentOrEmailOrDateBirth(name, identityDocument, email,
                dateBirth, pageRequest);
    }


}
