package com.oracledb;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferDemo {
    public static void main(String[] args) {
        // Path of the input file
        String inputFile = "src/main/resources/input.txt";

        // Using FileChannel to read data from the file
        try (
                // Create a FileInputStream for the input file
                FileInputStream fis = new FileInputStream(inputFile);

                // Get the channel from the FileInputStream
                FileChannel fileChannel = fis.getChannel()
        ) {
            // Create a ByteBuffer with a capacity of 1024 bytes
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read data from the file into the buffer
            while (fileChannel.read(buffer) != -1) {
                buffer.flip(); // Change the buffer mode to read

                // Process the data in the buffer
                while (buffer.hasRemaining()) {
                    // Read and process each byte
                    System.out.print((char) buffer.get());
                }

                buffer.clear(); // Reset the buffer for the next read operation
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

