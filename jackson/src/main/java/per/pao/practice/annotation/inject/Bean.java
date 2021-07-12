package per.pao.practice.annotation.inject;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bean
{
    @JacksonInject
    private int id;
    private String name;
}
