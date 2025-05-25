package com.code.design.auth;

/**
 * @description:
 * @author: ~teng~
 * @date: 2025/5/25 22:06
 */
public interface CredentialStorage {
    String getPasswordByAppId(String appId);
}
