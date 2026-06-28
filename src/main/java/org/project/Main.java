package org.project;

import org.project.utils.Help;

import java.io.IOException;

public class Main {
    static void main(String[] args) throws IOException {

        if(args.length < 2 || !args[0].equals("expense-tracker")){
            Help.help("start");
            return;
        }

        switch (args[1]) {
            case "add" -> ExpenseTracker.add(args);
            case "list" -> ExpenseTracker.list(args);
            case "delete" -> ExpenseTracker.delete(args);
            case "summary" -> ExpenseTracker.summary(args);
        }
    }
}
