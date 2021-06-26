package pers.paopa.assertj.collect;

import org.junit.jupiter.api.Test;
import pers.paopa.assertj.object.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;
import static org.assertj.core.api.Assertions.tuple;

public class AssertJTest {

    @Test
    public void testListAssertByMethod() {
        List<Person> person = List.of(new Person("a", 25), new Person("b", 26), new Person("c", 27));

        // extracting by method
        assertThat(person)
                .hasSize(3)
                .extracting(Person::getName, x -> x.getAge())
                .contains(tuple("a", 25), atIndex(0))
                .contains(tuple("b", 26), atIndex(1));

    }

    @Test
    public void testListAssertByFieldName() {
        List<Person> person = List.of(new Person("a", 25), new Person("b", 26), new Person("c", 27));

        assertThat(person.get(0))
                .extracting("name", "age")
                .containsExactly("a", 25);
    }

    @Test
    public void testListAssertByCollect() {
        List<Person> person = List.of(new Person("a", 25), new Person("b", 26), new Person("c", 27));

        assertThat(person)
                .extracting("name", "age")
                .containsExactly(
                        tuple("a", 25),
                        tuple("b", 26),
                        tuple("c", 27));
    }

    @Test
    public void testListAssertAayOrder() {
        List<Person> person = List.of(new Person("a", 25), new Person("b", 26), new Person("c", 27));

        assertThat(person)
                .extracting("name", "age")
                .containsExactlyInAnyOrder(
                        tuple("b", 26),
                        tuple("a", 25),
                        tuple("c", 27));
    }
}
