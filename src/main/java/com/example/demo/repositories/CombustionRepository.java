package com.example.demo.repositories;

import com.example.demo.entity.Combustion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombustionRepository extends JpaRepository<Combustion, Long> {
}
