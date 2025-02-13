package com.challenge.builder;

import com.challenge.domain.domains.ProductDTO;

public class BuilderProduct {

	public static ProductDTO build() {

		ProductDTO product = new ProductDTO(null, null,null,false, null);
		
		return product;

	}


}
