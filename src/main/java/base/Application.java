package base;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        System.out.println();
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(final HazelcastInstance instance) {
        return hibernateProperties -> hibernateProperties.put("hibernate.cache.hazelcast.instance_name", instance.getName());
    }
}
