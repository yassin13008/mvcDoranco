package com.doranco.mvcdoranco.data;

import com.doranco.mvcdoranco.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthorDAO extends JpaRepository<Author, Long> {
    Optional<Author> findByEmail(String email);
}
