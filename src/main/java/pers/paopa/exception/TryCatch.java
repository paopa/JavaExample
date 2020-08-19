package pers.paopa.exception;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180Parser;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.newBufferedReader;

public class TryCatch {
    public static void main(String[] args) {
        demoWithTryStatement();
    }

    private static void demoWithTryStatement() {
        File file = new File("/Users/workspace/Documents/synergies/jarvix/test_file/訂單.xlsx");
        try (BufferedReader reader = newBufferedReader(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(new RFC4180Parser()).build()) {
            System.out.println(reader.toString());
        } catch (FileSystemException ignore) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
