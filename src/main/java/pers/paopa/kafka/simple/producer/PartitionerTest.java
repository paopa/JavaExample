package pers.paopa.kafka.simple.producer.simple;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * implement partition algorithm class
 */
public class PartitionerTest implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value,
                         byte[] valueBytes, Cluster cluster) {
        // 2020-12
        // crc32
        // hash & %
//        String val = (String) value;
//        int result = val.hashCode() ^ Integer.MAX_VALUE;
//        return result % 4;
        return 2;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
