package edu.csumb.Webstore.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.Webstore.model.Product;

@Component
public class ProductSeeder implements CommandLineRunner{
    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception{
        Product granite = new Product("Granite", "Soft greyish rock", "https://mineralseducationcoalition.org/wp-content/uploads/Granite1_gray_123728602.jpg", 25.50, 100);
        Product marble = new Product("Marble", "Pretty rock", "https://www.pitt.edu/~cejones/GeoImages/6MetamorphicRocks/Marble/MarbleGrayBanded.jpg", 10.12, 3280);
        Product DJ = new Product("Dwayne The Rock Johnson", "Cool guy", "https://vignette.wikia.nocookie.net/prowrestling/images/a/ad/Wwe_the_rock_png_by_double_a1698_day9ylt-pre_%281%29.png/revision/latest?cb=20190225014047", 33000, 1);

        productRepository.deleteAll();
        List<Product> products = Arrays.asList(granite, marble, DJ);
        productRepository.saveAll(products);
    }
}