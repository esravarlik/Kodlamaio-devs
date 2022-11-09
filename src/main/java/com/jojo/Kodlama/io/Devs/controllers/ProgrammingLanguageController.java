package com.jojo.Kodlama.io.Devs.controllers;

import com.jojo.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.jojo.Kodlama.io.Devs.entities.ProgrammingLanguage;
import com.jojo.Kodlama.io.Devs.requests.ProgrammingLanguageCreateRequest;
import com.jojo.Kodlama.io.Devs.responses.ProgrammingLanguageListResponse;
import com.jojo.Kodlama.io.Devs.responses.ProgrammingLanguageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguageController {

    private final ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getAll")
    public List<ProgrammingLanguageListResponse> getAll() throws Exception{
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguageResponse getById(@PathVariable("id") int id)throws Exception{
        return programmingLanguageService.getById(id);
    }

    @PostMapping("/add")
    public ProgrammingLanguage add(@RequestBody ProgrammingLanguageCreateRequest request)
                                throws Exception{
        return this.programmingLanguageService.add(request);
    }

    @PutMapping("/{id}")
    public ProgrammingLanguageResponse update(@PathVariable("id") int id,
                                      @RequestBody ProgrammingLanguageCreateRequest request) throws Exception{
        return this.programmingLanguageService.updateProgrammingLanguageById(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws Exception{
        return this.programmingLanguageService.deleteProgrammingLanguageById(id);
    }

}
