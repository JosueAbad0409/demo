package com.example.demo.repository;

import com.example.demo.model.Bodeguero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBodeguero  extends JpaRepository<Bodeguero, Long> {
}
