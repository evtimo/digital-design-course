package com.digdes.school;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testOutput() throws Exception {

        //Check, that Main method prints HelloWorld
        TestHelper.captureOutput(new CaptureTest() {
            @Override
            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
                Main.main(new String[0]);
                assertEquals("Hello World\n", outContent.toString());
            }
        });
    }
}