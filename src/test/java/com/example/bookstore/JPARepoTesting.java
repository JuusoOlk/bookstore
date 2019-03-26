package com.example.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.UserRepository;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JPARepoTesting {
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;
	@Autowired
	private UserRepository urepository;
	@Test
    public void createNewBookAndCategory(){
        Category historia = new Category("Test");
        crepository.save(historia);
    
        Book book = new Book("Testaaja", "testaajan hissa", "QE123456", 1909, 12.45, historia);
        brepository.save(book);

        assertThat(book.getId()).isNotNull();
        assertThat(book.getTitle()).isEqualTo("Test");
    }
    
    @Test
    public void deleteANDFindBook(){
        Category historia = new Category("Test");
        crepository.save(historia);

        Book book = new Book("Testaaja", "testaajan hissa", "QE123456", 1909, 12.45, historia);
        brepository.save(book);
        List<Book> books = brepository.findByid((long) 0);
        brepository.delete(books.get(0));

        List<Book> Book = brepository.findByid((long) 1);

        assertThat(book.getId()).isNotNull();

    }
}
