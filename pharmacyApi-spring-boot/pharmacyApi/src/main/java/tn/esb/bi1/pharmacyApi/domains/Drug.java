package tn.esb.bi1.pharmacyApi.domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter //genere tous les getters pour tous les attribus , au moment du rutime
@Setter
@NoArgsConstructor //genere un constructeur non paramétré
// @AllArgsConstructor //genere un constructeur avec tous les parametres
//@ToString //redéfinit la methode toString en retounant les valeurs de tous les attribus
//@ToString(exclude = {"stock","image"}) //retoune les valeurs de tous les attribus sauf celles de stock et image

@ToString(exclude = "image") //retourne tous sauf l'image
//@EqualsAndHashCode //permet de redefinit les deux methodes 'equals' et 'HashCode' en se basant sur tous les attribus pour comparer
//@EqualsAndHashCode(exclude = {"image","description","code"}) //compare par tous les attribus saut 'image' 'descriotion' et 'code'
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //utilise uniquement les attribus annotés avec @--include dans la comparaison
@Entity   //permet de mentionner à l'ORM : object Relational Mapping que la classe Drug sera transformer en une table relationnel
public class Drug {
    @Id  //l'attribut 'code' est la clé primaire de la table Drug
    @GeneratedValue(strategy = GenerationType.IDENTITY) //permet de générer automatiquement les valeurs
    // de la clé primaire
    private Long code;
    @EqualsAndHashCode.Include
    @Column(unique = true)   //name unique
    private String name;
    @Column(precision = 7, scale = 2)      //le precision=le prix est sur 7 chiffres y compris scale 2 apres la virgule
    private double price;
    @EqualsAndHashCode.Include
    private LocalDate fabricationDate;
    @EqualsAndHashCode.Include
    private LocalDate expirationDate;
    private String description;
    @Column(columnDefinition = "interger default 0",nullable = false)
    private int stock;
    @Lob    //image est un tableau of byte avec une longueur plus long avec Lob
    private byte[] image;
    @ManyToOne //on pas besoin de mappedBy
    @JoinColumn(name = "laboratory_id")
    private Laboratory drugLaboratory;

    //implementation de la relation n-n entre "drug" et "prescription"
    @OneToMany
    //definition de la table association (PrescriptionDrugs)
    @JoinTable(name = "prescription_drugs",
            //en SQL :
            //constraint fK1 foreign key drug_code references Drug(code)
            //dans ce cas l'attribut referencedColumnName est optionnel
            joinColumns = @JoinColumn(name = "drug_code",referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "prescription_id",referencedColumnName = "id")
    )
    @ToString.Exclude
    private Set<Prescription> prescription=new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return name.equals(drug.name) && fabricationDate.equals(drug.fabricationDate) && expirationDate.equals(drug.expirationDate);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
