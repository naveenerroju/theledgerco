package com.ledger.service;

import com.ledger.utils.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileImpl implements ReadFile {

    /**
     * Reads the specified file from the path.
     *
     * @param path path to read file from.
     * @return File Content in String format
     */
    @Override
    public String readFile(String path) {
        return readFileFromPath(path);
    }

    private String readFileFromPath(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            Utility.logError("Error reading file", e);
        }
        return content.toString();
    }
}
