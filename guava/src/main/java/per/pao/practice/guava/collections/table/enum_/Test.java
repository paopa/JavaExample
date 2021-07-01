package per.pao.practice.guava.collections.table.enum_;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

public final class Test
{
    public static void main(String[] args)
    {
        Tool tool1 = A.A11;
        Tool tool2 = A.A21;
        System.out.println(Convertor.search(Type.TYPE_1, tool1.hashCode()));
        System.out.println(Convertor.search(Type.TYPE_2, tool2.hashCode()));
        System.out.println("-----");
        System.out.println(Convertor.search(Type.TYPE_1, 123));
        System.out.println(Convertor.search(Type.TYPE_2, 123));
    }
}

final class Convertor
{
    private static final Table<Type, Integer, B> TABLE = HashBasedTable.create();
    private static final Object UNDEFINED_OBJECT = new Object();

    static {
        TABLE.put(Type.TYPE_1, A.A11.hashCode(), B.B1);
        TABLE.put(Type.TYPE_2, A.A21.hashCode(), B.B2);
        TABLE.put(Type.TYPE_1, UNDEFINED_OBJECT.hashCode(), B.B11);
        TABLE.put(Type.TYPE_2, UNDEFINED_OBJECT.hashCode(), B.B22);
    }

    public static B search(Type row, int hash)
    {
        if (!TABLE.containsColumn(hash)) {
            return TABLE.column(UNDEFINED_OBJECT.hashCode()).get(row);
        }
        return TABLE.row(row).get(hash);
    }
}

interface Tool {}

@Getter
@AllArgsConstructor
enum A
        implements Tool
{
    A11(Type.TYPE_1, "1"), A21(Type.TYPE_2, "1");
    private final Type row;
    private final String column;
}

enum Type
{
    TYPE_1, TYPE_2;
}

enum B
{
    B1, B2, B11, B22;
}