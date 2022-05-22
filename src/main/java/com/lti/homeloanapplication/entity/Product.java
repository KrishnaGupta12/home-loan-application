package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "PRODUCT_ID_GEN", sequenceName = "PRODUCT_ID_SEQ")
    private Long productId;

    @Column(name = "product_type")
    // @Size(min = 2, max = 20, message = "Product NAME can vary between 2 to 20 characters")
    //  @NotNull(message = "Product Name cannot be empty")
    //  @Pattern(regexp = "[A-Za-z]+", message = "Product NAME can only be alphabets")
    private String productType;
    @Transient
    private List<EmiOffer> emiOffers;
    @Column
    private String description;
    @Column
    private double productPrice;
    @Column
    private String emiType;
}



