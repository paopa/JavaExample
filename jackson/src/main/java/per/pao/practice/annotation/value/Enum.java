package per.pao.practice.annotation.value;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Enum
{
    TYPE_A(1, "Type A"),
    TYPE_B(2, "Type B");

    @Getter
    private final int id;
    private final String name;

    @JsonValue
    public String getName()
    {
        return name;
    }
}
