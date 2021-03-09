package pers.pao.regexp.simple;

import java.util.regex.Pattern;

public class SqlRegexTest {
    public static void main(String[] args) {
//        String sql = "select TOP 100 percent * from datetime_test order by datetime1";
        String sql = "select * from (select * from datetime_test order by datetime1)";
        execute(sql);
    }

    public final static Pattern OrderByPattern = Pattern.compile("(?i)(order(\\ +)by)");
    public final static Pattern SelectReplacePattern = Pattern.compile(
            "(?i)((select(\\ +)top(\\ +)100(\\ +)percent(\\ +))|select(\\ +))");

    private static void execute(String sql) {
        //todo check has order by
        String sqlA = sql;
        boolean hasOrderBy = OrderByPattern.matcher(sql).find();
        if (hasOrderBy) {
            sqlA = sql.replaceAll(String.valueOf(SelectReplacePattern),"SELECT TOP 100 PERCENT ");
        }
        System.out.println(sqlA);
    }
}
