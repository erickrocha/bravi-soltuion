package com.erocha.person.gateways.http.json;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonTO {

    private Integer id;
    private String name;
    private LocalDate dateBirth;
    private String identityDocument;
    private String email;
    private AddressTO address;

}
