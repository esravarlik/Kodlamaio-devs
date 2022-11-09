package com.jojo.Kodlama.io.Devs.responses;

import com.jojo.Kodlama.io.Devs.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageResponse {

    public String name;
    List<TechnologyListResponse> technologyListResponse;
}
