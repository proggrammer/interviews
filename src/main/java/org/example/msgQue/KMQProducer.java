package org.example.msgQue;

public class KMQProducer {
    private KMQMessageQueue kmqMessageQueue;
    private String name;
    public KMQProducer(String name){
        this.name = name;
        kmqMessageQueue = KMQMessageQueue.getInstance();
    }

    public void createTopic(String topicName) {
        kmqMessageQueue.createTopic(topicName);
    }

    public void setTopic(String topicName) {
        kmqMessageQueue.setTopic(topicName);
    }

    public void produce(String msg1) {
        kmqMessageQueue.produce(name, msg1);
    }
}
