package pers.pao.file.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import static java.nio.file.Files.newBufferedReader;

public class CsvEncodeTest {
    public static void main(String[] args) throws IOException {
        String filePath = "";
        try (BufferedReader reader = newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                     .build()) {

        } catch (Exception e) {
            throw e;
        }
    }
}
