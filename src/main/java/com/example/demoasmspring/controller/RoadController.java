package com.example.demoasmspring.controller;

import com.example.demoasmspring.dto.RoadDTO;
import com.example.demoasmspring.entity.Road;
import com.example.demoasmspring.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/seed/generate")
public class RoadController {

    @Autowired
    private RoadService roadService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<RoadDTO> getList(){
        return roadService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Road create(@RequestBody RoadDTO roadDTO){
        return roadService.create(roadDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Road getDetail(@PathVariable String id){
        return roadService.getDetail(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Road update(@PathVariable String id, @RequestBody Road road){
        return roadService.update(id, road);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id){
        return roadService.delete(id);
    }

}
