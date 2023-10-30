package tn.esb.bi2.ecommerceApi.Domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class Command {
    @EmbeddedId //clé primaire composite
    private CommandId id;
    @Column(columnDefinition = "int default 1")
    private Integer quantity;
    @NonNull
    @Column(name = "command_date")
    private LocalDate date;


    //@NonNull
    @ManyToOne
    @MapsId("idCustomer")
    private Customer customer;

    //@NonNull
    @ManyToOne
    @MapsId("idProduct")//cette instance de product est lié à une partie
    // de la clé primaire composite (idProduct)
    private Product product;

    @OneToMany(mappedBy = "command",cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Delivery> commandDeliveries=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return date.equals(command.date) && product.equals(command.product) && customer.equals(command.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, product, customer);
    }
}
