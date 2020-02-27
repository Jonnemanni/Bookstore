package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner insertData(BookRepository BRepository, CategoryRepository CRepository) {
		return (args) -> {
			log.info("Save a couple categories");
			
			CRepository.save(new Category("Sci-Fi"));
			CRepository.save(new Category("TTRPG"));
			CRepository.save(new Category("Comic"));
			CRepository.save(new Category("Educational"));
			
			log.info("Save a couple books");
			BRepository.save(new Book("ABC-Basics", "Luku Matonen", "1999", "1234567-89", "19.99", CRepository.findByName("Educational").get(0)));
			BRepository.save(new Book("123-Basics", "Katti Matikkainen", "1999", "1234567-90", "19.99", CRepository.findByName("Educational").get(0)));
			
		};
	}
}
