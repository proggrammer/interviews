package org.example.msgQue;

import java.util.function.Consumer;

public class KMQConsumer {
    private KMQMessageQueue kmqMessageQueue;
    private String name;
    private Consumer consumer;
    private long offset;
    public KMQConsumer(String name)    {
        this.name = name;
        kmqMessageQueue = KMQMessageQueue.getInstance();
        offset = 0;
    }

    public void setAccept(Consumer consumer) {
        this.consumer  = consumer;
    }

    public void subscribe(String[] topics) {
        kmqMessageQueue.subscribe(this, topics);
    }

    public Consumer getConsumer()  {
        return consumer;
    }

    public void consume(String topicName1) {
    }

    public void resetOffSet(String topicName1) {
    }
}
