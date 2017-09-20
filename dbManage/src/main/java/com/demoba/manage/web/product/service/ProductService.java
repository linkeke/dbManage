package com.demoba.manage.web.product.service;

import java.util.List;

import com.demoba.manage.web.product.model.ProductModel;
import com.owl.common.util.Result;

public interface ProductService {
	 
	   public Result saveProduct(ProductModel productModel);
	   public Result productList(Integer page, Integer pageSize);
	 
	 
}
