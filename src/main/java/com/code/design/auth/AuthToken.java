package com.code.design.auth;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @description:
 * @author: ~teng~
 * @date: 2025/5/25 21:53
 */
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60 * 1000L;

    private static final String SEPARATE = "@";

    private String token;

    private long createTime;

    private long expireTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expireTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expireTimeInterval = expireTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime, Map<String, Object> param) {
        // TODO... 创建AutoToken
        return null;
    }

    public static AuthToken generate(String originalUrl, String appId, long timestamp, String password) {
        String token = generateTokenString(originalUrl, appId, timestamp, password);
        return new AuthToken(token, timestamp);
    }


    public static String generateTokenString(String originalUrl, String appId, long timestamp, String password) {
        StringBuffer sb = new StringBuffer(originalUrl);
        sb.append(SEPARATE).append(appId);
        sb.append(SEPARATE).append(timestamp);
        sb.append(SEPARATE).append(password);
        return DigestUtils.md5DigestAsHex(sb.toString().getBytes(StandardCharsets.UTF_8));
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - createTime > expireTimeInterval;
    }

    public String getToken() {
        return token;
    }

    public boolean match(AuthToken authToken) {
        return authToken != null && authToken.getToken().equals(token);
    }
}
