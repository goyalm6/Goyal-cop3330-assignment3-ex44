package ex44;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ProductSearchTest {
    private ProductSearch productSearch;

    @BeforeEach
    void setUp() {
        productSearch = new ProductSearch();
    }

    @AfterEach
    void tearDown() {
        productSearch = null;
    }

    @Test
    void testInputFileAbsolutePath() {
        String inputFile = "example44_input.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("exercise44_input.txt").getFile());

        String absolutePath = file.getAbsolutePath();
        System.out.println("abs = " + absolutePath);
        assertTrue(file.exists());
        assertTrue(absolutePath.endsWith("exercise44_input.txt"));
    }

    @Test
    void testReadAsStream() {
        String inputFile = "/exercise44_input.txt";
        InputStream stream = this.getClass().getResourceAsStream(inputFile);
        assertNotNull(stream);
    }

    @Test
    void testProductSearch()
    {
        productSearch.inputFile = "src/main/resources/exercise44_input.txt";
        productSearch.productName = "thing";
        var res = productSearch.search();
        var product = res.keySet().iterator().next();
        assertNotNull(product);
    }

    @Test
    void testProductNotFound()
    {
        productSearch.inputFile = "src/main/resources/exercise44_input.txt";
        productSearch.productName = "test";
        var res = productSearch.search();
        var product = res.keySet().iterator().next();
        var isProductFound = res.get(product);
        assertEquals(isProductFound, 0);
    }
}
