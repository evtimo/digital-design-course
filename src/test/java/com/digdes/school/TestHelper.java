package com.digdes.school;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestHelper {

    //Helps to test System Output in Main class
    public static void captureOutput( CaptureTest test ) throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        test.test( outContent, errContent );

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.out)));

    }
}

abstract class CaptureTest {
    public abstract void test( ByteArrayOutputStream outContent, ByteArrayOutputStream errContent ) throws Exception;
}