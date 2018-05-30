package com.digdes.school.homework1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReadDBFTest {
    @Test
    public void FileInputTest() {
        String name = "Evgeny";
        assertEquals(ReadDBF.readFile(""), name);
    }
}
