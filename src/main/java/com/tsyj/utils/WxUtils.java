package com.tsyj.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tsyj.model.MessageTemplate;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.*;

/**
 * @description: 微信工具类
 * @author: doron.guo
 */
@SuppressWarnings("all")
public class WxUtils {

    private static final Logger logger = LoggerFactory.getLogger(WxUtils.class);

    /**
     * 微信接口访问access_token
     */
    private static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 小程序获取用户openid session_key unionid
     */
    private static String miniprogram_open_id_url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    /**
     * 小程序模板消息发送
     */
    private static String miniprogram_send_template_message_url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";

    /**
     * 获取小程序二维码
     */
    private static String miniprogram_qr_code_url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";

    /**
     * 获取微信用户授权code
     */
    private static String wechat_authorize_code_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

    /**
     * 获取微信用户access_token和openid
     */
    private static String user_access_token_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /**
     * 获取微信用户信息
     */
    private static String user_info_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /**
     * 刷新微信用户access_token
     */
    private static String refresh_user_access_token_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

    /**
     * 服务号模板消息发送
     */
    private static String send_template_message_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    /**
     * 获取服务号二维码ticket
     */
    private static String qrcode_ticket_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";

    /**
     * 获取服务号二维码图片地址(替换此链接中的TICKET)
     */
    private static String qrcode_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

    /**
     * 获取微信接口访问access_token
     *
     * @param appId
     * @param appSecret
     * @return
     */
    public static Map<String, Object> getAccessToken(String appId, String appSecret) throws Exception {
        String url = access_token_url.replace("APPID", appId).replace("APPSECRET", appSecret);
        String result = HttpUtils.doGet(url);
        Map<String, Object> res = null;
        if (result.contains("access_token")) {
            res = new HashMap<String, Object>();
            JSONObject jsonObject = JSON.parseObject(result);
            res.put("access_token", jsonObject.get("access_token"));
            res.put("expires_in", jsonObject.get("expires_in"));
        }
        return res;
    }

    /**
     * 获取微信接口访问access_token
     *
     * @param appId
     * @param appSecret
     * @return
     */
    public static String getAccessToken(String tokenUrl, String appId, String appSecret) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("appId", appId);
        params.put("appSecret", appSecret);
        String response = HttpUtils.doPost(tokenUrl, params);
        JSONObject jsonObject = JSON.parseObject(response);
        if (jsonObject.getIntValue("errorCode") != 0) {
            throw new RuntimeException("获取token失败");
        }

