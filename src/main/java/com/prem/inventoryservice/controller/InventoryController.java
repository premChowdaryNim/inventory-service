package com.prem.inventoryservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prem.inventoryservice.dto.InventoryRequest;
import com.prem.inventoryservice.dto.InventoryResponse;
import com.prem.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

	/*
	 * @GetMapping("/{sku-code}")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public boolean
	 * isInStock(@PathVariable("sku-code") String skuCode) { return
	 * inventoryService.isInStock(skuCode); }
	 */
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse>  isInStock(@RequestParam List<String> skuCode) {
    	log.info("Entered Inventory Service");
        return inventoryService.isInStock(skuCode);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody InventoryRequest inventoryRequest) {
    	log.info("Entered Inventory Service");
    	inventoryService.inventoryStock(inventoryRequest);
    	log.info("Exited Inventory Service");
        return "Inventory Updated Successfully";
    }
}
