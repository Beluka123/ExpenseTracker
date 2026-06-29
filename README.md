# ExpenseTracker
___
## Description
___

__ExpenseTracker__ is a Java-based command-line tool designed to help users efficiently track their expenses, with the project concept inspired by [ExpenseTracker](https://roadmap.sh/projects/expense-tracker). 

## Features
___
- Users can add an expense with a description and amount.
- Users can update an expense.
- Users can delete an expense.
- Users can view all expenses.
- Users can view a summary of all expenses.
- Users can view a summary of expenses for a specific month (of current year).

## Requirements
___
- JDK 25.
- Git

## Installation
___
Clone repository and navigate to the directory `ExpenseTracker/`
```shell
git clone https://github.com/Beluka123/ExpenseTracker.git
cd ExpenseTracker/  
``` 
## Usage
___
Use `java -jar` command to interact with the cli.
```jshelllanguage
//To add an expense
java -jar ExpenseTracker.jar expense-tracker add --description "Lunch" --amount 20

//To delete an expense
java -jar ExpenseTracker.jar expense-tracker delete --id 2

//To sum all expenses
java -jar ExpenseTracker.jar expense-tracker summary
    
//To sum expenses for the selected month
java -jar ExpenseTracker.jar expense-tracker summary

//To show all expenses
java -jar ExpenseTracker.jar expense-tracker list

//To show help information
java -jar ExpenseTracker.jar expense-tracker -h or -help
```
