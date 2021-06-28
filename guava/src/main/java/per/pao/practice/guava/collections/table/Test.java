package per.pao.practice.guava.collections.table;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;
import java.util.Set;

/**
 * Table<R,C,V> == Map<R,Map<C,V>>
 * Company: IBM, Microsoft, TCS
 * IBM 		-> {101:Mahesh, 102:Ramesh, 103:Suresh}
 * Microsoft 	-> {101:Sohan, 102:Mohan, 103:Rohan }
 * TCS 		-> {101:Ram, 102: Shyam, 103: Sunil }
 */
public class Test {
    public static void main(String[] args) {
        A a = new A();
        rowTest(a.table);
        rowKeySetTest(a.table);
        columnTest(a.table);
    }

    private static void columnTest(Table<String, String, String> table) {
        Map<String, String> map = table.column("102");
        map.forEach((k, v) -> System.out.println("Employer: " + k + ", Name: " + v));
    }

    private static void rowKeySetTest(Table<String, String, String> table) {
        Set<String> set = table.rowKeySet();
        System.out.print("employers: ");
        set.forEach(v -> System.out.print(v + " "));
        System.out.println();
    }

    private static void rowTest(Table<String, String, String> table) {
        Map<String, String> map = table.row("IBM");
        System.out.println("list of IBM employees");
        map.forEach((k, v) -> System.out.println("emp id: " + k + ", name: " + v));
    }
}

class A {
    Table<String, String, String> table = HashBasedTable.create();

    public A() {
        table.put("IBM", "101", "Mahesh");
        table.put("IBM", "102", "Ramesh");
        table.put("IBM", "103", "Suresh");

        table.put("Microsoft", "111", "Sohan");
        table.put("Microsoft", "112", "Mohan");
        table.put("Microsoft", "113", "Rohan");

        table.put("TCS", "121", "Ram");
        table.put("TCS", "122", "Shyam");
        table.put("TCS", "123", "Sunil");
    }
}
