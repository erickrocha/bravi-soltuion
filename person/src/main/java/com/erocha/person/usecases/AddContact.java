package com.erocha.person.usecases;

import com.erocha.person.domains.Contact;
import com.erocha.person.domains.Person;
import com.erocha.person.exception.BusinessException;
import com.erocha.person.gateways.PersonGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddContact {

    @Autowired
    private PersonGateway gateway;

    public void execute(Integer personId, Contact contact){
        Optional<Person> op = gateway.findById(personId);
        if (op.isPresent()){
            Person person = op.get();
            person.addContact(contact);
            gateway.save(person);
        }else{
            throw new BusinessException("USER_NOT_FOUND","User not found");
        }
    }
}
