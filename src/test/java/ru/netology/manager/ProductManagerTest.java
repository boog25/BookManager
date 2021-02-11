package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book item1 = new Book(1, "Война и Мир", 1000, "Толстой");
    private Book item2 = new Book(2, "Идиот", 1200, "Достоевский");
    private Book item3 = new Book(3, "Капитанская дочка", 707, "Пушкин");
    private Smartphone item4 = new Smartphone(4, "Samsung", 12500, "Корея");
    private Smartphone item5 = new Smartphone(5, "Huawei", 15000, "Китай");
    private Smartphone item6 = new Smartphone(6, "Apple", 55000, "США");
    private Smartphone item7 = new Smartphone(7, "Apple", 65000, "США");


    @BeforeEach
    public void setUp() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
    }

    @Test
    void shouldNotSearchBy() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy() {
        Product[] expected = new Product[]{item6};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    void addSmartphone() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{item6, item7};
        assertArrayEquals(expected, actual);
    }

}