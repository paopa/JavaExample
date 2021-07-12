package per.pao.practice.annotation.creator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
//@NoArgsConstructor
public class Bean
{
    private final int id;
    private final String name;

    @JsonCreator
    public Bean(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name)
    {
        this.id = id;
        this.name = name;
    }

//    public Bean(int id, String name)
//    {
//        this.id = id;
//        this.name = name;
//    }
}
