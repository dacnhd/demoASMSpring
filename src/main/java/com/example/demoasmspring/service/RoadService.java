package com.example.demoasmspring.service;

import com.example.demoasmspring.dto.RoadDTO;
import com.example.demoasmspring.entity.District;
import com.example.demoasmspring.entity.Road;
import com.example.demoasmspring.repository.DistrictRepository;
import com.example.demoasmspring.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoadService {

    @Autowired
    private RoadRepository roadRepository;

    @Autowired
    private DistrictRepository districtRepository;
    public Iterable<RoadDTO> getList(){
        List<RoadDTO> list= new ArrayList<>();
        List<Road> roadList = roadRepository.findAll();
        if (roadList.size() == 0){
            return null;
        }
        for (Road road: roadList) {
            RoadDTO roadDTO = new RoadDTO(road);
            list.add(roadDTO);
        }
        return list;
    }

    public Road create(RoadDTO roadDTO){
        Road road = new Road(roadDTO);
        District district = districtRepository.findByDistrictName(roadDTO.getDistrictName());
        if (district == null){
            return null;
        }
        road.setDistrict(district);
        roadRepository.save(road);
        return road;
    }

    public Road getDetail(String id){
        Road road = null;
        if (roadRepository.findById(id).isPresent()==false){
            return road;
        }
        road = roadRepository.findById(id).get();
        return road;
    }

    public Road update(String id, Road road){
        Road road1 = null;
        if (roadRepository.findById(id).isPresent()==false){
            return road1;
        }
        road1 = roadRepository.findById(id).get();
        road1.setName(road.getName());
        road1.setFounding(road.getFounding());
        road1.setDescription(road.getDescription());
        road1.setStatus(road.getStatus());
        roadRepository.save(road1);
        return road1;
    }

    public String delete(String id){
        Road road = null;
        if (roadRepository.findById(id).isPresent()==false){
            return "null";
        }
        road = roadRepository.findById(id).get();
        road.setStatus(-1);
        roadRepository.save(road);
        return id;
    }
}
