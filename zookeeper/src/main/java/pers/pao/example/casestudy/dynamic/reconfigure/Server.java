package pers.pao.example.casestudy.dynamic.reconfigure;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import pers.pao.example.connector.ZookeeperConnector;

import java.io.IOException;
import java.net.InetAddress;

public class Server implements Runnable {

    private static final String SERVER = "/test-servers/server";

    private final ZooKeeper client;
    private final String id;
    private final long aliveTime;

    public Server(String id, long aliveTime) throws IOException {
        client = ZookeeperConnector.connectForTesting();
        this.id = InetAddress.getLocalHost() + "_" + id;
        this.aliveTime = aliveTime;
    }

    public Server(String id) throws IOException {
        this(id, Long.MAX_VALUE);
    }

    @Override
    public void run() {
        try {
            String path = client.create(SERVER, this.id.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(this.id + " " + path + " is online");
            Thread.sleep(this.aliveTime);
            client.close();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
