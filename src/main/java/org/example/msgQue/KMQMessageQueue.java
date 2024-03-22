package org.example.msgQue;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KMQMessageQueue {
    private static volatile KMQMessageQueue instanceSingleton;

    private Map<String, KMQTopic> topicMap;
    private Map<String, String> producerToTopicNameMap;
    private KMQMessageQueue() {
        topicMap = new ConcurrentHashMap<>();
        producerToTopicNameMap = new ConcurrentHashMap<>();
    }

    public static KMQMessageQueue getInstance()    {
        if(instanceSingleton == null)   {
            synchronized (KMQMessageQueue.class)   {
                if(instanceSingleton == null)   {
                    instanceSingleton = new KMQMessageQueue();
                }
            }
        }
        return instanceSingleton;
    }

    public void subscribe(KMQConsumer kmqConsumer, String[] topics) {

    }

    public void produce(String producerName, String msg) {
        String topicName = producerToTopicNameMap.get(producerName);
        KMQTopic kmqTopic = topicMap.get(topicName);
//        kmqTopic.produce(msg)
    }

    public void createTopic(String topicName) {
    }

    public void setTopic(String topicName) {
    }
}
