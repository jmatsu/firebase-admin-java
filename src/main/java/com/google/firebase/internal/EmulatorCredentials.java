package com.google.firebase.internal;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class EmulatorCredentials extends GoogleCredentials {

    public EmulatorCredentials() {
        super(newToken());
    }

    private static AccessToken newToken() {
        return new AccessToken("owner",
                new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)));
    }

    @Override
    public AccessToken refreshAccessToken() {
        return newToken();
    }

    @Override
    public Map<String, List<String>> getRequestMetadata() throws IOException {
        return ImmutableMap.of();
    }
}