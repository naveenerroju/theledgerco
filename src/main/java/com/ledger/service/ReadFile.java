package com.ledger.service;

@FunctionalInterface
public interface ReadFile {
    /**
     * Reads the specified file from the path.
     * @param path path to read file from.
     * @return File Content in String format
     */
    public String readFile(String path);
}
