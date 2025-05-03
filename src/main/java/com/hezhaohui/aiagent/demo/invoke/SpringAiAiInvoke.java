package com.hezhaohui.aiagent.demo.invoke;

import com.alibaba.dashscope.assistants.AssistantParam;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring AI 框架配置 AI 大模型
 */
@Component
public class SpringAiAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage assistantMessage =  dashscopeChatModel.call(new Prompt("向用户发送一条欢迎信息"))
                .getResult()
                .getOutput();
        System.out.println(assistantMessage.getText());
    }
}
