package com.genspark.task3;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Map;
import static utils.TestUtils.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogProcessorTest {

    @Test
    public void testProcessLogFile() throws IOException {
        File tempFile = File.createTempFile("test-log", ".log");
        //BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("INFO Start application\n");
            writer.write("ERROR Something bad happened [CODE:E001]\n");
            writer.write("ERROR Another error occurred [CODE:E002]\n");
            writer.write("ERROR Something bad happened [CODE:E001]\n");
        }

        LogProcessor processor = new LogProcessor();
        Map<String, Integer> result = processor.processLogFile(tempFile.getAbsolutePath());

      
        yakshaAssert(currentTest(), tempFile.delete(), businessTestFile);
        
    }
}
