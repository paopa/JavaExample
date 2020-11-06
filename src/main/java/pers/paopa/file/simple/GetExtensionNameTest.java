package pers.paopa.file.simple;

public class GetExtensionNameTest {
    public static void main(String[] args) {
        String filePath = "2020-05-08-1633_WG銷貨明細_gbk拷貝.release.csv";
        System.out.println(checkExtension(filePath));

    }

    public static String getExtension(String fileName) {
        if (fileName == null) return null;
        String[] fileFrags = fileName.split("\\.");
        return fileFrags[fileFrags.length - 1];
    }

    public static boolean checkExtension(String originalFilename) {
        String extension = getExtension(originalFilename);
        if (extension == null) {
            return true;
        }
        System.out.println(extension.toLowerCase());
        switch (extension) {
            case "csv":
            case "xls":
            case "xlsx":
                return false;
        }
        return true;
    }
}
