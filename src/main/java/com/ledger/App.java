package com.ledger;

import com.ledger.service.LedgerEntry;
import com.ledger.service.ReadFileImpl;
import com.ledger.service.ServiceFactory;
import com.ledger.utils.CommandsUtility;
import com.ledger.utils.Utility;

import java.util.List;

public class App {
    private static final String FILE_LOCATION = "src/main/resources/ledger_1.txt";

    public static void main(String[] args) {
        //Reading file
        ReadFileImpl readFile = new ReadFileImpl();
        String fileContent = readFile.readFile(FILE_LOCATION);
        Utility.logInfo(fileContent);

        //Extracting commands from the file content
        List<String> commands = CommandsUtility.getCommands(fileContent);

        for (String command : commands) {
            List<String> operations = CommandsUtility.getOperation(command);

            //Get the appropriate service using service factory
            ServiceFactory factory = new ServiceFactory();
            LedgerEntry service = factory.getService(operations.get(0));

            //Perform the operation
            service.perform(command);
        }

    }

}