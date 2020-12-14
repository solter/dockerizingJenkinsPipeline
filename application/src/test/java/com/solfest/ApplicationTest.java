package com.solfest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {
  @Test
  public void testReturnString() {
    Application app = new Application();
    assertEquals("Hello World", app.home());
  }

}
