package pers.paopa.regex;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180Parser;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import static java.nio.charset.Charset.forName;
import static java.nio.file.Files.newBufferedReader;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class RobotAskTest {
    public static void main(String[] args) throws IOException {
        String inputString = "toto";
        File file = new File("/Users/work/Documents/my/file/robot_ask_pattern.csv");
        String text = parse(file, inputString);
        System.out.println(text);
    }

    public static String parse(File file, String inputString) throws IOException {
        String parseText = null;
        String encoding = detectFileEncoding(file);
        try (BufferedReader reader = newBufferedReader(Paths.get(file.getAbsolutePath()), forName(encoding));
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withCSVParser(new RFC4180Parser())
                     .build()) {
            String[] currentRecord = csvReader.readNext();
            while (currentRecord != null) {
                Pattern pattern = Pattern.compile(currentRecord[0], Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(inputString).find()) {
                    parseText = currentRecord[0];
                    break;
                }
                currentRecord = csvReader.readNext();
            }
        } catch (Exception e) {
            throw e;
        }
        return parseText;
    }

    private static String detectFileEncoding(File file) throws IOException {
        byte[] buff = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(file);
        UniversalDetector detector = new UniversalDetector(null);
        int read;
        while ((read = fileInputStream.read(buff)) > 0 && !detector.isDone()) {
            detector.handleData(buff, 0, read);
        }
        detector.dataEnd();
        String encoding = !isEmpty(detector.getDetectedCharset()) ? detector.getDetectedCharset() : "UTF-8";
        detector.reset();
        return encoding;
    }
}
