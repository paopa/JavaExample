package pers.paopa.kafka.simple.producer;

import org.apache.kafka.clients.producer.*;

import java.util.List;
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
//        callbackSend(producer, record);
        // async with interceptor
        interceptorSend(producer, record);

        // 關閉 producer
        producer.close();
    }

    private static void interceptorSend(Producer<String, String> producer, ProducerRecord record) {
        for (int i = 0; i < 5; i++) {
            callbackSend(producer, record);
        }
    }

    private static void callbackSend(Producer<String, String> producer, ProducerRecord record) {
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
    }

    static class KafkaProducerConfiguration {

        private static final Properties props = new Properties();

        static {
            // kafka cluster
            props.setProperty("bootstrap.servers", "localhost:55001");
            // K V 序列化
            props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            // ack 機制
            props.setProperty("acks", "1");
            // custom partitioner class
//            props.setProperty("partitioner.class", "pers.paopa.kafka.simple.producer.simple.PartitionerTest");
            // interceptor
            props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, List.of(
                    "pers.paopa.kafka.simple.producer.TimeInterceptor",
                    "pers.paopa.kafka.simple.producer.CounterInterceptor"
            ));
        }
    }
}
