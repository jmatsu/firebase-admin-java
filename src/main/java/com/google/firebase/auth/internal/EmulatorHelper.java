package com.google.firebase.auth.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.firebase.internal.Nullable;

public final class EmulatorHelper {

  private EmulatorHelper() {
  }

  @VisibleForTesting
  public static final String FIREBASE_AUTH_EMULATOR_HOST_ENV_VAR =
      "FIREBASE_AUTH_EMULATOR_HOST";

  @Nullable
  public static String getEmulatorHost() {
    return System.getenv(FIREBASE_AUTH_EMULATOR_HOST_ENV_VAR);
  }

  public static boolean useEmulator() {
    return !Strings.isNullOrEmpty(getEmulatorHost());
  }
}
