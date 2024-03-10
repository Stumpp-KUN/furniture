package com.example.furniture.demo.repository;

import com.example.furniture.demo.entity.FurnitureDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureDetailRepository extends JpaRepository<FurnitureDetail, Long> {
}
