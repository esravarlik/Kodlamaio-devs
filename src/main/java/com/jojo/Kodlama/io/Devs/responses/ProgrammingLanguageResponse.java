package com.jojo.Kodlama.io.Devs.responses;

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
