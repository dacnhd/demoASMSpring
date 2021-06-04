package com.example.demoasmspring.dto;

import com.example.demoasmspring.entity.District;
import com.example.demoasmspring.entity.Road;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoadDTO {

    private String roadId;
    private String name;
    private String founding;
    private String description;
    private String status;

    private String districtName;

    public RoadDTO(Road road){
        this.districtName = road.getDistrict().getDistrictName();
        this.roadId = road.getRoadId();
        this.founding = road.getFounding();
        this.description = road.getDescription();
        this.name = road.getName();
        this.status = road.getStatusString();
    }
}
