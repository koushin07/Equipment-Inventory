package com.miko.eprris.domain.equipment;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Equipment {

    @Id
    @SequenceGenerator(name = "equipment_sequence", sequenceName = "equipment_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "equipment_sequence")
    @Column(updatable = false)
    private Long id;
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String code;

    @NotEmpty
    @Column(nullable = false)
    private String asset_desc;

    @NotEmpty
    @Column(nullable = false)
    private String category;

    @NotNull
    @Column(nullable = false)
    private Integer unit;

    @NotNull
    @Column(nullable = false)
    private Integer model_number;

    @NotNull
    @Column(nullable = false)
    private Integer serial_number;

    @NotEmpty
    @Column(nullable = false)
    private String status;

    @NotNull
    @Column(nullable = false)
    private Integer asset_id;

    @NotEmpty
    @Column(nullable = false)
    private String remarks;

    @NotNull
    private Integer quantity;




}
