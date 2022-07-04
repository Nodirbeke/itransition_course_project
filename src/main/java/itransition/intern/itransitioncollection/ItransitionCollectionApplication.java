package itransition.intern.itransitioncollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashMap;

@SpringBootApplication
@EnableJpaRepositories
public class ItransitionCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItransitionCollectionApplication.class, args);
    }

}
