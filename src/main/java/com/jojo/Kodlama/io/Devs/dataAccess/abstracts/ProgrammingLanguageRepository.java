package com.jojo.Kodlama.io.Devs.dataAccess.abstracts;

import com.jojo.Kodlama.io.Devs.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

    Optional<Object> findAllByName(String name);

    /*
    boolean existsById(int id);
    boolean existByName(String name);
    */

}
