package com.miko.eprris.domain.municipality;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Municipality {


    @Id
    @SequenceGenerator(name = "municipality_sequence", sequenceName = "municipality_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "municipality_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

}
