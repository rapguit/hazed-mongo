package br.com.rapguit.hazeldmongo.config;

import br.com.rapguit.hazeldmongo.repository.mapstore.MongoMapStore;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by raphael on 07/05/16.
 */
@Configuration
public class BeansConfig {

    @Bean
    @DependsOn("mongoMapStore")
    @Autowired
    public HazelcastInstance hazelcast(MongoMapStore mongoMapStore){
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setEnabled(true);
        mapStoreConfig.setImplementation(mongoMapStore);
        mapStoreConfig.setWriteDelaySeconds(0);

        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("collection");
        mapConfig.setMapStoreConfig(mapStoreConfig);

        Config cfg = new Config();
        cfg.addMapConfig(mapConfig);

        return Hazelcast.newHazelcastInstance(cfg);
    }
}
