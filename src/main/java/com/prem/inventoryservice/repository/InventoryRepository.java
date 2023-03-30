package com.prem.inventoryservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prem.inventoryservice.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

	//Optional<Inventory> findBySkuCode(String skuCode);
	
	List<Inventory> findAllBySkuCodeIn(List<String> skuCode);

}
