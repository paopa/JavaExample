package pers.paopa.annotation.lombok;

import pers.paopa.annotation.lombok.dto.BuilderTestDto;

import java.io.PrintStream;

public class BuilderTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        PrintStream os = System.out;
        BuilderTestDto person = BuilderTestDto.builder().build();
        person = person.toBuilder()
                .age(10)
                .name("test2020-08-20")
                .build();
        os.println(person.getAge());
        os.println(person.getName());
    }
}
