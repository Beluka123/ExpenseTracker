package org.project.utils;

public class Help {

    public static void help(String type){
        switch (type){
            case "start" -> System.err.println("expense-tracker <-h or -help>");
            case "add" -> System.err.println("usage: expense-tracker add --description <value> --amount <value>");
            case "delete" -> System.err.println("usage: expense-tracker delete --id <id>");
            case "summary" -> System.err.println("usage: expense-tracker summary [<--month> <num_of_month>]");
            case "help" -> {
                System.err.printf("%-10s: <key> - necessary key, [key] - unnecessary key\n", "keys");
                System.err.printf("%-10s: expense-tracker add --description <value> --amount <value>\n", "add");
                System.err.printf("%-10s: expense-tracker delete --id <id>\n", "delete");
                System.err.printf("%-10s: expense-tracker summary [<--month> <num_of_month>]\n", "summary");
                System.err.printf("%-10s: expense-tracker list\n", "list");
            }
        }
    }

}
