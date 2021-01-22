package com.google.firebase.auth.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.testing.TestUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EmulatorHelperTest {
  private static final String TEST_EMULATOR_HOST = "localhost:9000";

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testGetEmulatorHost() {
    TestUtils.setEnvironmentVariables(
        ImmutableMap.of(EmulatorHelper.FIREBASE_AUTH_EMULATOR_HOST_ENV_VAR, TEST_EMULATOR_HOST));
    try {
      assertEquals(TEST_EMULATOR_HOST, EmulatorHelper.getEmulatorHost());
    } finally {
      TestUtils.unsetEnvironmentVariables(
          ImmutableSet.of(EmulatorHelper.FIREBASE_AUTH_EMULATOR_HOST_ENV_VAR));
    }
  }

  @Test
  public void testUseEmulator() {
    assertFalse(EmulatorHelper.useEmulator());
  }

  @Test
  public void testUseEmulatorWhenEnvIsSet() {
    TestUtils.setEnvironmentVariables(
        ImmutableMap.of(EmulatorHelper.FIREBASE_AUTH_EMULATOR_HOST_ENV_VAR, TEST_EMULATOR_HOST));
    try {
      assertTrue(EmulatorHelper.useEmulator());
    } finally {
      TestUtils.unsetEnvironmentVariables(
          ImmutableSet.of(EmulatorHelper.FIREBASE_AUTH_EMULATOR_HOST_ENV_VAR));
    }
  }
}