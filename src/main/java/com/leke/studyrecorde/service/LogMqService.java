package com.leke.studyrecorde.service;

import com.leke.studyrecorde.rocketmq.AbstractSendMqMsgService;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @classname LogMqService
 * @description
 * @date 2020/5/27 17:20
 * @created by weiwensi
 */
@Component
public class LogMqService extends AbstractSendMqMsgService {

    private static String TOPIC = "LOG";
    private static String TAGS1 = "LOGTAG1";
    private static String TAGS2 = "LOGTAG2";
    public void sendMsg(String message) {
        try {
            Message message1 = new Message(TOPIC, TAGS1, message.getBytes(RemotingHelper.DEFAULT_CHARSET));
            Message message2 = new Message(TOPIC,TAGS2, message.getBytes(RemotingHelper.DEFAULT_CHARSET));
            //messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
            message1.setDelayTimeLevel(3);
            this.sendMsg(message1);
            this.sendMsg(message2);
        } catch (UnsupportedEncodingException e) {
           throw new RuntimeException("发送日志mq异常");
        }


    }
}
