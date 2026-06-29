package org.project;

import org.project.utils.Help;


public class Main {
    static void main(String[] args){

        if(args.length < 2 || !args[0].equals("expense-tracker")){
            Help.help("start");
            return;
        }

        switch (args[1]) {
            case "add" -> ExpenseTracker.add(args);
            case "list" -> ExpenseTracker.list();
            case "delete" -> ExpenseTracker.delete(args);
            case "summary" -> ExpenseTracker.summary(args);
            case "-h", "-help" -> Help.help("help");
            default -> Help.help("start");
        }
    }
}
