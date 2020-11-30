package pers.paopa.assertj.custom;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

/**
 * custom assert 會增加一個 class ，也就增加了整體測試的複雜度
 * 如果有使用比較可能的原因有：
 *  1. 使用自訂斷言比使用一般斷言更容易閱讀
 *  2. 因為移除實作細節，使得測試更容易閱讀
 *  3. 自訂斷言使測試案例可以移除業務邏輯，並因為集中管理，使我們的測試更容易編寫及維護。
 */
public class IssueTest {

    private static final String CREATOR = "CREATOR";

    @Test
    public void testIssueIsResolved() {
        Issue issue = new Issue();
        issue.setId(1L);
        issue.setCreator(CREATOR);
        issue.setActiveState(ActiveState.DONE);

        SoftAssertions assertions = new SoftAssertions();

        assertions.assertThat(issue.getActiveState())
                .overridingErrorMessage(
                        "已解決的問題的活動狀態必需是已完成的(DONE), 但是為: %s",
                        issue.getActiveState())
                .isEqualTo(ActiveState.DONE);

        assertions.assertThat(issue.getLog())
                .overridingErrorMessage(
                        "已解決的問題的必需要有紀錄內容，但是它的紀錄內容: %s",
                        issue.getLog())
                .isNotNull();

        assertions.assertAll();
    }

    @Test
    public void testIssueAssert() {
        Issue issue = new Issue();
        issue.setId(1L);
        issue.setCreator(CREATOR);
        issue.setActiveState(ActiveState.DONE);

        IssueAssert.assertThatIssue(issue).isResolved();
    }

    @Test
    public void testIssueAssert2() {
        Issue issue = new Issue();
        issue.setId(2L);
        issue.setCreator(CREATOR);
        issue.setActiveState(ActiveState.DONE);
        issue.setLog("everything is ok.");

        IssueAssert.assertThatIssue(issue).isResolved();
    }
}