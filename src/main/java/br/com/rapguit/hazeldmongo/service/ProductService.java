package br.com.rapguit.hazeldmongo.service;

import br.com.rapguit.hazeldmongo.model.Product;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by raphael on 07/05/16.
 */
@Service
public class ProductService {

    IMap<String, Product> productCache;
    AtomicLong idGen = new AtomicLong(1);

    @Autowired
    public ProductService(HazelcastInstance hazelcast) {
        productCache = hazelcast.getMap("collection");
    }

    public String save(Product p){
        String id = nextId();
        productCache.set(id, p);

        return id;
    }

    public List<Product> getAll(){
        return new ArrayList<>(productCache.values());
    }

    public Product getById(String id){
        return productCache.get(id);
    }

    private String nextId() {
        return String.valueOf(idGen.getAndIncrement());
    }

}
