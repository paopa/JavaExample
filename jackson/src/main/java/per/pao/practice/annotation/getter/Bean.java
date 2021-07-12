package per.pao.practice.annotation.getter;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Bean
{
    @Getter
    private final int id;
    private final String name;

    @JsonGetter("name")
    public String getTheName()
    {
        return this.name;
    }
}
