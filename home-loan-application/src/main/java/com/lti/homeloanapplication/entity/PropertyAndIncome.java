package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "property_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyAndIncome implements Serializable {

    @Id
    @Column(name = "pi_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PI_GEN")
    @SequenceGenerator(name = "PI_GEN", sequenceName = "pi_id_seq")
    private Integer piId;

    @Column(name = "property_loc")
    @NotNull(message = "Property Location is Mandatory")
    @Pattern(regexp = "^(\\w+ ?)*$", message = " Location  should be only characters")
    private String propertyLoc;

    @Column(name = "property_name")
    @NotNull(message = "Property Name is Mandatory")
    @Pattern(regexp = "^(\\w+ ?)*$", message = " Property Name  should be only characters")
    private String propertyName;

    @Column(name = "estimated_amt")
    @NotNull(message = "Estimated Amount is Mandatory!!")
    private Long propertyEstimatedAmount;

    @Column(name = "type_of_emp")
    @NotNull(message = "Type of Employment is Mandatory")
    private String typeOfEmployment;

    @Column(name = "ret_age")
    @NotNull(message = "Retirement age is Mandatory")
    @Min(60) @Max(70)
    private Integer retirementAge;

    @Column(name = "org_type")
    @NotNull(message = "Organization Type is Mandatory")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Organization Type  should be only characters")
    private String orgType;

    @Column(name = "employer_name")
    @NotNull(message = "Employer Name is Mandatory!!")
    @Pattern(regexp = "^(\\w+ ?)*$", message = "Employer Name should be only characters")
    private String employerName;

    @Column(name = "income")
    @NotNull(message = "Income is Mandatory")
    private Long income;

    @OneToOne(targetEntity = Customer.class)
    private Customer customer;


}
