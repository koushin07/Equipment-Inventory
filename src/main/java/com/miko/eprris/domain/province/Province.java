package com.miko.eprris.domain.province;

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
public class Province {

    @Id
    @SequenceGenerator(name = "province_sequence", sequenceName = "province_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "province_sequence")
    @Column(updatable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotEmpty
    private String name;



}
