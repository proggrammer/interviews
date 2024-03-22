package org.example.msgQue;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class KMQProducerConsumerKMQKMQMessageQueueTest {

    @Test
    void test() {
        KMQProducer kMQProducer1 = new KMQProducer("producer0");
        String topicName1 = "topic1";
        kMQProducer1.createTopic(topicName1);
        kMQProducer1.setTopic(topicName1);
        kMQProducer1.produce("msg1");

        KMQProducer kMQProducer2 = new KMQProducer("producer1");
        String topicName2 = "topic2";
        kMQProducer2.createTopic(topicName2);
        kMQProducer2.setTopic(topicName2);
        kMQProducer2.produce(topicName2+"msg1");


        KMQConsumer consumer = new KMQConsumer("consumer1");
        consumer.setAccept((str) -> System.out.println(str));
        String[] topics = {topicName1, topicName2};
        consumer.subscribe(topics);
        consumer.consume(topicName1);
        consumer.resetOffSet(topicName1);
    }

}