package br.com.rapguit.hazeldmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by raphael on 07/05/16.
 */
@SpringBootApplication
@ComponentScan("br.com.rapguit.hazeldmongo")
@EnableMongoRepositories("br.com.rapguit.hazeldmongo.repository")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
