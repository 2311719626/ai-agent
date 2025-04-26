package com.hezhaohui.aiagent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * 阿里云灵积 HTTP 方式 调用
 */
public class HttpAiInvoke {
    public static void main(String[] args) {
        // API Key
        String apiKey = TestApiKey.API_KEY;

        // 构建请求 URL
        String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

        // 创建请求JSON对象
        JSONObject requestBody = new JSONObject();
        requestBody.set("model", "qwen-plus");
        JSONObject input = new JSONObject();

        // 添加系统消息
        JSONObject systemMsg = new JSONObject();
        systemMsg.set("role", "system");
        systemMsg.set("content", "You are a helpful assistant.");

        // 添加用户消息
        JSONObject userMsg = new JSONObject();
        userMsg.set("role", "user");
        userMsg.set("content", "HelloWorld!为这个世界献上美好的祝福!");

        // 组装messages数组
        input.set("messages", JSONUtil.createArray().put(systemMsg).put(userMsg));
        requestBody.set("input", input);

        JSONObject parameters = new JSONObject();
        parameters.set("result_format", "message");
        requestBody.set("parameters", parameters);


        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .execute();

        // 打印响应结果
        System.out.println(response.body());
    }
}