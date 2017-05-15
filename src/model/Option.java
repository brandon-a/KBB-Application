package model;

import java.io.Serializable;

//Option class that contains one selection each
	class Option implements Serializable {
		private static final long serialVersionUID = 1L;
		Option() {}
		//instance variables
		private String optionName = "NULL";
		private Double cost = -1.0;
		//constructor
		Option(String name, Double price) {optionName = name; cost = price;}
		//getters
		protected String getSelection() {return optionName;}
		protected Double getCost() {return cost;}
		//setters
		protected void setSelection(String name) {optionName = name;}
		protected void setCost(Double cost) {this.cost = cost;}
		//converts the object to a string
		public String toString() {
			StringBuilder temp = new StringBuilder(optionName);
			temp.append(", ");
			temp.append(cost);
			temp.append(", ");
			return temp.toString();
		}
	}

