package com.erocha.person.usecases;

import com.erocha.person.domains.Person;
import com.erocha.person.gateways.PersonGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPerson {

    @Autowired
    private PersonGateway gateway;

    public Person execute(Person person){
        return gateway.save(person);
    }
}
