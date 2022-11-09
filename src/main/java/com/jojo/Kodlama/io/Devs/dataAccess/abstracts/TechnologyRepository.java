package com.jojo.Kodlama.io.Devs.dataAccess.abstracts;

import com.jojo.Kodlama.io.Devs.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
