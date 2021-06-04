package com.example.demoasmspring.repository;

import com.example.demoasmspring.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
    District findByDistrictName(String name);
}
