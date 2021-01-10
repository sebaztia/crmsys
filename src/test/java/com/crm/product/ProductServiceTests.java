package com.crm.product;

import com.crm.model.Category;
import com.crm.model.Product;
import com.crm.repository.CategoryRepository;
import com.crm.repository.ProductRepository;
import com.crm.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void getProductById() {
        ProductService productService = new ProductService(productRepository, categoryRepository);
        Product product = new Product();
        product.setId(1);
        product.setName("Test");
        product.setPrice(100F);
        product.setQuantity(3);
        Category category = new Category();
        category.setCategoryName("TestCategory");
        product.setCategory(category);

        productRepository.save(product);

        when(productRepository.findOne(1)).thenReturn(product);

        Product product1 = productService.getProductById(1);
        assertThat(product1).isEqualTo(product);
    }
}
