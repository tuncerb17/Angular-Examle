package com.tuncer.basaran.AngularExample;

import com.tuncer.basaran.AngularExample.domains.Book;
import com.tuncer.basaran.AngularExample.repositories.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.core.Ordered;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableResourceServer
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

	@Bean
	@SuppressWarnings("unchecked")
	public FilterRegistrationBean simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
