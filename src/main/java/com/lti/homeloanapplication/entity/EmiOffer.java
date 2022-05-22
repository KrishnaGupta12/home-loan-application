package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmiOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emiOfferId;
    @Column
    private String offerDescription;
    @Column
    private Double interestRate;
    @Column
    private Long tenure;
    @Column
    private String emiType;

}
