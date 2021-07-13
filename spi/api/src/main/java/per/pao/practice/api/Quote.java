package per.pao.practice.api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Quote
{
    private final String currency;
    private final LocalDate date;
}
