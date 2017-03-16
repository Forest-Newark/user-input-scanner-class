package com.theironyard;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //Instantiate objects
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(Pattern.compile("(\\n)|;"));

        ConversionService conversionService = new ConversionService();
        MenuService menuService = new MenuService(scanner);

        //Get and compute user input
        double weight = menuService.promptForWeight();
        Weight from = menuService.promptForFromUnit(conversionService.listUnits());
        Weight to = menuService.promptForToUnit(conversionService.listUnits());
        double conversion = conversionService.convert(weight, from, to);

        menuService.printAnswer(weight, from, conversion, to);


    }

}
