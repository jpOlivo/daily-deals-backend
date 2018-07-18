package com.example.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Representation of a Deal.")
public class Deal {
	@ApiModelProperty(position = 1, value = "The id of Deal.")
	private Integer id;
	
	@ApiModelProperty(position = 2, value = "The name of Deal.")
	private String name;
	
	@ApiModelProperty(position = 3, value = "The description of Deal.")
	private String description;
	
	@ApiModelProperty(position = 4, value = "The original price.")
	private Double originalPrice;
	
	@ApiModelProperty(position = 5, value = "The sale price.", notes = "It have the discount applied")
	private Double salePrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
}
