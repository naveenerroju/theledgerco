package com.ledger;

import com.ledger.repository.LoanRepositoryImpl;
import com.ledger.service.LedgerEntry;
import com.ledger.service.ReadFileImpl;
import com.ledger.service.ServiceFactory;
import com.ledger.utils.CommandsUtility;

import java.util.List;

/**
 * @author Naveen Kumar
 * @author naveenkumarerroju@gmail.com
 * <p>The Ledger Co., a marketplace for banks to lend money to borrowers and receive payments for the loans.</p>
 * <p>This is an exercise in GeekTrust. {@link <a href="https://www.geektrust.com/coding/detailed/the-ledger-co">The Ledger Co</a>"}.</p>
 */
public class App {
    private static final String FILE_LOCATION = "src/main/resources/ledger_1.txt";
    private static final LoanRepositoryImpl loanRepository = new LoanRepositoryImpl();

    public static void main(String[] args) {
        //Reading file
        ReadFileImpl readFile = new ReadFileImpl();
        String fileContent = readFile.readFile(FILE_LOCATION);

        //Extracting commands from the file content
        List<String> commands = CommandsUtility.getCommands(fileContent);

        for (String command : commands) {
            List<String> operations = CommandsUtility.getOperation(command);

            //Get the appropriate service using service factory
            ServiceFactory factory = new ServiceFactory();
            LedgerEntry service = factory.getService(loanRepository, operations.get(0));

            //Perform the operation
            service.perform(command);
        }

    }

}