package pers.paopa.unit.test.fake;

/**
 * SUT
 */
public interface IssueRepository {
    Issue findById(Long id);

    Issue save(Issue issue);

}
