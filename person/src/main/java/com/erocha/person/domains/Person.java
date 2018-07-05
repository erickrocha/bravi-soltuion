package com.erocha.person.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE_BIRTH")
    private LocalDate dateBirth;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IDENTITY_DOCUMENT")
    private String identityDocument;

    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID")
    @Singular
    private List<Contact> contacts;

    public void addContact(Contact contact){
        if (this.contacts == null){
            this.contacts = new ArrayList<>();
        }
        this.contacts.add(contact);
    }

}
