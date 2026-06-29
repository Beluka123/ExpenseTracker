package org.project;

import org.project.models.Expense;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ExpenseStorage {

    private final static ObjectMapper mapper = new ObjectMapper();
    private final static File storage = new File("storage.json");

    static {
        try {
            if(!Files.exists(storage.toPath())){
                Files.createFile(storage.toPath());
                mapper.writeValue(storage, mapper.writerWithDefaultPrettyPrinter().createArrayNode());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void store(String desc, int amount) {

        List<Expense> expenses = mapper.readValue(storage, new TypeReference<>() {});

        int lastId = -1;

        if(!expenses.isEmpty()) lastId = expenses.getLast().getId();

        expenses.add(new Expense(lastId + 1, desc, amount, LocalDate.now()));

        mapper.writerWithDefaultPrettyPrinter().writeValue(storage, expenses);
        System.out.println("successfully added");
    }

    public List<Expense> get(){
        return mapper.readValue(storage, new TypeReference<>() {});
    }

    public void delete(int id){
        List<Expense> expenses = mapper.readValue(storage, new TypeReference<>() {});

        if(expenses.isEmpty() || !expenses.removeIf(e -> e.getId() == id)) {
            System.out.printf("expense with id %d doesn't exist", id);
            return;
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(storage, expenses);
        System.out.println("successfully deleted");
    }

    public void summary(){
        List<Expense> expenses = mapper.readValue(storage, new TypeReference<>() {});

        System.out.println("Total expenses: $" + expenses.stream().mapToInt(Expense::getAmount).sum());
    }

    public void monthSummary(int month){
        List<Expense> expenses = mapper.readValue(storage, new TypeReference<>() {});

        Optional<Expense> expense = expenses.stream().filter(e -> e.getDate().getMonthValue() == month).findAny();

        if(expense.isEmpty()){
            System.out.printf("expense with month %d doesn't exist", month);
            return;
        }

        System.out.printf("Total expenses for %s: $%d\n", expense.get().getDate().getMonth().name(), expense.get().getAmount());
    }
}
