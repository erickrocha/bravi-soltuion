package com.erocha.person.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

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

    @Column(name = "EMAIL")
    private String email;

    @Embedded
    private Address address;

}
