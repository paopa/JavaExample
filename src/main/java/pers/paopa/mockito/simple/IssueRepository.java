package pers.paopa.mockito.simple;

/**
 * STU 的相依介面 DOC (Depended-on Component)
 */
public interface IssueRepository {

    long count();

    void delete(Issue issue);

    Issue find(Long id);

    Issue save(Issue issue);
}
