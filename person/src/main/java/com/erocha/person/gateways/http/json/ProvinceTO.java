package com.erocha.person.gateways.http.json;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProvinceTO {

  private String acronym;
  private String name;
}
