package pers.paopa.junit.runner.hierarchical;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import pers.paopa.junit.runner.hierarchical.sut.Issue;
import pers.paopa.junit.runner.hierarchical.sut.IssueService;

import static org.mockito.BDDMockito.given;

/**
 * Nested Unit test
 */
@RunWith(HierarchicalContextRunner.class)
public class IssueServiceTest {

    private IssueService mockService;

    /**
     * first layer: setup SUT
     */
    @BeforeClass
    public static void rootBeforeClass() {
        System.out.println("root before class");
    }

    @Before
    public void rootBefore() {
        System.out.println("root before");
        mockService = Mockito.mock(IssueService.class);
    }

    @After
    public void rootAfter() {
        System.out.println("root after");
    }

    @AfterClass
    public static void rootAfterClass() {
        System.out.println("root after class");
    }

    /**
     * second layer: 每一個方法建立一個 inner class
     * SUT method 作為 inner class name
     */
    public class FindById {
        public static final long ID = 1L;

        @Before
        public void findByIdBefore() {
            System.out.println("findById before");
        }

        @After
        public void findByIdAfter() {
            System.out.println("findById after");
        }

        /**
         * third layer: 依照 test case 命名 inner class
         * 並配置該 test case 所需要的 test double or data
         */
        public class WhenIssueFound {

            @Before
            public void findByIdWhenIssueFoundBefore() {
                System.out.println("findById when issue found before");
                given(mockService.findById(ID)).willReturn(new Issue());
            }

            @Test
            public void testCase(){
                System.out.println("find by id when issue found test case");
            }
        }

        public class WhenIssueNotFound{

            @Before
            public void findByIdWhenIssueNotFoundBefore(){
                System.out.println("findById when issue found before");
                given(mockService.findById(ID)).willReturn(new Issue());
            }

            @Test
            public void testCase(){
                System.out.println("find by id when issue not found test case");
            }
        }
    }
}