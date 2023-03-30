package com.prem.inventoryservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prem.inventoryservice.dto.InventoryRequest;
import com.prem.inventoryservice.dto.InventoryResponse;
import com.prem.inventoryservice.model.Inventory;
import com.prem.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	public List<InventoryResponse> isInStock(List<String> skuCode) {
	        log.info("Checking Inventory");
	        return inventoryRepository.findAllBySkuCodeIn(skuCode).stream()
	                .map(inventory ->
	                        InventoryResponse.builder()
	                                .skuCode(inventory.getSkuCode())
	                                .isInStock(inventory.getQuantity() > 0)
	                                .build()
	                ).toList();
	}

	public void inventoryStock(InventoryRequest inventoryRequest) {
		       Inventory in = new Inventory();
		       in.setQuantity(inventoryRequest.getQuantity());
		       in.setSkuCode(inventoryRequest.getSkuCode());
		inventoryRepository.save(in);
		log.info("Stock saved in db");
		
	}

}
