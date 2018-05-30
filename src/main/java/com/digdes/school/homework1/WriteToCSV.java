package com.digdes.school.homework1;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;

public class WriteToCSV {

    private static void WriteDBF(ArrayList<String[]> output, String filePath) {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(filePath));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
            for (String[] s : output) {
                csvWriter.writeNext(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convert(String[] args) {
     //public static void main(String[] args) throws IOException {

        final String filePath = "src/main/resources/out.csv";

        if (args.length == 0) {
            WriteDBF(ReadDBF.readFile(""), filePath );
        }
        else
        {
            WriteDBF(ReadDBF.readFile(args[0]), args[1]);
        }
    }

}
