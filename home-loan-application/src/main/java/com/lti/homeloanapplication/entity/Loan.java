package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="loan_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan implements Serializable {
    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
    @SequenceGenerator(name = "loan_gen", sequenceName = "loan_id_seq")
    private Long loanId;

    @NotNull(message = "Maximum Loan Grant is mandatory.! ")
    @Column(name = "max_loan_grant")
    private Double maxLoanGrant;

    @Column(name = "interest_rate ")
    private Double intrestRate = 7.5;

    @NotNull(message = "Tenure is mandatory.! ")
    @Min(3) @Max(72)
    @Column(name = "tenure")
    private Integer tenure;

    @NotNull(message = "Loan Amount is mandatory.! ")
    @Column(name = "loan_amount")
    private Long loanAmount;
    @OneToOne(targetEntity = Customer.class)
    private Customer customer;

}
