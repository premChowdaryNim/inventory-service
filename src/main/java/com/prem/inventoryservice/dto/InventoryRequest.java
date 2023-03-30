package com.prem.inventoryservice.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequest {
	@Id
 	private String id;
    private String skuCode;
    private Integer quantity;
}
