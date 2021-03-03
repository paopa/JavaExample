package pers.pao.annotation.lombok.dto;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class BuilderTestDto {
    private String name;
    private int age;
}
