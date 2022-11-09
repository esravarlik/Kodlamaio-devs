package com.jojo.Kodlama.io.Devs.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageListResponse {

    private int id;
    private String name;
    List<TechnologyListResponse> technologyListResponses;
}
