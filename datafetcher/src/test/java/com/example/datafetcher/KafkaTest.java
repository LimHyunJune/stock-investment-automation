package com.example.datafetcher;

import com.example.kafka.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaTest {

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    void kafkaSendTest()
    {
        kafkaProducer.send("data","Test");
    }

}
