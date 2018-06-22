package com.tuncer.basaran.AngularExample.repositories;

import com.tuncer.basaran.AngularExample.domains.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by tuncer on 22/06/2018.
 */
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long> {
}
