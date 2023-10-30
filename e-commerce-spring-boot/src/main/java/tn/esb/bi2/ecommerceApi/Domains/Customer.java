package tn.esb.bi2.ecommerceApi.Domains;

import lombok.*;
import tn.esb.bi2.ecommerceApi.Enumerations.CustomerType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    @Column(name="customer_type", length = 20, columnDefinition = "varchar(20) default 'NORMAL'")
    @Enumerated(EnumType.STRING)
    //cette annotation sert à informer l'ORM du type de l'enumeration lors de la transformation du code en SQL
    private CustomerType type;

    @OneToOne (mappedBy = "customer",cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_address",referencedColumnName="id")
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Command> commands = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, type, address);
    }
}
