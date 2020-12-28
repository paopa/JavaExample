package pers.paopa.kafka.simple.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class ProducerTest {
    private static final String topic = "test";

    public static void main(String[] args) throws Exception {
        // 建立 配置物件
        Properties props = KafkaProducerConfiguration.props;
        // 建立 producer **note** Producer implements Closeable
        Producer<String, String> producer = new KafkaProducer<>(props);
        // 準備 數據
        ProducerRecord record = new ProducerRecord(topic, "Hello kafka");
        // specified partition number
//        ProducerRecord record = new ProducerRecord(topic, 0, null, "Hello kafka");

        // 生產 數據
        // sync
//        producer.send(record).get();
        // async
//        producer.send(record);
        // async with callback
        producer.send(record, new Callback() {
            // callback method
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                // 發送數據的 partition
                System.out.println(metadata.partition());
                // 發送數據的 offset
                System.out.println(metadata.offset());
            }
        });

        // 關閉 producer
        producer.close();
    }

    static class KafkaProducerConfiguration {

        private static final Properties props = new Properties();

        static {
            // kafka cluster
            props.setProperty("bootstrap.servers", "localhost:55029");
            // K V 序列化
            props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            // ack 機制
            props.setProperty("acks", "1");
            // custom partitioner class
//            props.setProperty("partitioner.class", "pers.paopa.kafka.simple.producer.simple.PartitionerTest");
        }
    }
}
