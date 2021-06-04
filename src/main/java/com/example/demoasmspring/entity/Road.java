package com.example.demoasmspring.entity;

import com.example.demoasmspring.dto.RoadDTO;
import com.example.demoasmspring.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Road {
    @Id
    private String roadId;
    private String name;
    private String founding;
    private String description;
    private int status; // 1: dang su sung, 0: dang thi cong, -1: dang tu sua

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "districtId")
    private District district;

    public Road(RoadDTO roadDTO) {
        this.roadId = roadDTO.getRoadId();
        this.name = roadDTO.getName();
        this.founding = roadDTO.getFounding();
        this.description = roadDTO.getDescription();
        this.status = 1;
    }

    public String getStatusString() {
        return this.getStatus() == 1 ? "Dang su dung" : (this.getStatus() == 0 ? "Dang thi cong" : "Dang tu sua");
    }
}
