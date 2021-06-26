package pers.paopa.junit.category;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

/**
 * 需要在 pom file 加入設定
 *
 * <plugins>
 * <plugin>
 * <groupId>org.apache.maven.plugins</groupId>
 * <artifactId>maven-surefire-plugin</artifactId>
 * <version>2.22.2</version>
 * <!-- Read JUnit categories to be excluded from Maven property -->
 * <configuration>
 * <excludedGroups>${test.excluded.groups}</excludedGroups>
 * </configuration>
 * </plugin>
 * </plugins>
 *
 * <profiles>
 * <profile>
 * <id>Default</id>
 * <!-- Set profile to be active by default -->
 * <activation>
 * <activeByDefault>true</activeByDefault>
 * </activation>
 * <properties>
 * <test.excluded.groups>com.example.IntegrationTest</test.excluded.groups>
 * </properties>
 * </profile>
 * <profile>
 * <id>AllTest</id>
 * <!-- Set groups property to blank value which will match nothing -->
 * <properties>
 * <test.excluded.groups></test.excluded.groups>
 * </properties>
 * </profile>
 * </profiles>
 *
 * When running tests as usual from command line, integration test will be excluded:
 *  mvn test
 *
 * All tests including integration tests can be activated with the corresponding profile:
 *  mvn test -P AllTest
 */
public class CategoryTest {

    @Test
    @Category(value = {GoodUnitTest.class})
    public void test() {
        System.out.println("run good unit test");
    }

    @Test
    @Category(value = {BadUnitTest.class})
    public void test2() {
        System.out.println("run bad unit test");
    }
}