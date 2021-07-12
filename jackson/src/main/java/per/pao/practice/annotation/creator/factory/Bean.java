package per.pao.practice.annotation.creator.factory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Bean
{
    private final int id;
    private final String name;

    @JsonCreator
    public static Bean creator(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name)
    {
        return new Bean(id, name);
    }
}