        return jsonObject.getString("data");
    }

    /**
     * 小程序获取openid
     *
     * @param appId
     * @param appSecret
     * @param wxCode
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getMiniprogramOpenId(String appId, String appSecret, String wxCode) throws Exception {
        String url = WxUtils.miniprogram_open_id_url.replace("APPID", appId).replace("SECRET", appSecret)
                .replace("JSCODE", wxCode);
        String result = HttpUtils.doGet(url);
        Map<String, Object> res = null;
        if (result.contains("openid")) {
            res = new HashMap<String, Object>();
            JSONObject jsonObject = JSON.parseObject(result);
            res.put("openid", jsonObject.get("openid"));
            res.put("session_key", jsonObject.get("session_key"));
            res.put("unionid", jsonObject.get("unionid"));
        }
        return res;
    }

    /**
     * 小程序发送模板消息
     *
     * @param accessToken
     * @param messageTemplate
     * @return
     * @throws Exception
     */
    public static Map<String, Object> sendMiniprogramMessage(String accessToken, MessageTemplate messageTemplate) throws Exception {
        Map<String, Object> res = new HashMap<String, Object>();
        String result = HttpUtils.doPostJson(WxUtils.miniprogram_send_template_message_url.replace("ACCESS_TOKEN", accessToken),
                JSONObject.toJSON(messageTemplate));
        JSONObject jsonObject = JSON.parseObject(result);
        res.put("errcode", jsonObject.get("errcode"));
        res.put("errmsg", jsonObject.get("errmsg"));
        return res;
    }

    /**
     * POST请求 ：返回InputStream
     *
     * @param accessToken
     * @param jsonBody
     * @return
     * @throws Exception
     */
    public static InputStream getXcxStream(String accessToken, Map<String, Object> jsonBody) throws Exception {
        OkHttpUtils.ResponseWrapper responseWrapper = OkHttpUtils
                .postJson(WxUtils.miniprogram_qr_code_url.replace("ACCESS_TOKEN", accessToken), JSON.toJSONString(jsonBody));
        return responseWrapper.asStream();
    }

    /**
     * 微信支付签名算法sign
     *
     * @param parameters
     * @return
     */
    public static String createSign(SortedMap<String, Object> parameters, String mchKey) throws Exception {
        StringBuffer sb = new StringBuffer();
        Set<?> es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
        @SuppressWarnings("rawtypes")
        Iterator it = es.iterator();
        while (it.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (!org.springframework.util.StringUtils.isEmpty(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + mchKey);
        System.out.println("params: " + sb.toString());
        return DigestUtils.md5Hex(sb.toString().getBytes("UTF-8")).toUpperCase();
    }

    /**
     * 微信网页授权(静默授权：无需弹窗用户确认)
     *
     * @param appId       公众号的唯一标识
     * @param redirectUrl 授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
     * @return
     */
    public static String getWechatAuthorizeCodeSilent(String appId, String redirectUrl) {
        // scope为snsapi_base
        String scope = "snsapi_base";
        return WxUtils.wechat_authorize_code_url.replace("APPID", appId).replace("REDIRECT_URI", redirectUrl)
                .replace("SCOPE", scope);
    }

    /**
     * 微信网页授权(非静默授权：需要弹窗用户确认)
     *
     * @param appId       公众号的唯一标识
     * @param redirectUrl 授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
     * @return
     */
    public static String getWechatAuthorizeCode(String appId, String redirectUrl) {
        // scope为snsapi_userinfo
        String scope = "snsapi_userinfo";
        return WxUtils.wechat_authorize_code_url.replace("APPID", appId).replace("REDIRECT_URI", redirectUrl)
                .replace("SCOPE", scope);
    }

    /**
     * 根据授权code获取access_token, openid等信息
     *
     * @param appId
     * @param appSecret
     * @param wxCode
     * @return
     */
    public static Map<String, Object> getUserAccessTokenAndOpenId(String appId, String appSecret, String wxCode) throws Exception {
        String url = WxUtils.user_access_token_openid_url.replace("APPID", appId).replace("SECRET", appSecret)
                .replace("CODE", wxCode);
        String result = HttpUtils.doGet(url);
        logger.info("回调结束，打印结果：" + result);
        Map<String, Object> res = null;
        if (result.contains("openid")) {
            res = new HashMap<String, Object>();
            JSONObject jsonObject = JSON.parseObject(result);
            res.put("access_token", jsonObject.get("access_token"));
            res.put("expires_in", jsonObject.get("expires_in"));
            res.put("refresh_token", jsonObject.get("refresh_token"));
            res.put("openid", jsonObject.get("openid"));
            res.put("scope", jsonObject.get("scope"));
        }
        return res;
    }

    /**
     * 通过微信用户access_token和用户openid获取用户信息
     *
     * @param accessToken
     * @param openId
     * @return
     */
    public static Map<String, Object> getUserInfo(String accessToken, String openId) throws Exception {
        String url = WxUtils.user_info_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        String result = HttpUtils.doGet(url);
        logger.info("回调结束，打印结果：" + result);
        Map<String, Object> res = null;
        if (result.contains("openid")) {
            res = new HashMap<String, Object>();
            JSONObject jsonObject = JSON.parseObject(result);
            res.put("openid", jsonObject.get("openid"));
            res.put("nickname", jsonObject.get("nickname"));
            res.put("sex", jsonObject.get("sex"));
            res.put("province", jsonObject.get("province"));
            res.put("city", jsonObject.get("city"));
            res.put("country", jsonObject.get("country"));
            res.put("headimgurl", jsonObject.get("headimgurl"));
            res.put("privilege", jsonObject.get("privilege"));
            res.put("unionid", jsonObject.get("unionid"));
        }
        return res;
    }

    /**
     * 刷新微信用户access_token
     *
     * @param appId
     * @param refreshToken
     * @return
     */
    public static Map<String, Object> refreshUserAccessToken(String appId, String refreshToken) throws Exception {
        String url = WxUtils.refresh_user_access_token_url.replace("APPID", appId).replace("REFRESH_TOKEN",
                refreshToken);
        String result = HttpUtils.doGet(url);
        logger.info("回调结束，打印结果：" + result);
        Map<String, Object> res = null;
        if (result.contains("openid")) {
            res = new HashMap<String, Object>();
            JSONObject jsonObject = JSON.parseObject(result);
            res.put("access_token", jsonObject.get("access_token"));
            res.put("expires_in", jsonObject.get("expires_in"));
            res.put("refresh_token", jsonObject.get("refresh_token"));
            res.put("openid", jsonObject.get("openid"));
            res.put("scope", jsonObject.get("scope"));
        }
        return res;
    }

    /**
     * 服务号微信模板消息发送
     *
     * @param accessToken     微信接口访问access_token
     * @param messageTemplate 消息模板
     * @return
     */
    public static Map<String, Object> sendTemplateMessage(String accessToken, MessageTemplate messageTemplate) {
        Map<String, Object> res = new HashMap<String, Object>();
        String result = HttpUtils.doPostJson(WxUtils.send_template_message_url.replace("ACCESS_TOKEN", accessToken),
                JSONObject.toJSON(messageTemplate));
        JSONObject jsonObject = JSON.parseObject(result);
        res.put("errcode", jsonObject.get("errcode"));
        res.put("errmsg", jsonObject.get("errmsg"));
        return res;
    }

    /**
     * 生成带参数的二维码
     *
     * @param accessToken 微信接口访问access_token
     * @param sceneParam  二维码场景参数
     * @param isLimit     是否永久二维码
     * @return
     */
    public static String getParamQrCode(String accessToken, String sceneParam, Boolean isLimit) {
        // 封装参数
        JSONObject params = new JSONObject();
        if (isLimit) {
            // 永久二维码
            params.put("action_name", "QR_LIMIT_STR_SCENE");
        } else {
            // 临时二维码
            params.put("action_name", "QR_STR_SCENE");
            params.put("expire_seconds", 30 * 24 * 60 * 60);// 单位秒，有效期30天：30*24*60*60

        }
        JSONObject scene_str = new JSONObject();
        scene_str.put("scene_str", sceneParam);
        JSONObject scene = new JSONObject();
        scene.put("scene", scene_str);
        params.put("action_info", scene);

        Object params_json = JSONObject.toJSON(params);
        String ticket_url = qrcode_ticket_url.replace("TOKEN", accessToken);
        logger.info("生成带参数的二维码，请求url：{}", ticket_url);
        logger.info("生成带参数的二维码，请求参数：{}", params_json);
        //
        String response = HttpUtils.doPostJson(ticket_url, params_json);
        logger.info("生成带参数的二维码，响应内容：{}", response);

        JSONObject jsonObject = JSON.parseObject(response);
        String ticket = (String) jsonObject.get("ticket");
        String qrCodeUrl = qrcode_url.replace("TICKET", ticket);

        return qrCodeUrl;
    }

    /**
     * 发送微信模板消息
     * @param template
     */
    public static void sendMessageByTemplateVO(String accessToken, MessageTemplate template){
        if(StringUtils.isEmpty(template.getTemplate_id()) || StringUtils.isEmpty(template.getTouser())){
            return;
        }
        // 封装数据
        JSONObject jsonObject = new JSONObject();
        // first
        jsonObject.put("first", setKeyWord(template.getFirst(),null));
        jsonObject.put("keyword1", setKeyWord(template.getKeyword1(),"#545454"));
        jsonObject.put("keyword2", setKeyWord(template.getKeyword2(),"#545454"));
        //选传字段
        if(StringUtils.isNotEmpty(template.getKeyword3())){
            jsonObject.put("keyword3", setKeyWord(template.getKeyword3(),"#545454"));
        }
        if(StringUtils.isNotEmpty(template.getKeyword4())){
            jsonObject.put("keyword4", setKeyWord(template.getKeyword4(),"#545454"));
        }
        if(StringUtils.isNotEmpty(template.getKeyword5())){
            jsonObject.put("keyword5", setKeyWord(template.getKeyword5(),"#545454"));
        }
        // remark
        jsonObject.put("remark", setKeyWord(template.getRemark(),"#00008B"));
        if(StringUtils.isNotEmpty(template.getUrl())){
            //跳转链接
            template.setUrl(template.getUrl());
        }
        template.setData(jsonObject);
        // 发送消息
        try {
            Map<String, Object> res = sendTemplateMessage(accessToken, template);
            if (!res.get("errcode").equals(0)) {
                logger.error("消息推送失败：errcode：{}，errmsg：{}",
                        res.get("errcode").toString(), res.get("errmsg").toString());
            }
        } catch (Exception e) {
            logger.error("消息推送失败：" + e.getMessage());
        }
    }


    /**
     * 设置微信模板消息keyWord
     * @param value    keyWord内容
     * @param colour        颜色
     * @return      JSONObject对象
     */
    private static JSONObject setKeyWord(String value, String colour){
        JSONObject keyword = new JSONObject();
        keyword.put("value", value);
        if(StringUtils.isNotEmpty(colour)){
            keyword.put("color", colour);
        }
        return keyword;
    }
}
