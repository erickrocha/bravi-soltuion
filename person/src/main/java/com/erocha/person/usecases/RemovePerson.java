package com.erocha.person.usecases;

import com.erocha.person.domains.Person;
import com.erocha.person.gateways.PersonGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemovePerson {

    @Autowired
    private PersonGateway gateway;

    public void execute(Integer id){
        gateway.remove(id);
    }

    public void execute(Person person){
        gateway.remove(person);
    }
}
