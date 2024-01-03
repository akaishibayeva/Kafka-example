package com.kafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

//this class is responsible for creating topics
@Configuration
public class KafkaTopicConfig {

    //annotate with @Bean, so it is instantiated and we can add a new topic
    @Bean
    public NewTopic kafkaCodeTopic() {
        return TopicBuilder.name("kafkaCode")
                .build();
    }
}
