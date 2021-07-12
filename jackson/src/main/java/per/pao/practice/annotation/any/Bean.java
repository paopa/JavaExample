package per.pao.practice.annotation.any;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Bean
{
    private final String name;
    private final Map<String, String> properties;

    public Bean(final String name)
    {
        this(name, new HashMap<>());
    }

    @JsonAnySetter
    public void add(String key, String value)
    {
        this.properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, String> getProperties()
    {
        return properties;
    }
}