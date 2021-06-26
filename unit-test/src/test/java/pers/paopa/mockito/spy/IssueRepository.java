package pers.paopa.mockito.spy;

import lombok.Data;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public interface IssueRepository {
    Issue save(Issue issue);
}

@Data
class Issue {

    private Long id;
    private String desc;
    private String title;
}

class IssueRepositoryImpl implements IssueRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(IssueRepositoryImpl.class);

    @Override
    public Issue save(Issue issue) {
        LOGGER.info(() -> "execute save, issue title: " + issue.getTitle());
        return issue;
    }
}


