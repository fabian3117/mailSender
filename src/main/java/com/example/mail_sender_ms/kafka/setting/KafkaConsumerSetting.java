package com.example.mail_sender_ms.kafka.setting;

import com.example.mail_sender_ms.dto.BodyMail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerSetting {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;


    @Bean
    public ConsumerFactory<String, BodyMail> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        /*props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,false);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.example.mail_sender_ms.dto.BodyMail");
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
         */

//        return new DefaultKafkaConsumerFactory<>(props);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new CustomBodyMailDeserializer());
    }
    public class CustomBodyMailDeserializer implements Deserializer<BodyMail> {
        @Override
        public BodyMail deserialize(String topic, byte[] data) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(data, BodyMail.class);
            } catch (IOException e) {
                throw new SerializationException("Error deserializing BodyMail", e);
            }
        }
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, BodyMail> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, BodyMail> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
