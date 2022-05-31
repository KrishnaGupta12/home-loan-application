package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "product_type")
    @Size(min = 2, max = 20, message = "Product NAME can vary between 2 to 20 characters")
    @NotNull(message = "Product Name cannot be empty")
    @Pattern(regexp = "[A-Za-z]+", message = "Product NAME can only be alphabets")
    private String productType;
   /* @Transient
    private List<EmiOffer> emiOffers;*/
    @Column
    private String description;
    @Column
    @NotNull(message = "Product Price should not be null")
    private double productPrice;
    @Column
    @NotNull(message = "Emi Type Must be Select ")
    private String emiType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emiOfferId", referencedColumnName = "product_id")
    private EmiOffer emiOffer;
}



