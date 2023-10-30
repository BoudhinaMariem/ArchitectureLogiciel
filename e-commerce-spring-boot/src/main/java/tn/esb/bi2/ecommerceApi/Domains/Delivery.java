package tn.esb.bi2.ecommerceApi.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import tn.esb.bi2.ecommerceApi.Enumerations.DeliveryState;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NonNull
    private LocalDate date;
    @NonNull
    private BigDecimal amount;
    @Column(columnDefinition = "varchar(10) default 'delivered'")
    @Enumerated(EnumType.STRING)
    private DeliveryState state;
    @Column(name="delivered_quantity")
    private int quantity;

    @ManyToOne
    //specifier la clé étrangère composite
    @JoinColumns(
            {
                    @JoinColumn(name = "product_id", referencedColumnName = "product_id"),
                    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
            }
    )
    private Command command;
}
