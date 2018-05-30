package com.digdes.school.homework1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReadDBFTest {
    @Test
    public void FileInputTest() {
        //Check, that first field in Header is "Name"
        String name = "NAME";
        assertEquals(ReadDBF.readFile("").get(0)[0], name);
    }
}
