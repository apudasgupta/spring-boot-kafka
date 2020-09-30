package com.iatl.lt.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.iatl.lt.consumer.model.MobileLocation;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, AppOptions.groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); //
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, MobileLocation> userConsumerFactory() {
//		JsonDeserializer<MobileLocation> jsonDeserializer = new JsonDeserializer<MobileLocation>();
//		jsonDeserializer.addTrustedPackages("*"); 

		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, AppOptions.groupId);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(MobileLocation.class, false));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MobileLocation> locationKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, MobileLocation> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}

	//

}