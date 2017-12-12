package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface RepositoryWrapper<T,ID extends Serializable> extends JpaRepository<T,ID > {
    Optional<T> findOneById(ID id);
}
