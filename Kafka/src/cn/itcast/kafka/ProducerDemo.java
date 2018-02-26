package cn.itcast.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


public class ProducerDemo {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("zookeeper.connect", "name1:2182,data1:2181,data2:2181,data3:2181");//
		props.put("metadata.broker.list", "name1:9092,data1:9092,data2:9092,data3:9092");//
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);
		for (int i = 1001; i <= 1200; i++)
			producer.send(new KeyedMessage<String, String>("test", "it " + i));
	}
}