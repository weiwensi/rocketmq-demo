package com.leke.studyrecorde.rocketmq;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @classname AbstractSendMqMsgService
 * @description
 * @date 2020/5/27 17:13
 * @created by weiwensi
 */
public abstract class AbstractSendMqMsgService {

    private Logger logger = LoggerFactory.getLogger(AbstractSendMqMsgService.class);

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    public void sendMsg(Message message){
        try {
            defaultMQProducer.send(message,new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("发送结果=%s, msg=%s ", sendResult.getSendStatus(), sendResult.toString());
                }
                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                    //补偿机制，根据业务情况进行使用，看是否进行重试
                }
            });
        } catch (Exception e) {
            logger.error("发送消息到rocketmq失败msg={}", message.getBody(), e);
        }
    }
}
