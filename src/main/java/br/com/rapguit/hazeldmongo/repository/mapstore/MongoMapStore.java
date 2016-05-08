package br.com.rapguit.hazeldmongo.repository.mapstore;

import br.com.rapguit.hazeldmongo.model.Product;
import br.com.rapguit.hazeldmongo.repository.ProductRepo;
import com.hazelcast.core.MapStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

/**
 * Created by raphael on 07/05/16.
 */
@Component
public class MongoMapStore implements MapStore<String, Product> {

    @Autowired private ProductRepo productRepo;

    @Override
    public void store(String id, Product product) {
        productRepo.save(product);
    }

    @Override
    public void storeAll(Map<String, Product> map) {
        productRepo.save(map.values());
    }

    @Override
    public void delete(String id) {
        productRepo.delete(id);
    }

    @Override
    public void deleteAll(Collection<String> collection) {
        collection.forEach(id -> productRepo.delete(id));
    }

    @Override
    public Product load(String id) {
        return productRepo.findOne(id);
    }

    @Override
    // override this method after implementing findAllByIds in your custom repository implementation
    public Map<String, Product> loadAll(Collection<String> collection) {
        return null;
    }

    @Override
    // override this method after implementing findAllIds in your custom repository implementation
    public Iterable<String> loadAllKeys() {
        return null;
    }
}
