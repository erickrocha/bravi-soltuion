package com.erocha.person.gateways.http.mapper;

import com.erocha.person.domains.Contact;
import com.erocha.person.gateways.http.json.ContactTO;

import java.util.ArrayList;
import java.util.List;

public class ContactMapper {

    public ContactTO toContactTO(Contact c){
        return ContactTO.builder()
                .id(c.getId())
                .type(c.getType())
                .value(c.getValue())
                .build();
    }

    public List<ContactTO> contactTOS(List<Contact> contacts){
        List<ContactTO> contactTOS = new ArrayList<>();
        contacts.forEach(c -> contactTOS.add(toContactTO(c)));
        return contactTOS;
    }

    public Contact toContact(ContactTO c){
        return Contact.builder()
                .id(c.getId())
                .type(c.getType())
                .value(c.getValue())
                .build();
    }

    public List<Contact> contacts(List<ContactTO> contactTOS){
        List<Contact> contacts = new ArrayList<>();
        contactTOS.forEach(c -> contacts.add(toContact(c)));
        return contacts;
    }

}
