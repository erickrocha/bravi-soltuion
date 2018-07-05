package com.erocha.person.config.bootstrap.service;

import com.erocha.person.domains.Address;
import com.erocha.person.domains.Contact;
import com.erocha.person.domains.ContactType;
import com.erocha.person.domains.Person;
import com.erocha.person.gateways.repository.PersonRepository;
import com.google.common.collect.Lists;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@Log
public class DatabasePopulatorService {

    @Autowired
    private PersonRepository personRepository;

    public void execute() {
        log.info("----------------------- Data Load started ------------------------------------");

        personRepository.saveAll(Lists.newArrayList(
                Person.builder()
                        .dateBirth(LocalDate.of(2018, 01, 23))
                        .name("Erick Pereira da Rocha")
                        .identityDocument("33124367880")
                        .address(Address.builder()
                                .street("Emilio Kuntz Buch")
                                .neighborhood("Anavec - 2")
                                .city("Limeira")
                                .addressNumber("787")
                                .complement("")
                                .zipCode("13485161")
                                .province("SP")
                                .build())
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.PHONE).value("19999722793").build(),
                                Contact.builder().type(ContactType.WHATSAPP).value("19999722793").build(),
                                Contact.builder().type(ContactType.EMAIL).value("erocha@jmail.com.br").build()))
                        .build(),
                Person.builder()
                        .dateBirth(LocalDate.of(2017, 07, 03))
                        .name("John Smith")
                        .identityDocument("33124367875")
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("erocha@jmail.com.br").build()))
                        .address(Address.builder()
                                .street("Rua Adelmo Aires Negri")
                                .neighborhood("Jardim Sevilha")
                                .city("Gurupi")
                                .zipCode("13485157")
                                .complement("")
                                .addressNumber("349")
                                .province("TO")
                                .build())
                        .build(),
                Person.builder()
                        .dateBirth(LocalDate.of(2017, 07, 21))
                        .name("Darth Vadder")
                        .identityDocument("33124364580")
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("dvadder@jmail.com.br").build()))
                        .address(Address.builder()
                                .street("Rodovia BR-010")
                                .neighborhood("Vila Ipiranga")
                                .city("Imperatriz")
                                .addressNumber("242")
                                .complement("")
                                .zipCode("13485142")
                                .province("MA")
                                .build())
                        .build(),
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
                                .build())
                        .build(),
                Person.builder()
                        .dateBirth(LocalDate.of(2017, 12, 23))
                        .name("Carlos Lorenzo Pietro Melo")
                        .identityDocument("03140721870")
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("carlos.melo_@bucaneiro.com.br").build()))
                        .address(Address.builder()
                                .street("Rua Albano Angolini")
                                .neighborhood("Chácara Recreio Cruzeiro do Sul")
                                .city("Santa Bárbara D'Oeste")
                                .addressNumber("650")
                                .zipCode("13459368")
                                .complement("")
                                .province("SP")
                                .build())
                        .build(),
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
                                .build())
                        .build(),
                Person.builder()
                        .dateBirth(LocalDate.of(1996, 06, 24))
                        .name("Rua Advogado Júlio Cardella")
                        .identityDocument("17518593807")
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("fneves@jmmarcenaria.com.br").build()))
                        .address(Address.builder()
                                .street("Rua Advogado Júlio Cardella")
                                .neighborhood("Swiss Park")
                                .city("Campinas")
                                .addressNumber("817")
                                .complement("")
                                .zipCode("13485063")
                                .province("SP")
                                .build())
                        .build(),
                Person.builder()
                        .dateBirth(LocalDate.of(2017, 12, 23))
                        .name("Bento Guilherme Campos")
                        .identityDocument("01726440893")
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("bento.campos@weatherford.com").build()))
                        .address(Address.builder()
                                .street("Rua João Garcia Dutra")
                                .neighborhood("Cidade Domitila")
                                .city("São Paulo")
                                .addressNumber("402")
                                .complement("Ap 15 Bloco D")
                                .zipCode("13485063")
                                .province("SP")
                                .build())
                        .build(),
                Person.builder()
                        .dateBirth(LocalDate.of(2017, 12, 23))
                        .name("Davi Lucca Duarte")
                        .identityDocument("65508619852")
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("daviluccaduarte_@cvc.com.br").build()))
                        .address(Address.builder()
                                .street("Rua Pádua")
                                .neighborhood("Jardim Ipanema")
                                .city("Santo André")
                                .addressNumber("844")
                                .complement("")
                                .zipCode("09121520")
                                .province("SP")
                                .build())
                        .build(),
                Person.builder()
                        .dateBirth(LocalDate.of(2017, 12, 23))
                        .name("Leandro Raul Edson Peixoto")
                        .identityDocument("52294867831")
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("leandrorauledsonpeixoto_@diebold.com").build()))
                        .address(Address.builder()
                                .street("Rua Olavo Bilac")
                                .neighborhood("Jardim Amanda I")
                                .city("Hortolândia")
                                .addressNumber("841")
                                .complement("")
                                .zipCode("13188045")
                                .province("SP")
                                .build())
                        .build(),
                Person.builder()
                        .dateBirth(LocalDate.of(2017, 12, 23))
                        .name("Hugo Noah da Rosa")
                        .identityDocument("15507948844")
                        .contacts(Lists.newArrayList(Contact.builder().type(ContactType.EMAIL).value("hugo.rosa@arcante.com.br").build()))
                        .address(Address.builder()
                                .street("Rua Belisário Campanha")
                                .neighborhood("Casa Verde Média")
                                .city("São Paulo")
                                .addressNumber("999")
                                .complement("")
                                .zipCode("02521000")
                                .province("SP")
                                .build())
                        .build()
        ));
        log.info("----------------------- Data Load started ------------------------------------");
    }
}
