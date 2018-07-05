package com.erocha.person.gateways.http.json;


import com.erocha.person.domains.ContactType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactTO {

    private Integer id;
    private ContactType type;
    private String value;
}
