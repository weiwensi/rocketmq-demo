package com.leke.studyrecorde.rocketmq.controller;

import com.leke.studyrecorde.service.FileMqService;
import com.leke.studyrecorde.service.LogMqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @classname TestController
 * @description
 * @date 2020/4/22 14:42
 * @created by weiwensi
 */
@RestController
@RequestMapping("test")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private LogMqService logMqService;
    @Autowired
    private FileMqService fileMqService;

    @GetMapping("send")
    public String test()  {
        // 调用客户端发送消息
        logMqService.sendMsg("hello，我是日志记录发的消息");
        fileMqService.sendMsg(" hello  我是文件转换的消息生产者发的消息");
        return "SUCCESS";
    }
}

