package com.erocha.person.domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {


    @Column(name = "STREET")
    private String street;

    @Column(name = "ADDRESS_NUMBER")
    private String addressNumber;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Column(name = "NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "CITY")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "ZIPCODE")
    private String zipCode;
}
