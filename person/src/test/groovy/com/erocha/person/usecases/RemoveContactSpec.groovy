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

class RemoveContactSpec extends Specification {

    private PersonGateway gateway = Mock(PersonGateway)
    private RemoveContact removeContact = new RemoveContact(gateway: gateway)

    Person getPerson() {
        Person.builder()
                .dateBirth(LocalDate.of(2017, 12, 23))
                .name("James Bond")
                .identityDocument("33425367880")
                .contacts(Lists.newArrayList(
                    Contact.builder().id(1).type(ContactType.EMAIL).value("jbond@jmail.com.br").build(),
                    Contact.builder().id(2).type(ContactType.PHONE).value("199999955959").build()))
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

    def "remove a valid contact from a valid person"() {
        given: "a valid contact and invalid person "
        Contact contact = Contact.builder().id(1).type(ContactType.PHONE).value("199959595959").build()
        Person person = getPerson()
        gateway.findById(_ as Integer) >> {
            return Optional.of(person)
        }
        when: "I call method execute in add contact"
        removeContact.execute(1, 2)
        then: "person must have one contact"
        person.contacts.size() == 1
    }

    def "remove a invalid contact with valid person"() {
        given: "a invalid contact and inva person "
        Contact contact = Contact.builder().id(1).type(ContactType.PHONE).value("199959595959").build()
        gateway.findById(_ as Integer) >> {
            return Optional.of(person)
        }
        when: "I call method execute in add contact"
        removeContact.execute(1, 5)
        then: "person must have two contacts"
        thrown(BusinessException)
    }

    def "remove a invalid contact with invalid person"() {
        given: "a invalid contact and inva person "
        Contact contact = Contact.builder().id(1).type(ContactType.PHONE).value("199959595959").build()
        gateway.findById(_ as Integer) >> {
            return Optional.empty()
        }
        when: "I call method execute in add contact"
        removeContact.execute(5, 5)
        then: "person must have two contacts"
        thrown(BusinessException)
    }
}
