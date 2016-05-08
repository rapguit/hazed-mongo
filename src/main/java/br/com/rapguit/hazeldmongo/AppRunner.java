package br.com.rapguit.hazeldmongo;

import br.com.rapguit.hazeldmongo.model.Product;
import br.com.rapguit.hazeldmongo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by raphael on 07/05/16.
 */
@Component
public class AppRunner implements CommandLineRunner{

    private static Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired private ProductService productService;

    @Override
    public void run(String... strings) throws Exception {

        Product p1 = new Product();
        p1.setName("phone");
        p1.setPrice(150.0);

        Product p2 = new Product();
        p2.setName("laptop");
        p2.setPrice(1150.0);

        String pid1 = productService.save(p1);
        String pid2 = productService.save(p2);

        logger.info(">>> products saved!");
        logger.info(">>> p1: "+ pid1);
        logger.info(">>> p2: "+ pid2);

        List<Product> all = productService.getAll();

        logger.info(">>> cached size: "+ all.size());
        logger.info(">>> cached: "+ all);

        Product loaded1 = productService.getById(pid1);
        Product loaded2 = productService.getById(pid2);

        logger.info(">>> products loaded!");
        logger.info(">>> p1: "+ loaded1);
        logger.info(">>> p2: "+ loaded2);


    }
}
