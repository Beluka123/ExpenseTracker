package org.project;

import org.project.models.Expense;
import org.project.utils.Help;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

    public static void list(){
        List<Expense> expenses = storage.get();

        System.out.printf("%-3s %-15s %-15s %s\n", "ID", "DATE", "DESCRIPTION", "AMOUNT");
        for(Expense expense : expenses){
            System.out.printf("%-3d %-15s %-15s %d\n",
                    expense.getId(),
                    expense.getDate(),
                    expense.getDest(),
                    expense.getAmount());
        }
    }

    public static void delete(String[] args){
        if(args.length < 4){
            Help.help("delete");
            return;
        }

        if(Arrays.stream(args).noneMatch(a -> a.equals("--id"))){
            Help.help("delete");
            return;
        }

        if(!args[3].matches("\\d+")){
            Help.help("delete");
            return;
        }

        storage.delete(Integer.parseInt(args[3]));
    }

    public static void summary(String[] args){

        if(args.length == 2){
            storage.summary();
            return;
        }

        if(args.length == 4){

            if(!args[2].equals("--month") || !args[3].matches("\\d+")){
                Help.help("summary");
                return;
            }

            int month = Integer.parseInt(args[3]);

            if(month > 12 || month < 1){
                System.out.println("month should be in range (1, 12)");
                return;
            }

            storage.monthSummary(month);
            return;
        }

        Help.help("summary");
    }

}
