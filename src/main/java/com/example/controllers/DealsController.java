package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Deal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/deals")
@Api("/api/deals")
@CrossOrigin("*")
public class DealsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DealsController.class);	

	@GetMapping("/public")
	@ApiOperation(value = "Return a list of deals.", response = Deal[].class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = Deal[].class) })
	public List<Deal> getDealsPublic() {
		LOGGER.info("getDealsPublic");
		
		List<Deal> deals = new ArrayList<Deal>();
		Deal deal = new Deal();
		deal.setId(1234);
		deal.setName("Galaxy Note 7");
		deal.setDescription("The Note 7 has been fixed and will no longer explode. Get it an amazing price!");
		deal.setOriginalPrice(899.99);
		deal.setSalePrice(499.99);
		deals.add(deal);

		deal = new Deal();
		deal.setId(2016);
		deal.setName("Macbook Pro 2016");
		deal.setDescription("The Mac Book Pro is the de-facto standard for best in breed mobile computing.");
		deal.setOriginalPrice(2199.99);
		deal.setSalePrice(1999.99);
		deals.add(deal);
		
		deal = new Deal();
		deal.setId(4444);
		deal.setName("GoPro 4");
		deal.setDescription("Record yourself in first person 24/7 with the GoPro 4. Show everyone how exciting your life is.");
		deal.setOriginalPrice(299.99);
		deal.setSalePrice(199.99);
		deals.add(deal);
		
		
		return deals;
	}
	
	@GetMapping("/private")
	@PreAuthorize("hasAuthority('read:deals')")
	@ApiOperation(value = "Return a list of special deals.", notes = "It is an protected operation", response = Deal[].class)
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Success", response = Deal[].class),
		@ApiResponse(code = 401, message = "Unauthorized"),
		@ApiResponse(code = 403, message = "Forbidden")})
	public List<Deal> getDealsPrivate() {
		LOGGER.info("getDealsPrivate");
		
		Deal deal = new Deal();
		deal.setId(5678);
		deal.setName("Amazon Echo");
		deal.setDescription("Turn your home into smart home with Amazon Echo. Just say the word and Echo will do it.");
		deal.setOriginalPrice(179.99);
		deal.setSalePrice(129.99);
		
		List<Deal> deals = new ArrayList<Deal>();
		deals.add(deal);
		
		return deals;
	}

}