package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringRestApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringRestApplication.class, args);
        ProductRepository repo = ctx.getBean(ProductRepository.class);
        
        System.out.println("LOADING PRODUCTS [+OK]");
        
        Product prod1 = 
        		new Product("Electronics", "PS4", 400, "www.playstation.com");
        repo.save(prod1);
        
        Product prod2 =
        		new Product("Books", "Game of Thrones", 15, "www.gotbooks.com");
        repo.save(prod2);
        
        Product prod3 = 
        		new Product("Electronics", "XBOX 360", 300, "www.xbox.com");
        repo.save(prod3);
        
        
        
        
        
        
        
    }
}
