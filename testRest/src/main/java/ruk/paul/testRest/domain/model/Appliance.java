package ruk.paul.testRest.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by paul on 30.05.18.
 */
@Entity
@Table(name = "appliance")
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "itemid", nullable = false, unique = true)
    private String item;

    @Getter
    @Setter
    @Column(name = "type", nullable = false)
    private String type;

    @Getter
    @Setter
    @Column(name = "state", nullable = false)
    private String state;
}
