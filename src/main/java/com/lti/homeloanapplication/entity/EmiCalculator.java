package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiCalculator {
private Double loanAmount;
private Double tenure;

}
