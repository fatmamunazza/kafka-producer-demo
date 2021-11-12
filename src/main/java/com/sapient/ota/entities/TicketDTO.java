package com.sapient.ota.entities;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sapient.ota.constants.TicketConstants;

public class TicketDTO {
	
	@NotEmpty(message = "Tour Name " + TicketConstants.EMPTY_FIELD)
	private String tourName;
	
	@NotEmpty(message = "Description " + TicketConstants.EMPTY_FIELD)
	private String description;
	
	@NotEmpty(message = "Price " + TicketConstants.EMPTY_FIELD)
	@Min(value = 1, message = TicketConstants.PRICE_VALIDATION)
	private Double price;
	
	@NotEmpty(message = "Tour Date " + TicketConstants.EMPTY_FIELD)
	private String tourDate;
	
	
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public @NotEmpty(message = "Tour Date is required!") String getTourDate() {
		return tourDate;
	}
	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}

}
