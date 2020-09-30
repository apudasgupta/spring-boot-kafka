package com.iatl.lt.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.iatl.lt.model.MobileLocation;

@Configuration
public class KafkaProducerConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	/************* Producer Configuration **********************/
	@Bean
	public ProducerFactory<String, MobileLocation> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<String, MobileLocation>(configProps);
	}

	@Bean
	public KafkaTemplate<String, MobileLocation> kafkaTemplate() {
		return new KafkaTemplate<String, MobileLocation>(producerFactory());
	}
}
