package com.kafkaexample;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "kafkaCode", groupId = "ainur")
    void listener (String data) {
        System.out.println("Listener received: " + data + " :tada");
    }
}
