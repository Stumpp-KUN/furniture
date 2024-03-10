package com.example.furniture.demo.repository;

import com.example.furniture.demo.entity.Hole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoleRepository extends JpaRepository<Hole, Long> {
}
