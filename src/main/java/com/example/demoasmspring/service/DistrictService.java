package com.example.demoasmspring.service;

import com.example.demoasmspring.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;
}
