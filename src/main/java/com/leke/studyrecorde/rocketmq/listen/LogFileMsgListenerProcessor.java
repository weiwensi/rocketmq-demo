package com.leke.studyrecorde.rocketmq.listen;

import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @classname MQConsumeMsgListenerProcessor
 * @description
 * @date 2020/4/22 14:50
 * @created by weiwensi
 */
@Component
public class LogFileMsgListenerProcessor implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(LogFileMsgListenerProcessor.class);

    private static String TOPIC = "LOG";
    private static String TAGS1 = "LOGTAG1";
    private static String TAGS2 = "LOGTAG2";

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(msgs)) {
            logger.info("接收到的消息为空，不做任何处理");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = msgs.get(0);
        String msg = new String(messageExt.getBody());
        //logger.info("接收到的消息是："+messageExt.toString());
        logger.info("接收到的消息是：" + msg);
        if (messageExt.getTopic().equals(TOPIC)) {
            if (messageExt.getTags().equals(TAGS1)) {
                int reconsumeTimes = messageExt.getReconsumeTimes();
                if (reconsumeTimes == 3) {
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                //TODO 处理对应的业务逻辑
                System.out.println("异步操作：" + "log tag1");

            }
            if (messageExt.getTags().equals(TAGS2)) {
                int reconsumeTimes = messageExt.getReconsumeTimes();
                if (reconsumeTimes == 3) {
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                //TODO 处理对应的业务逻辑
                System.out.println("异步操作：" + "log tag2");

            }
        }
        if (messageExt.getTopic().equals("FILE")) {
            if (messageExt.getTags().equals("FILETAG")) {
                int reconsumeTimes = messageExt.getReconsumeTimes();
                if (reconsumeTimes == 3) {
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                //TODO 处理对应的业务逻辑
                System.out.println("异步操作：" + "begin file convert to pdf");

            }
            if (messageExt.getTags().equals("FILETAG2")) {
                int reconsumeTimes = messageExt.getReconsumeTimes();
                if (reconsumeTimes == 3) {
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                //TODO 处理对应的业务逻辑
                System.out.println("异步操作：" + "消息来自 文件topic d的tag2组");

            }
        }

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

}

