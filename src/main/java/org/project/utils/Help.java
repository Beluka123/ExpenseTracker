package org.project.utils;

public class Help {

    public static void help(String type){
        switch (type){
            case "start" -> System.err.println("expense-tracker <-h or -help>");
            case "add" -> System.err.println("usage: expense-tracker add --description <value> --amount <value>");
            case "delete" -> System.err.println("usage: expense-tracker delete --id <id>");
        }
    }

}
