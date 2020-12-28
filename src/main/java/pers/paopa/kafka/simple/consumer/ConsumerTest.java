package pers.paopa.kafka.simple.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerTest {
    public static void main(String[] args) {

        // create properties object
        Properties props = KafkaConsumerConfiguration.props;
        // create consumer object
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // subscribe topics
        consumer.subscribe(Arrays.asList("test"));
//        consumer.assign(Arrays.asList(new TopicPartition("test",1)));

        while (true) {
            // poll data
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            // print
            records.forEach(System.out::println);
        }
    }

    static class KafkaConsumerConfiguration {

        private static final Properties props = new Properties();

        static {
            // kafka cluster
            props.setProperty("bootstrap.servers", "localhost:55029");
            // K V 反序列化
            props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            // set consumer group id
            props.setProperty("group.id", "test-group");
            // auto commit offset ** default is true
            props.setProperty("enable.auto.commit", "true");
            // auto commit offset interval ** default is 5000
            props.setProperty("auto.commit.interval.ms", "1000");
        }

    }
}
