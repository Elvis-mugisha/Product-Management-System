
package com.ecommerce.springboot.mongoRepository;

import com.ecommerce.springboot.model.ProductDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepositoryMongo extends MongoRepository<ProductDetail, Long> {
}
