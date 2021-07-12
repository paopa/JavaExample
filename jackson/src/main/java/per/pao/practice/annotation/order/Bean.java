package per.pao.practice.annotation.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@JsonPropertyOrder({"name", "id"})
//@JsonPropertyOrder(alphabetic = true)
@Getter
@RequiredArgsConstructor
public class Bean
{
    private final int id;
    private final String name;
}
