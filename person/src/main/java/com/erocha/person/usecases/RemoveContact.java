package com.erocha.person.usecases;

import com.erocha.person.domains.Contact;
import com.erocha.person.domains.Person;
import com.erocha.person.gateways.PersonGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoveContact {

    private PersonGateway gateway;

    public void execute(Integer personId, Integer contactId){
        Optional<Person> op = gateway.findById(personId);
        if (op.isPresent()){
            Person person = op.get();
            Optional<Contact> contact = person.getContacts().stream().filter(c -> c.getId().equals(contactId)).findFirst();
            if (contact.isPresent()){
                person.getContacts().remove(contact.get());
                gateway.save(person);
            }
        }
    }
}