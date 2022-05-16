package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EligibilityCalculator {

		private Double monthlyIncome;
		private Double rOI;


/*		private Boolean eligiblity;
		private Double maxLoan;*/
		/*
		public Boolean getEligiblity() {
			return eligiblity;
		}
		public void setEligiblity(Boolean eligiblity) {
			this.eligiblity = eligiblity;
		}
		public Double getMaxLoan() {
			return maxLoan;
		}
		public void setMaxLoan(Double maxLoan) {
			this.maxLoan = maxLoan;
		}*/
		
}
