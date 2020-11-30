package pers.paopa.junit.simple;

import org.junit.jupiter.api.*;

/**
 * Junit 5
 */
public class AnnotationTest {

    /**
     * 可用於開啟需要消耗較多資源的
     * e.g. database connection
     */
    @BeforeAll
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    /**
     * 每次test case 開始之前
     * e.g. 初始化每個 test case 需要的物件
     */
    @BeforeEach
    public void before() {
        System.out.println("before");
    }

    /**
     * 每次test case 開始之後
     * e.g. 每個 test case 結束後就重置的資源
     */
    @AfterEach
    public void after() {
        System.out.println("after");
    }

    /**
     * all test case 結束之後
     * e.g. 關閉資料庫連線或是需要釋放的共享資源
     */
    @AfterAll
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Test
    public void testCase1() {
        System.out.println("test case1");
    }

    @Test
    public void testCase2() {
        System.out.println("test case2");
    }
}
