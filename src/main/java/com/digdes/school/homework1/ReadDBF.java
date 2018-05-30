package com.digdes.school.homework1;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class ReadDBF {

    public static ArrayList<String[]> readFile(String filePath) {
        DBFReader reader = null;
        String output = "";
        Object[] rowObjects;

        ArrayList<String[]> stringVector = new ArrayList<>();
        int rowNum = 0;
        try {

            if (filePath.equals("")) filePath = "src/main/resources/test.dbf";

            reader = new DBFReader(new FileInputStream(filePath));

            int numberOfFields = reader.getFieldCount();

            String[] stringArray = new String[numberOfFields];
            for (int i = 0; i < numberOfFields; i++) {
                DBFField field = reader.getField(i);
                stringArray[i] = field.getName().toString();
            }

            stringVector.add(stringArray);

            while ((rowObjects = reader.nextRecord()) != null) {

                stringArray = Arrays.stream(rowObjects)
                        .map(Object::toString)
                        .toArray(String[]::new);
                stringVector.add(stringArray);
            }
        } catch (DBFException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBFUtils.close(reader);
        }

        return stringVector;
    }

    public static void main(String[] args) {
        System.out.println(readFile(""));
    }

}
