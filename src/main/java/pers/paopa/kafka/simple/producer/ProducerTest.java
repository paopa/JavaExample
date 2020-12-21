package pers.paopa.kafka.simple.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerTest {
    private static final String topic = "test";

    public static void main(String[] args) {
        // 建立 配置物件
        Properties props = new Properties();
        // kafka cluster
        props.setProperty("bootstrap.servers", "localhost:9092");
        // K V 序列化
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // ack 機制
        props.setProperty("acks", "1");

        // 建立 producer **note** Producer implements Closeable
        Producer<String, String> producer = new KafkaProducer<>(props);

        // 準備 數據
        ProducerRecord record = new ProducerRecord(topic, "Hello kafka");

        // 生產 數據
        producer.send(record);

        // 關閉 producer
        producer.close();
    }
}
