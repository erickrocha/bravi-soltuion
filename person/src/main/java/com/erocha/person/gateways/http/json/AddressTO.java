package com.erocha.person.gateways.http.json;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressTO {

  private String city;

  private String neighborhood;

  private String street;

  private String zipCode;

  private String addressNumber;

  private String complement;

  private String province;

}
