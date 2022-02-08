package com.kafka.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
        //create producer properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer",StringSerializer.class.getName());

        //create produce
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);

        //produce record
        ProducerRecord<String,String> record = new ProducerRecord<String,String>("charan","Hello world,how are you");
        //send data
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
