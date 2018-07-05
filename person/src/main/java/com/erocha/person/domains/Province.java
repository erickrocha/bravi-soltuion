package com.erocha.person.domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PROVINCE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Province implements Serializable {

    @Id
    @Column(name = "ACRONYM", precision = 2, nullable = false)
    private String acronym;

    @Column(name = "NAME", nullable = false)
    private String name;


}
