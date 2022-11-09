package com.jojo.Kodlama.io.Devs.controllers;

import com.jojo.Kodlama.io.Devs.business.abstracts.TechnologyService;
import com.jojo.Kodlama.io.Devs.entities.Technology;
import com.jojo.Kodlama.io.Devs.requests.TechnologyCreateRequest;
import com.jojo.Kodlama.io.Devs.responses.TechnologyListResponse;
import com.jojo.Kodlama.io.Devs.responses.TechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getAll")
    public List<TechnologyListResponse> getAll() throws Exception{
        return technologyService.getAll();
    }

    @GetMapping("/{id}")
    TechnologyResponse getById(@PathVariable int id) throws Exception {
        return this.technologyService.getById(id);
    }

    @PostMapping("/add")
    public Technology add(@RequestBody TechnologyCreateRequest request) throws Exception{
        return this.technologyService.add(request);
    }

    @PutMapping("/{id}")
    public TechnologyResponse update(@PathVariable("id") Integer id,
                                     @RequestBody TechnologyCreateRequest request) throws Exception{
        return this.technologyService.updateTechnologyById(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws Exception{
        return this.technologyService.deleteTechnologyById(id);
    }
}
