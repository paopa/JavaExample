package pers.pao.string.com;

public class StringBuilderTest {
    public static void main(String[] args) {
        Table table = new Table();
        table.setTableName("Test");
        int[] columns = new int[]{1,2,3,4,56,7};
        ImportSetting setting = new ImportSetting();
        setting.setTable(table);
        setting.setColumns(columns);
        String insertSql = generatePreparedInsertStatement(setting);
        System.out.println(insertSql);
    }

    public static String generatePreparedInsertStatement(ImportSetting setting) {
        int[] columns = setting.getColumns();
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(setting.getTable().getTableName()).append(" (");
        boolean isNotFirstColumn = false;
        for (int column : columns) {

            if (isNotFirstColumn) {
                sb.append(", ");
            }
            sb.append("\"").append(column).append("\"");
            isNotFirstColumn = true;
        }
        sb.append(") VALUES (");
        isNotFirstColumn = false;
        for (int column : columns) {

            if (isNotFirstColumn) {
                sb.append(", ");
            }

            sb.append("to_timestamp(");
            sb.append("to_char( ?::timestamp, 'YYYY-MM-DD HH24:MI:SS.MS')");
            sb.append(", 'YYYY-MM-DD HH24:MI:SS.MS')::timestamp");

            isNotFirstColumn = true;
        }
        sb.append(")");
        return sb.toString();
    }
}

class ImportSetting {
    private Table table;
    private int[] columns;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int[] getColumns() {
        return columns;
    }

    public void setColumns(int[] columns) {
        this.columns = columns;
    }
}

class Table {
    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}