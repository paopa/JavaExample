package per.pao.practice.annotation.raw;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Raw
{
    private final String name;
    @JsonRawValue
    private final String json;
}
