import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(7, "Планшет", 49_999);
        Product product2 = new Product(31, "Хлеб", 80);
        Product product3 = new Product(121, "Автомобиль", 4_500_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(31);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(7, "Планшет", 49_999);
        Product product2 = new Product(31, "Хлеб", 80);
        Product product3 = new Product(121, "Автомобиль", 4_500_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(467)
        );
    }
}