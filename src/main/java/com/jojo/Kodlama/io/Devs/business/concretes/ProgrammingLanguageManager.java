package com.jojo.Kodlama.io.Devs.business.concretes;

import com.jojo.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.jojo.Kodlama.io.Devs.business.abstracts.TechnologyService;
import com.jojo.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.jojo.Kodlama.io.Devs.entities.ProgrammingLanguage;
import com.jojo.Kodlama.io.Devs.entities.Technology;
import com.jojo.Kodlama.io.Devs.requests.ProgrammingLanguageCreateRequest;
import com.jojo.Kodlama.io.Devs.responses.ProgrammingLanguageListResponse;
import com.jojo.Kodlama.io.Devs.responses.ProgrammingLanguageResponse;
import com.jojo.Kodlama.io.Devs.responses.TechnologyListResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    @Lazy private final TechnologyService technologyService;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
                                      @Lazy TechnologyService technologyService) {
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.technologyService = technologyService;
    }
    @Override
    public List<ProgrammingLanguageListResponse> getAll() {
        if(this.programmingLanguageRepository.findAll().size() > 0){
            List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
            List<ProgrammingLanguageListResponse> programmingLanguageResponse = new ArrayList<>();
            List<TechnologyListResponse> technologyListResponses = new ArrayList<>();

            for(ProgrammingLanguage programmingLanguage : programmingLanguages){
                ProgrammingLanguageListResponse toSaveListProgrammingLanguage = new ProgrammingLanguageListResponse();
                toSaveListProgrammingLanguage.setId(programmingLanguage.getId());
                toSaveListProgrammingLanguage.setName(programmingLanguage.getName());
                programmingLanguageResponse.add(toSaveListProgrammingLanguage);

                for(Technology technology: programmingLanguage.getTechnologyList()){
                    TechnologyListResponse technologyListResponse = new TechnologyListResponse();
                    technologyListResponse.setId(this.technologyService.getTechnologyById(technology.getId()).getId());
                    technologyListResponse.setTechnologyName
                            (this.technologyService.getTechnologyById(technology.getId()).getTechnologyName());
                    technologyListResponses.add(technologyListResponse);
                }
                toSaveListProgrammingLanguage.setTechnologyListResponses(technologyListResponses);
            }
        return programmingLanguageResponse;
        }
      return null;
    }

    @Override
    public ProgrammingLanguageResponse getById(int id) throws Exception{
        checkIfId(id);
        ProgrammingLanguageResponse toSave = new ProgrammingLanguageResponse();
        Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findById(id);
        toSave.setName(programmingLanguage.get().getName());
        return toSave;
    }

    @Override
    public ProgrammingLanguage getProgrammingLanguageById(int id) {
        Optional<ProgrammingLanguage> programmingLanguage = this.programmingLanguageRepository.findById(id);
        return programmingLanguage.get();
    }

    @Override
    public ProgrammingLanguage add(ProgrammingLanguageCreateRequest request) throws Exception {
        isEmptyName(request.getName());
        checkNameDuplication(request);
        ArrayList<Technology> technologies = new ArrayList<>();
        for(Integer id: request.getTechnologyIds()){
            Technology technologyById = technologyService.getTechnologyById(id);
            technologies.add(technologyById);
        }

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setId((int) Math.random());
        programmingLanguage.setName(request.getName());
        programmingLanguage.setTechnologyList(technologies);
        return this.programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public ProgrammingLanguageResponse updateProgrammingLanguageById(int id,
                                                                     ProgrammingLanguageCreateRequest request)throws Exception {
        checkIfId(id);
        checkNameDuplication(request);
        isEmptyName(request.getName());

        Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findById(id);
        if(programmingLanguage.isPresent()){
            ProgrammingLanguageResponse programmingLanguageResponse = new ProgrammingLanguageResponse();
            programmingLanguageResponse.setName(request.getName());
            programmingLanguage.get().setName(request.getName());
            this.programmingLanguageRepository.save(programmingLanguage.get());
            return programmingLanguageResponse;
        }
        return null;
    }

    @Override
    public String deleteProgrammingLanguageById(int id)throws Exception {
        checkIfId(id);
        programmingLanguageRepository.deleteById(id);
        return "Delete operation has successfully done.";
    }

    private void checkNameDuplication(ProgrammingLanguageCreateRequest createRequest)throws Exception{
        if(programmingLanguageRepository.findAllByName(createRequest.getName()).stream().count() != 0){
            throw new Exception("This name is already using.");
        }
    }

    private void isEmptyName(String name)throws Exception{
        if(name.isBlank())
           throw new Exception("Name cannot null.");
    }

    private void checkIfId(int id) throws Exception{
        if(id <= 0){
            throw new Exception("Please enter an valid id.");
        }
    }

}
