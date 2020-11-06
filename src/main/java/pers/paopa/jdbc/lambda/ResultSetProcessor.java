package pers.paopa.jdbc.lambda;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetProcessor {
    public void process(ResultSet resultSet, long currentRow) throws SQLException;
}
