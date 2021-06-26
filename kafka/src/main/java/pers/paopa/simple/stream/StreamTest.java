package pers.paopa.simple.stream;


import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class StreamTest {
    public static void main(String[] args) {

        // create kafka stream object
        Topology builder = KafkaStreamConfig.topology;
        Properties config = KafkaStreamConfig.props;
        KafkaStreams streams = new KafkaStreams(builder, config);
        streams.start();
    }

    static class KafkaStreamConfig {
        public final static Properties props = new Properties();
        public final static Topology topology = new Topology();
        private final static String SOURCE = "first";
        private final static String TO = "second";

        static {
            settingConfig();
            settingTopology();
        }

        private static void settingTopology() {
            // source
            topology.addSource("S1", SOURCE);
            // process
            topology.addProcessor("P1", LogProcessor::new, "S1");
            // sink
            topology.addSink("T1", TO, "P1");
        }

        private static void settingConfig() {
            props.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:55002");
            props.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "logFilter");
        }
    }
}

class LogProcessor implements Processor<byte[], byte[]> {

    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
    }

    /**
     * kafka stream 中數據的轉換
     *
     * @param key
     * @param value
     */
    @Override
    public void process(byte[] key, byte[] value) {
        // cast to string
        String text = new String(value, StandardCharsets.UTF_8);
        // # => ''
        text = text.replaceAll("#", "");
        context.forward(key, text.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void close() {

    }
}