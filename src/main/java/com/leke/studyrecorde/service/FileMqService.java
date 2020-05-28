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
public class FileMqService extends AbstractSendMqMsgService {

    private static String TOPIC = "FILE";
    private static String TAGS = "FILETAG";
    private static String TAGS2= "FILETAG2";

    public void sendMsg(String message) {
        try {
            Message message1 = new Message(TOPIC, TAGS, message.getBytes(RemotingHelper.DEFAULT_CHARSET));
            this.sendMsg(message1);
            Message message2 = new Message(TOPIC, TAGS2, message.getBytes(RemotingHelper.DEFAULT_CHARSET));

            this.sendMsg(message2);
        } catch (UnsupportedEncodingException e) {
           throw new RuntimeException("发送文件消息mq异常");
        }


    }
}
