package pers.paopa.file.excel;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.*;
import pers.paopa.file.excel.enums.FileType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static pers.paopa.file.excel.enums.FileType.*;

public class ExcelTest {
    public static void main(String[] args) throws Exception {
//        String xlsxPath = "/Users/work/Documents/synergies/test_file/第二筆數據data-2020-02-2418_22v3(2).xlsx";
        String xlsxPath = "/Users/work/Documents/synergies/test_file/20200612 WG交易資料(1).xlsx";
        String xlsPath = "";
        openFile(xlsxPath, xlsPath, true);
    }

    private static void openFile(String xlsxPath, String xlsPath, boolean flag) throws Exception {
        File file;
        if (flag) {
            file = new File(xlsxPath);
        } else {
            file = new File(xlsPath);
        }
        parseFile(file);
    }

    private static void parseFile(File file) throws Exception {
        FileType fileType = detectFileType(file);
        switch (fileType) {
            case XLSX:
                parseXlsx(file);
            case XLS:
                parseXls(file);
        }
    }

    private static FileType detectFileType(File file) throws Exception {
        FileType fileType;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            switch (FileMagic.valueOf(FileMagic.prepareToCheckMagic(fileInputStream))) {
                case OOXML:
                    fileType = XLSX;
                    break;
                case OLE2:
                    fileType = XLS;
                    break;
                default:
                    fileType = CSV;
                    break;
            }
        }
        return fileType;
    }

    private static void parseXlsx(File file) {
        try (FileInputStream fisOne = new FileInputStream(file)) {
            simpleExcelXlsxParser(fisOne);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpleExcelXlsxParser(FileInputStream fisOne) throws IOException {
        parse(StreamingReader.builder().rowCacheSize(1000).bufferSize(100).open(fisOne));
    }

    private static void parseXls(File file) {
        try (FileInputStream fisOne = new FileInputStream(file)) {
            simpleExcelXlsParser(fisOne);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private static void simpleExcelXlsParser(FileInputStream fisOne) throws IOException, InvalidFormatException {
        parse(WorkbookFactory.create(fisOne));
    }

    private static void parse(Workbook workbook) throws IOException {
        String[] titleRow = null;
        Sheet sheet = workbook.getSheetAt(0);
        boolean isTitleNotFound = true;
        for (Row row : sheet) {
            if (isTitleNotFound) {
                if (isTitleRow(row)) {
                    titleRow = generateTitles(row);
                    isTitleNotFound = false;
                }
                continue;
            }
            parseRow(row, titleRow);
        }
        workbook.close();
    }

    private static void parseRow(Row row, String[] columns) {
        DataFormatter dataFormatter = new DataFormatter();
        for (int columnIndex = 0; columnIndex < columns.length; columnIndex++) {
            Cell cell = row.getCell(columnIndex);
            String value = null;
            if (cell != null) {
                CellType cellType = cell.getCellTypeEnum();
                switch (cellType) {
                    case BOOLEAN:
                    case STRING:
                    case FORMULA:

                        value = dataFormatter.formatCellValue(cell);
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Date date = cell.getDateCellValue();
                            String datetimeFormat;
                            switch (cell.getCellStyle().getDataFormat()) {
                                case 14:
                                    datetimeFormat = "d/m/yyyy";
                                    break;
                                case 15:
                                    datetimeFormat = "d-mmm-yyyy";
                                    break;
                                case 17:
                                    datetimeFormat = "mmm-yyyy";
                                    break;
                                case 22:
                                    datetimeFormat = "m/d/yyyy h:mm:ss";
                                    break;
                                default:
                                    datetimeFormat = cell.getCellStyle().getDataFormatString();
                            }
                            value = new CellDateFormatter(datetimeFormat).format(date);
                        } else {
                            value = dataFormatter.formatCellValue(cell);
                        }
                        break;
                    default:
                }
                System.out.println(value);
            }
        }
    }

    public static boolean isTitleRow(Row row) {
        int stringCount = 0;
        for (Cell cell : row) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                case BOOLEAN:
                case FORMULA:
                case ERROR:
                case _NONE:
                    return false;
                case BLANK:
                case STRING:
                    stringCount = stringCount + 1;
                    break;
            }
        }
        return stringCount > 0;
    }

    public static String[] generateTitles(Row row) {
        List<String> titleList = new ArrayList<>();
        Iterator<Cell> cellIterator = row.cellIterator();
        int cellIndex = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell != null && cell.getCellTypeEnum() == CellType.STRING) {
                titleList.add(cell.getStringCellValue());
            } else {
                titleList.add("");
            }
            cellIndex = cellIndex + 1;
        }

        return titleList.subList(0, cellIndex).toArray(new String[0]);
    }
}
