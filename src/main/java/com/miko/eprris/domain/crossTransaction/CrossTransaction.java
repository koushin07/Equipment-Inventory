package com.miko.eprris.domain.crossTransaction;

import com.miko.eprris.domain.equipment.Equipment;
import com.miko.eprris.domain.municipality.Municipality;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import static java.lang.Boolean.FALSE;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CrossTransaction implements Serializable {

    @Id
    @SequenceGenerator(name = "crossTransaction_sequence", sequenceName = "crossTransaction_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "crossTransaction_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;
    private Integer quantity;
    private boolean self_province_confirmation = FALSE;
    private boolean owner_province_confirmation = FALSE;
    private boolean owner_confirmation = FALSE;



}
