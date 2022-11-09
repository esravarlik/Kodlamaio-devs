package com.jojo.Kodlama.io.Devs.business.abstracts;


import com.jojo.Kodlama.io.Devs.entities.ProgrammingLanguage;
import com.jojo.Kodlama.io.Devs.requests.ProgrammingLanguageCreateRequest;
import com.jojo.Kodlama.io.Devs.responses.ProgrammingLanguageListResponse;
import com.jojo.Kodlama.io.Devs.responses.ProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {

    List<ProgrammingLanguageListResponse> getAll();

    ProgrammingLanguageResponse getById(int id) throws Exception;

    ProgrammingLanguage add(ProgrammingLanguageCreateRequest request) throws Exception;

    ProgrammingLanguageResponse updateProgrammingLanguageById(int id, ProgrammingLanguageCreateRequest request) throws Exception;

    String deleteProgrammingLanguageById(int id) throws Exception;

    ProgrammingLanguage getProgrammingLanguageById(int id) throws Exception;
}
