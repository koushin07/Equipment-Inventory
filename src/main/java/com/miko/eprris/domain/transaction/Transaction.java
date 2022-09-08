package com.miko.eprris.domain.transaction;

import com.miko.eprris.domain.equipment.Equipment;
import com.miko.eprris.domain.municipality.Municipality;
import lombok.*;

import javax.persistence.*;

import static java.lang.Boolean.FALSE;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {

    @Id
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "transaction_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "transaction_sequence")
    @Column(updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

    @Column(nullable = false)
    private boolean confirm = FALSE;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private boolean returned = FALSE;


}
