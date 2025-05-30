package com.code.design.auth;


/**
 * @description:
 * @author: ~teng~
 * @date: 2025/5/25 22:03
 */
public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url) {
        // baseUrl=urlxxx&appId=1001&timestamp=1307788865&token=a78cdef998
        // 根据URL解析出appId, token, createTime, url
        String [] reqArray = url.split("&");
        String baseUrl = reqArray[0].split("=", 2)[1];
        String appId = reqArray[1].split("=",2)[1];
        String token = reqArray[2].split("=", 2)[1];
        long timestamp = Long.parseLong(reqArray[3].split("=", 2)[1]);
        return new ApiRequest(baseUrl, appId, token, timestamp);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAppId() {
        return appId;
    }

    public String getToken() {
        return token;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
