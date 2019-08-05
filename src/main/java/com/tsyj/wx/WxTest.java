package com.tsyj.wx;

import com.tsyj.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信测试
 *
 * @author: guos
 * @date: 2019/8/2$ 18:39$
 **/
public class WxTest {

    private static String dev_send_message_url = "http://192.168.10.202:18087/ac-crm/wx/sendMessage";

    private static String test_send_message_url = "http://192.168.10.209:18087/ac-crm/wx/sendMessage";

    private static String pre_send_message_url = "http://47.111.78.238:8087/ac-crm/wx/sendMessage";

    private static String pro_send_message_url = "https://api.aircourses.com/ac-crm/wx/sendMessage";

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("template", "KRRo_tP8H4QNKavlSbJmm8dfcqmmzcg7HqBQdz3qoog");
        params.put("classDate", "2019-08-20 12:00");
        String res = HttpUtils.doGet(dev_send_message_url, params);
        System.out.println("请求结果：" + res);
    }
}
