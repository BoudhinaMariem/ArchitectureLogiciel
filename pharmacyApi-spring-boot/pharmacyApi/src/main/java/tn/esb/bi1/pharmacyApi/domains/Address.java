package tn.esb.bi1.pharmacyApi.domains;

import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity

public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private int number;
    @NonNull
    private String street;
    @NonNull
    private String city;
    @NonNull
    private int postalCode;

    @OneToOne
    private Laboratory lab;   //pour un seul laboratoire

}
