package pers.pao.example.connector;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.BeforeClass;

import java.io.IOException;
import java.util.List;

public class Test {

    private static ZooKeeper client;

    @BeforeClass
    public static void init() throws IOException {
        client = ZookeeperConnector.connectForTesting(new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children;
                try {
                    children = client.getChildren("/test", true);
                    System.out.println("*** start ***");
                    children.forEach(child -> System.out.println("watcher_" + child));
                    System.out.println("*** end ***");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * ACL: access permission
     */
    @org.junit.Test
    public void createNodeTest() throws Exception {
        String path = client.create("/test", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
        String path2 = client.create("/test/t1", "t11".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path2);
    }

    /**
     * 看來 watcher 運用方式是利用多線程維持
     */
    @org.junit.Test
    public void getNodeAndWatchTest() throws Exception {
        List<String> children = client.getChildren("/test", true);
        System.out.println("async thread");
        children.forEach(System.out::println);
        Thread.sleep(Long.MAX_VALUE);
    }

    @org.junit.Test
    public void isNodeExistTest() throws Exception {
        Stat stat = client.exists("/test/t2", false);
        System.out.println(stat == null ? "not exist" : stat);
        Thread.sleep(Long.MAX_VALUE);
    }
}
