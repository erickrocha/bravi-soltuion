package com.erocha.person.gateways.http.mapper;

import com.erocha.person.domains.Person;
import com.erocha.person.gateways.http.json.PersonTO;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    private AddressMapper addressMapper;
    private ContactMapper contactMapper;

    public PersonMapper(AddressMapper addressMapper, ContactMapper contactMapper) {
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
    }

    public PersonMapper() {
        this(new AddressMapper(), new ContactMapper());
    }

    public PersonTO toPersonTO(Person person) {
        if (person != null) {
            return PersonTO.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .dateBirth(person.getDateBirth())
                    .identityDocument(person.getIdentityDocument())
                    .address(addressMapper.toAddressTO(person.getAddress()))
                    .contacts(contactMapper.contactTOS(person.getContacts()))
                    .build();
        }
        return null;
    }

    public List<PersonTO> toPeopleTO(List<Person> people) {
        List<PersonTO> peopleTOS = new ArrayList<>();
        people.forEach(person -> peopleTOS.add(toPersonTO(person)));
        return peopleTOS;
    }

    public Person toPerson(PersonTO to) {
        if (to != null) {
            return Person.builder()
                    .name(to.getName())
                    .dateBirth(to.getDateBirth())
                    .identityDocument(to.getIdentityDocument())
                    .address(addressMapper.toAddress(to.getAddress()))
                    .contacts(contactMapper.contacts(to.getContacts()))
                    .build();
        }
        return null;
    }

    public List<Person> toPeople(List<PersonTO> peopleTO) {
        List<Person> people = new ArrayList<>();
        peopleTO.forEach(personTO -> people.add(toPerson(personTO)));
        return people;
    }
}
