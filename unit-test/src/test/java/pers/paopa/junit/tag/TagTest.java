package pers.paopa.junit.tag;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages(value = {"pers.paopa.junit.tag"})
@IncludeTags(value = {"BadTest", "GoodTest"})
public class TagTest {

}

class TagsTest {
    @Test
    @Tag(value = "GoodTest")
    public void goodTest() {
        System.out.println("run good test");
    }

    @Test
    @Tag(value = "BadTest")
    public void badTest() {
        System.out.println("run bad test");
    }
}
