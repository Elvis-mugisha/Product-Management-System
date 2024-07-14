
package com.ecommerce.springboot.mongoRepository;

import com.ecommerce.springboot.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryMongo extends MongoRepository<Product, Long> {
}
