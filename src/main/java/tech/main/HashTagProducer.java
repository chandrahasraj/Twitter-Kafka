package tech.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.google.common.io.Resources;

public class HashTagProducer {

	public static void main(String as[]) {
		try (InputStream props = Resources.getResource("producer.props").openStream()) {
			KafkaProducer<String, String> producer;
			ZookeeperConnector zkConnect = new ZookeeperConnector();
			Properties properties = new Properties();
			properties.load(props);
			producer = new KafkaProducer<>(properties);
			boolean created_topic = zkConnect.createKafkaTopic("messages", 2, 1, new Properties());
			if (created_topic) {
				producer.send(new ProducerRecord<String, String>("messages", "Message-" + System.currentTimeMillis(),
						"Time_in_nano-" + System.nanoTime()));
			}
			producer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
