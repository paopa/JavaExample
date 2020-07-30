package pers.paopa.file;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.Charset.forName;
import static java.nio.file.Files.newBufferedReader;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class CsvTest {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/workspace/Documents/synergies/test_file/art_daily_flatmiddle.csv";
        byte[] buff = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(filePath);
        UniversalDetector detector = new UniversalDetector(null);
        int read;
        while ((read = fileInputStream.read(buff)) > 0 && !detector.isDone()) {
            detector.handleData(buff, 0, read);
        }
        detector.dataEnd();
        String encoding = !isEmpty(detector.getDetectedCharset()) ? detector.getDetectedCharset() : "UTF-8";
        detector.reset();
        System.out.println(encoding);
        try (BufferedReader reader = newBufferedReader(Paths.get(filePath), forName(encoding));
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                     .build()) {
            while(csvReader.readNext() != null){
                List<String> test = List.of(csvReader.readNext());
                System.out.println(test);
            }

        } catch (Exception e) {
            throw e;
        }
    }
}