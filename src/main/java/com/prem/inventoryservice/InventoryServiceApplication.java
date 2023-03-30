package com.prem.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@OpenAPIDefinition(info = @Info(title = "Inventory Service API", version = "1.0", description = "Inventory Information"))
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	/*
	 * @Bean public CommandLineRunner loadData(InventoryRepository
	 * inventoryRepository) { return args -> { Inventory inventory = new
	 * Inventory(); inventory.setSkuCode("Samsung_galaxy");
	 * inventory.setQuantity(100);
	 * 
	 * Inventory inventory1 = new Inventory();
	 * inventory1.setSkuCode("iphone_13_red"); inventory1.setQuantity(0);
	 * 
	 * inventoryRepository.save(inventory); inventoryRepository.save(inventory1); };
	 * }
	 */
}
