package com.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) { //dependency injection
        return args -> {
            for (int i = 0; i < 100; i++) {
                kafkaTemplate.send("kafkaCode", "hello, kafka :) " + i); //topic is defined in KafkaTopicConfig.java
                //it'll produce a message: INFO 39812 --- [ad | producer-1] o.a.k.c.p.internals.TransactionManager   : [Producer clientId=producer-1] ProducerId set to 0 with epoch 0
            }
        };
    }

}
