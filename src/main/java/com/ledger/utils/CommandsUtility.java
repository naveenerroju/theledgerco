package com.ledger.utils;

import java.util.Arrays;
import java.util.List;

public class CommandsUtility {

    private CommandsUtility(){}

    public static List<String> getCommands(String fileContent) {
        return Arrays.stream(fileContent.split("\n")).toList();
    }

    public static List<String> getOperation(String command){
        return Arrays.stream(command.split(" ")).toList();
    }
}
