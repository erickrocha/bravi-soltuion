package com.erocha.person.usecases

import com.erocha.person.domains.Address
import com.erocha.person.domains.Contact
import com.erocha.person.domains.ContactType
import com.erocha.person.domains.Person
import com.erocha.person.exception.BusinessException
import com.erocha.person.gateways.PersonGateway
import org.assertj.core.util.Lists
import spock.lang.Specification

import java.time.LocalDate

class AddContactSpec extends Specification {

    private PersonGateway gateway = Mock(PersonGateway)
    private AddContact addContact = new AddContact(gateway: gateway)

    Person getPerson(){
        Person.builder()
                .dateBirth(LocalDate.of(2017, 12, 23))
                .name("James Bond")
                .identityDocument("33425367880")
                .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("jbond@jmail.com.br").build()))
                .address(Address.builder()
                .street("Rua Cunha Bastos")
                .neighborhood("Vila Paulista")
                .city("Limeira")
                .addressNumber("355")
                .complement("")
                .zipCode("13485063")
                .province("SP")
                .build()).build()
    }

    def "add a valid contact a valid person"() {
        given:"a valid contact and valid person "
        Contact contact = Contact.builder().id(1).type(ContactType.PHONE).value("199959595959").build()
        Person person = getPerson()
        gateway.findById(_ as Integer) >> {
            return Optional.of(person)
        }
        when: "I call method execute in add contact"
        addContact.execute(1, contact)
        then: "person must have two contacts"
        person.contacts.size() == 2
    }

    def "add a valid contact with invalid person"() {
        given:"a valid contact and valid person "
        Contact contact = Contact.builder().id(1).type(ContactType.PHONE).value("199959595959").build()
        gateway.findById(_ as Integer) >> {
            return Optional.empty()
        }
        when: "I call method execute in add contact"
        addContact.execute(1, contact)
        then: "person must have two contacts"
        thrown(BusinessException)
    }
}
