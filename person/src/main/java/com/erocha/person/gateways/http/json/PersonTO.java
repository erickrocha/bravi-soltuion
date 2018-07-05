package com.erocha.person.gateways.http.json;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private AddressTO address;
    private List<ContactTO> contacts;

}
