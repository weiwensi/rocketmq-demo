package com.leke.studyrecorde.rocketmq.hook;

import org.apache.rocketmq.client.hook.ConsumeMessageContext;
import org.apache.rocketmq.client.hook.ConsumeMessageHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**消费之后对消息进行拦截
 * @classname ConsumerTestHook
 * @description
 * @date 2020/4/22 14:44
 * @created by weiwensi
 */
public class ConsumerTestHook implements ConsumeMessageHook {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConsumerTestHook.class);

    @Override
    public String hookName() {
        return ConsumerTestHook.class.getName();
    }

    @Override
    public void consumeMessageBefore(ConsumeMessageContext consumeMessageContext) {
        LOGGER.info("execute consumeMessageBefore. consumeMessageContext: {}",consumeMessageContext);
    }

    @Override
    public void consumeMessageAfter(ConsumeMessageContext consumeMessageContext) {
        LOGGER.info("execute consumeMessageAfter. consumeMessageContext: {}",consumeMessageContext);
    }
}

