package org.example.msgQue;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KMQTopic {
    private Map<Long, KMQMessage> messageQue;
    private List<KMQConsumer> kmqConsumerList;
    public KMQTopic()  {
        messageQue = new ConcurrentHashMap<>();
    }

    public void produce(String msg) {
        kmqConsumerList.forEach(kmqConsumer -> kmqConsumer.getConsumer().accept(msg));
    }
}
