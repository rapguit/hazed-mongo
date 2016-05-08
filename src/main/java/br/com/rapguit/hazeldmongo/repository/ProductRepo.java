package br.com.rapguit.hazeldmongo.repository;

import br.com.rapguit.hazeldmongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by raphael on 07/05/16.
 */
public interface ProductRepo extends MongoRepository<Product, String> {
}
