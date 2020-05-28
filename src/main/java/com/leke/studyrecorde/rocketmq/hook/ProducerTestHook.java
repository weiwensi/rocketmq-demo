package com.leke.studyrecorde.rocketmq.hook;

import org.apache.rocketmq.client.hook.SendMessageContext;
import org.apache.rocketmq.client.hook.SendMessageHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @classname ProducerTestHook
 * @description
 * @date 2020/4/22 14:44
 * @created by weiwensi
 */
public class ProducerTestHook implements SendMessageHook {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProducerTestHook.class);

    @Override
    public String hookName() {
        return ProducerTestHook.class.getName();
    }

    @Override
    public void sendMessageBefore(SendMessageContext sendMessageContext) {
        LOGGER.info("execute sendMessageBefore. sendMessageContext:{}", sendMessageContext);
    }

    @Override
    public void sendMessageAfter(SendMessageContext sendMessageContext) {
        LOGGER.info("execute sendMessageAfter. sendMessageContext:{}", sendMessageContext);
    }
}

