package com.ledger;

import com.ledger.service.ReadFileImpl;
import com.ledger.utils.Utility;

public class App {
    private static final String FILE_LOCATION = "src/main/resources/ledger_1.txt";

    public static void main(String[] args) {
        ReadFileImpl readFile = new ReadFileImpl();
        String fileContent = readFile.readFile(FILE_LOCATION);
        Utility.logInfo(fileContent);
    }

}