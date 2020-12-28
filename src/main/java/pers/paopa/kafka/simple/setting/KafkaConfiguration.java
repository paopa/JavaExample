package pers.paopa.kafka.simple.setting;

import java.util.Properties;

public class KafkaConfiguration {

    public static final Properties props = new Properties();

    static {
        // kafka cluster
        props.setProperty("bootstrap.servers", "localhost:55023");
        // K V 序列化
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // ack 機制
        props.setProperty("acks", "1");
        // custom partitioner class
//        props.setProperty("partitioner.class", "pers.paopa.kafka.simple.producer.simple.PartitionerTest");
    }

}
