package org.project;

import org.project.utils.Help;

import java.io.IOException;
import java.util.Arrays;

public class ExpenseTracker {

    private final static ExpenseStorage storage = new ExpenseStorage();

    public static void add(String[] args) throws IOException {

        if(args.length < 6){
            Help.help("add");
            return;
        }

        if(Arrays.stream(args).noneMatch(a -> a.equals("--description") || a.equals("--amount"))){
            Help.help("add");
            return;
        }

        if(!args[5].matches("\\d+")){
            Help.help("add");
            return;
        }

        String desc = args[3];
        int amount = Integer.parseInt(args[5]);

        storage.store(desc, amount);

    }

    public static void list(String[] args){

    }

    public static void delete(String[] args){

    }

    public static void summary(String[] args){

    }

}
