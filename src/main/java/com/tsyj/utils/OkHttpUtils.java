package com.tsyj.utils;

import com.squareup.okhttp.*;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/**
 * @description: okHttp工具类
 * @author: guos
 * @date: 2018/6/23
 */
public class OkHttpUtils {

    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient innerClient;

    public OkHttpUtils() {
    }

    public static void setSSLContext(SSLContext sslContext) {
        getOkHttpClient().setSslSocketFactory(sslContext.getSocketFactory());
    }

    public static synchronized OkHttpClient getOkHttpClient() {
        if (innerClient == null) {
            innerClient = new OkHttpClient();
        }
        return innerClient;
    }

    /**
     * get
     *
     * @param
     * @author caiLinFeng
     * @date 2018年10月9日
     */
    public static OkHttpUtils.ResponseWrapper get(String url) {
        Request request = (new Request.Builder()).url(url).build();
        return execute(request);
    }

    /**
     * get加请求头
     *
     * @param
     * @author caiLinFeng
     * @date 2018年10月9日
     */
    public static OkHttpUtils.ResponseWrapper get(String url, Map<String, String> headers) {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null && !headers.isEmpty()) {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                builder.addHeader(key, headers.get(key));
            }
        }
        return execute(builder.build());
    }

    /**
     * post
     *
     * @param
     * @author caiLinFeng
     * @date 2018年10月9日
     */
    public static OkHttpUtils.ResponseWrapper postJson(String url, String jsonBody) {
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, jsonBody);
        Request request = (new Request.Builder()).url(url).post(body).build();
        return execute(request);
    }

    /**
     * post加请求头
     *
     * @param
     * @author caiLinFeng
     * @date 2018年10月9日
     */
    public static OkHttpUtils.ResponseWrapper postJson(String url, String jsonBody, Map<String, String> headers) {
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, jsonBody);
        Request.Builder builder = new Request.Builder().url(url).post(body);
        if (headers != null && !headers.isEmpty()) {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                builder.addHeader(key, headers.get(key));
            }
        }
        return execute(builder.build());
    }

    private static OkHttpUtils.ResponseWrapper execute(Request request) {
        try {
            return new OkHttpUtils.ResponseWrapper(getOkHttpClient().newCall(request).execute());
        } catch (IOException var2) {
            return null;
        }
    }

    public static OkHttpUtils.ResponseWrapper delete(String url) {
        Request request = (new Request.Builder()).url(url).delete().build();
        return execute(request);
    }

    public static class ResponseWrapper {
        private Response response;

        ResponseWrapper(Response response) {
            this.response = response;
        }

        public boolean isSuccessful() {
            return this.response.isSuccessful();
        }

        public InputStream asStream() {
            if (!this.isSuccessful()) {
                return null;
            } else {
                try {
                    return this.response.body().byteStream();
                } catch (IOException var2) {
                    var2.printStackTrace();
                    return null;
                }
            }
        }

        public Response getResponse() {
            return this.response;
        }
    }
}