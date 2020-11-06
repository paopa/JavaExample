package pers.paopa.string.simple;

public class StringBuilderReturnTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        StringBuilder sb = new StringBuilder();
        sb.append("(select * ");
        sb = addFeatureColumn(sb);
        sb = addFeatureColumn(sb);
        sb.append(" from ").append("tableName").append(")");
        System.out.println(sb.toString());
    }

    private static StringBuilder addFeatureColumn(StringBuilder sb) {
        return sb.append(", ").append("column.getOperator()").append(" as ").append("column.getName()");
    }
}
