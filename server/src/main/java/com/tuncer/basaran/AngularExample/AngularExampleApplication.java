package com.tuncer.basaran.AngularExample;

import com.tuncer.basaran.AngularExample.domains.Book;
import com.tuncer.basaran.AngularExample.repositories.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AngularExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularExampleApplication.class, args);
	}

	@Bean
	ApplicationRunner init(BookRepository repository) {
		return args -> {
			Stream.of("Book 1", "Book 2", "Book 3", "Book 4", "Book 5",
					"Book 6", "Book 7", "Book 8", "Book 9").forEach(name -> {
				Book book = new Book();
				book.setName(name);
				repository.save(book);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
