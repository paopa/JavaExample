package pers.paopa.enums;

public enum Test {
    zh_TW, zh_CN;

    public static String convertToString(Test language) {
        switch (language) {
            case zh_TW:
                return "zh-Tw";
            case zh_CN:
                return "zh-CN";
            default:
                return null;
        }
    }
}
