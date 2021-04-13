package pers.pao.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Object> aList = new ArrayList<>() {{
            add(1);
            add(2);
        }};
        aList.get(1); // O(1)

        aList.add("s"); // O(1) or O(n)(if copy array operation is considered)
        aList.add(1, "d"); // O(n)
        aList.listIterator().add("s"); // O(n)

        aList.remove("a"); // O(n)
        aList.remove(0); // O(n)
        ListIterator<Object> aIt = aList.listIterator();
        aIt.next();
        aIt.remove(); // O(n)

        LinkedList<Object> lList = new LinkedList<>() {{
            add(1);
            add(2);
        }};

        lList.get(1); //O(n)

        lList.add("s"); //O(1)
        lList.add(1, "d"); //O(n)
        lList.listIterator().add("s"); //O(1)

        lList.remove("a"); //O(n)
        lList.remove(0); //O(n)
        ListIterator<Object> lIt = lList.listIterator();
        lIt.next();
        lIt.remove();
    }
}
