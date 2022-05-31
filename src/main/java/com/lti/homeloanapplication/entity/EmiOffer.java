package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emiOffers")
public class EmiOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    @NotNull(message = "Emi Offer description must be give")
    private String offerDescription;
    @Column
    @NotNull(message = "interestRate should  be provide")
    private Double interestRate;
    @Column
    @NotNull(message = "tenure should not be null")
    private Long tenure;
    @Column
    @NotNull(message = "emi type must be select Cost Type Or No Cost Type")
    private String emiType;

    @OneToOne(targetEntity = Product.class)
    private Product product;
}
