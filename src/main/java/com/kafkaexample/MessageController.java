package com.kafkaexample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RESTful API with Kafka integration
@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    //inject Kafka template
    private KafkaTemplate<String, String> kafkaTemplate;

    //constroctor for autowiring


    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("kafkaCode", request.message());
    }
}
