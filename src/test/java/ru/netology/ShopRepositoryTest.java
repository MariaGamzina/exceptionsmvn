package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(11, "хлеб", 40);
    Product product2 = new Product(222, "булка", 30);
    Product product3 = new Product(3, "картошка", 20);

    Product product4 = new Product(3, "морковка", 15);

    @Test
    public void shouldNotFoundExceptionRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(111);
        });

    }

    @Test
    public void shouldRemoveById() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(222);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddProductNewId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();


    }

    @Test
    public void shouldAddAlreadyExistsException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product4);
        });
    }


}

