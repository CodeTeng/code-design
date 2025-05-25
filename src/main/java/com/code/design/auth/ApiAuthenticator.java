package com.code.design.auth;

/**
 * @description:
 * @author: ~teng~
 * @date: 2025/5/25 22:07
 */
public interface ApiAuthenticator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}
