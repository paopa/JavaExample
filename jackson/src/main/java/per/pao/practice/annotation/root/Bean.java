package per.pao.practice.annotation.root;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@JsonRootName(value = "user")
@Getter
@RequiredArgsConstructor
public class Bean
{
    private final int id;
    private final String name;
}
