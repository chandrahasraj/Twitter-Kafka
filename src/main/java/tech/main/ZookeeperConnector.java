package tech.main;

import java.io.IOException;
import java.util.Properties;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import com.google.common.io.Resources;

import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer$;
import kafka.utils.ZkUtils;

public class ZookeeperConnector {

	private final String zookeeper_connect_string;
	private final int session_timeout_ms, connection_timeout_ms;
	private final boolean isSecureKafkaCluster;
	private final ZkConnection connection;

	/**
	 * initializes all the necessary fields
	 * 
	 * @throws Exception
	 */
	ZookeeperConnector() throws Exception {
		Properties prop = new Properties();
		try {
			prop.load(Resources.getResource("zookeeper.props").openStream());
			zookeeper_connect_string = prop.getProperty("zookeeperServers", "localhost:2181");
			session_timeout_ms = getIntegerProperty("sessionTimeoutMs", prop);
			connection_timeout_ms = getIntegerProperty("connectionTimeoutMs", prop);
			connection = new ZkConnection(zookeeper_connect_string);
			isSecureKafkaCluster = getBooleanProperty("isSecureKafkaCluster", prop);
		} catch (IOException e) {
			throw new Exception("zookeeper.props file not foung in classpath");
		}
	}

	private int getIntegerProperty(String key, Properties prop) {
		if (prop.get(key) != null)
			return Integer.valueOf((String) prop.get(key));
		else
			return 10 * 1000;
	}

	private boolean getBooleanProperty(String key, Properties prop) {
		if (prop.get(key) != null)
			return Boolean.valueOf((String) prop.get(key));
		else
			return false;
	}

	/**
	 * 
	 * @param topic_name
	 *            Name of the topic to create
	 * @param partitions
	 *            number of partitions (Note: The number of partitions must
	 *            always be greater than or equal to number of consumers)
	 * @param replication
	 *            The data replication factor( for 2 kafka servers if
	 *            replication is 2 then replicate in both the servers)
	 * @param topicConfig
	 *            Any additional properties to be set to the topic
	 * @return true if topic successfully created false otherwise
	 */
	public boolean createKafkaTopic(String topic_name, int partitions, int replication, Properties topicConfig) {
		ZkClient zkClient = new ZkClient(zookeeper_connect_string, session_timeout_ms, connection_timeout_ms,
				ZKStringSerializer$.MODULE$);
		ZkUtils zkUtils = new ZkUtils(zkClient, connection, isSecureKafkaCluster);
		if (!AdminUtils.topicExists(zkUtils, topic_name)) {
			AdminUtils.createTopic(zkUtils, topic_name, partitions, replication, topicConfig);
			zkClient.close();
			return true;
		}
		zkClient.close();
		return false;
	}

	/**
	 * 
	 * @param topic_name topic to delete
	 * @return false if deletion is not successful true otherwise
	 */
	public boolean deleteKafkaTopic(String topic_name) {
		ZkClient zkClient = new ZkClient(zookeeper_connect_string, session_timeout_ms, connection_timeout_ms,
				ZKStringSerializer$.MODULE$);
		ZkUtils zkUtils = new ZkUtils(zkClient, connection, isSecureKafkaCluster);
		if (AdminUtils.topicExists(zkUtils, topic_name)) {
			AdminUtils.deleteTopic(zkUtils, topic_name);
			zkClient.close();
			return true;
		}
		zkClient.close();
		return false;
	}
}
