package pers.pao.example.connector;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class ZookeeperConnector {

    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 2000;

    public static ZooKeeper connect(String servers, Watcher watcher) throws IOException {
        return new ZooKeeper(servers, sessionTimeout, watcher);
    }

    public static ZooKeeper connect(List<String> servers, Watcher watcher) throws IOException {
        return connect(String.join(",", servers), watcher);
    }

    public static ZooKeeper connectForTesting(Watcher watcher) throws IOException {
        return connect(connectString, watcher);
    }

    public static ZooKeeper connectForTesting() throws IOException {
        return connectForTesting(event -> {
            // do nothing
        });
    }
}
