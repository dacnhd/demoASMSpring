package com.example.demoasmspring.repository;

import com.example.demoasmspring.entity.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadRepository extends JpaRepository<Road, String> {
}
