package pers.pao.example.casestudy.dynamic.reconfigure;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import pers.pao.example.connector.ZookeeperConnector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client implements Runnable {

    private static final String SERVER_PATH = "/test-servers";
    private final ZooKeeper client;
    private final long aliveTime;

    public Client(long aliveTime) throws IOException {
        this.client = ZookeeperConnector.connectForTesting(event -> {
            try {
                getChildren();
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        this.aliveTime = aliveTime;
    }

    public Client() throws IOException {
        this(Long.MAX_VALUE);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.aliveTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getChildren() throws KeeperException, InterruptedException {
        List<String> children = client.getChildren(SERVER_PATH, true);
        List<String> hosts = new ArrayList<>();
        children.forEach(child -> {
            try {
                byte[] data = client.getData(SERVER_PATH + "/" + child, false, null);
                hosts.add(new String(data));
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(hosts);
    }
}
