package com.example.kafka;

import com.example.dto.StockData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "data")
    public void dataFetch(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<StockData> stockDataResult = mapper.readValue(message, new TypeReference<>() {});
        log.info("stockDataResult {}",stockDataResult);
    }

}
