package com.jojo.Kodlama.io.Devs.business.abstracts;

import com.jojo.Kodlama.io.Devs.entities.Technology;
import com.jojo.Kodlama.io.Devs.requests.TechnologyCreateRequest;
import com.jojo.Kodlama.io.Devs.responses.TechnologyListResponse;
import com.jojo.Kodlama.io.Devs.responses.TechnologyResponse;

import java.util.List;

public interface TechnologyService {

    List<TechnologyListResponse> getAll();

    TechnologyResponse getById(int id) throws Exception;

    Technology add(TechnologyCreateRequest request) throws Exception;

    TechnologyResponse updateTechnologyById(Integer id, TechnologyCreateRequest request) throws Exception;

    String deleteTechnologyById(int id) throws Exception;

    Technology getTechnologyById(int id);
}
