package com.jojo.Kodlama.io.Devs.business.concretes;

import com.jojo.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.jojo.Kodlama.io.Devs.business.abstracts.TechnologyService;
import com.jojo.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.jojo.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import com.jojo.Kodlama.io.Devs.entities.Technology;
import com.jojo.Kodlama.io.Devs.requests.TechnologyCreateRequest;
import com.jojo.Kodlama.io.Devs.responses.TechnologyListResponse;
import com.jojo.Kodlama.io.Devs.responses.TechnologyResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TechnologyManager implements TechnologyService {

    private final TechnologyRepository technologyRepository;
    @Lazy private final ProgrammingLanguageService programmingLanguageService;

    public TechnologyManager(TechnologyRepository technologyRepository,
                             @Lazy ProgrammingLanguageService programmingLanguageService) {
        this.technologyRepository = technologyRepository;
        this.programmingLanguageService = programmingLanguageService;
    }

    @Override
    public List<TechnologyListResponse> getAll() {
        if(this.technologyRepository.findAll().size() > 0){
            List<Technology> technologies = technologyRepository.findAll();
            List<TechnologyListResponse> technologyListResponses = new ArrayList<>();

            for(Technology technology : technologies){
                TechnologyListResponse toSaveTechnology = new TechnologyListResponse();
                toSaveTechnology.setId(technology.getId());
                toSaveTechnology.setTechnologyName(technology.getTechnologyName());
                technologyListResponses.add(toSaveTechnology);
            }
            return technologyListResponses;
        }
        return null;
    }

    @Override
    public TechnologyResponse getById(int id) throws Exception{
        Optional<Technology> technology = this.technologyRepository.findById(id);
        if(technology.isPresent()){
            TechnologyResponse technologyResponse = new TechnologyResponse();
            technologyResponse.setTechnologyName(technology.get().getTechnologyName());
            return technologyResponse;
        }
        return null;
    }

    @Override
    public Technology add(TechnologyCreateRequest request) throws Exception{
        Technology technology = new Technology();
        technology.setId((int) Math.random());
        technology.setTechnologyName(request.getTechnologyName());
        return technologyRepository.save(technology);
    }

    @Override
    public TechnologyResponse updateTechnologyById(Integer id, TechnologyCreateRequest request) throws Exception {
        Optional<Technology> technology = technologyRepository.findById(id);
        if(technology.isPresent()){
            TechnologyResponse technologyResponse = new TechnologyResponse();
            technologyResponse.setTechnologyName(request.getTechnologyName());
            technology.get().setTechnologyName(request.getTechnologyName());
            this.technologyRepository.save(technology.get());
            return technologyResponse;
        }
        return null;
    }

    @Override
    public String deleteTechnologyById(int id) {
        technologyRepository.deleteById(id);
        return "Technology deleted successfully.";
    }

    @Override
    public Technology getTechnologyById(int id) {
        Optional<Technology> technology = this.technologyRepository.findById(id);
        return technology.get();
    }
}

