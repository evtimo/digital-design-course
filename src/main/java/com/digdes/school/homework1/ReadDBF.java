package com.digdes.school.homework1;

import com.linuxense.javadbf.*;

import java.io.*;

public class ReadDBF {

    public static String readFile(String fileName) {
        DBFReader reader = null;
        String output = "";
        try {

            // create a DBFReader object
            if (fileName.equals("")) fileName = "src/main/resources/test.dbf";
            reader = new DBFReader(new FileInputStream(fileName));

            // get the field count if you want for some reasons like the following
            int numberOfFields = reader.getFieldCount();

            // use this count to fetch all field information
            for (int i = 0; i < numberOfFields; i++) {
                DBFField field = reader.getField(i);
            }

            // start reading the rows
            DBFRow row;
            while ((row = reader.nextRow()) != null) {
                output = row.getString("NAME");
            }

        } catch (DBFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DBFUtils.close(reader);
        }

        return output;
    }

    public static void main(String[] args) {
        //System.out.println("input params: " + args + " " + System.getProperty("user.dir"));
        System.out.println(readFile(""));

    }

}
