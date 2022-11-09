package com.jojo.Kodlama.io.Devs.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageCreateRequest {

    public String name;
    private List<Integer> technologyIds;
}
