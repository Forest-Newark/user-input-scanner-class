package com.theironyard;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The MenuService class is used to prompt users for data and to collect that
 * input. It is also responsible for validating that input. For example, if we
 * prompt the user for a number, we must reject the value 'Fred' and prompt the
 * user again until they enter a valid number. The MenuService has methods that
 * encapsulate all of this logic. This means that we can invoke, for example,
 * the promptForWeight() method and know that we will get a double back, not a
 * String and not an error.
 * <p>
 * Follow the instructions below to implement each of these methods.
 */
public class MenuService {

    private static Scanner input;


    /**
     * Create a constructor that receives an instance of Scanner and sets it
     * into the private Scanner property created above.
     * <p>
     * You may be wondering why we're passing Scanner into this class when we
     * could have simply created a new instance here. This is an example of a
     * pattern called Dependency Injection. This MenuService class depends on
     * the Scanner class and can't work without it. However, if it knows how to
     * create an instance of Scanner it also has to know some details about
     * other parts of the system that may be irrelevant. For example, System.in.
     * <p>
     * Also, by passing in the Scanner when the MenuService is instantiated, we
     * have the option to pass in other types of Scanners that are configured in
     * different ways. For example, all of the tests written for the MenuService
     * have Scanner configured with a different InputStream than stdin. That
     * allows our tests to automate input and confirm that the results are what
     * we expect.
     *
     * @param scanner An instance of Scanner.
     */
    // todo: create MenuService constructor
    public MenuService(Scanner scanner) {
        input = scanner;
    }


    /**
     * Create a method named promptForWeight(). It should accept no arguments
     * and return a double value. The double value is, of course, the value the
     * user inputs on the command line.
     * <p>
     * This method must take into account that users are finicky beasts that may
     * not follow instructions. Users might enter values that are not numbers.
     * <p>
     * Follow the instructions in the following comments to complete this method
     * correctly.
     *
     * @return a double value which is a weight.
     */
    public double promptForWeight() {
        System.out.println("Enter a weight: ");
        if (input.hasNextDouble()) {
            return input.nextDouble();
        }
        else {
            String badInput = input.nextLine();
            System.out.println(badInput + " is not a number");
            return promptForWeight();
        }
    }


    /**
     * Create a method called promptForFromUnit(). This method accepts an
     * ArrayList of String units and returns a valid Weight enum value that the
     * user selects.
     * <p>
     * This method's name leaves something to be desired, but is intended to
     * prompt the user for the unit they want to convert their weight value
     * from. These values are provided by the argument, shown in the prompt, and
     * are also used to validate that the user provided a valid data.
     * <p>
     * Follow the instructions below to build out this method.
     *
     * @param units An ArrayList of String values that are valid units
     * @return A Weight enum value corresponding to the user's selected unit
     */
    // todo: implement promptForFromUnit() method
    public Weight promptForFromUnit(ArrayList<String> units) {
        System.out.println("Select the unit to convert from " + units + ": ");
        String weightInput = input.next();
        if (!units.contains(weightInput)) {
            System.out.println("Please choose a valid unit to convert from.");
            return promptForFromUnit(units);
        } else {
            return Weight.valueOf(weightInput.toUpperCase());

        }
    }


    /**
     * Create a method named promptForToUnit(). This method works exactly the
     * same as the promptForFromUnit() method, except that its prompts read:
     * <p>
     * "Select the unit to convert from [gram, pound, stone]: "
     * <p>
     * In the example above, the units listed are driven based on the provided
     * ArrayList of Strings.
     * <p>
     * If the user makes an invalid selection the error message reads:
     * <p>
     * "Please choose a valid unit to convert to."
     * <p>
     * Other than that, this method is the same as promptForFromUnit().
     *
     * @param units A List of String values that are valid units
     * @return A Weight enum value corresponding to the user's selected unit
     */
    // todo: implement promptForToUnit() method
    public Weight promptForToUnit(ArrayList<String> units) {
        System.out.println("Select the unit to convert to " + units + ": ");
        String weightInput = input.next();
        if (!units.contains(weightInput)) {
            System.out.println("Please choose a valid unit to convert to.");
            return promptForToUnit(units);
        } else {
            return Weight.valueOf(weightInput.toUpperCase());
        }

    }


    /**
     * Create a method named printAnswer(). It should accept arguments for the
     * weight to convert, the unit being converted from, the unit being
     * converted to, and the converted value. It returns nothing.
     * <p>
     * When invoked, this method prints a message like this:
     * <p>
     * "ABC in Xs is XYZ in Qs"
     * <p>
     * Where ABC is the weight being converted, X is the unit being converted
     * from, XYZ is the converted value, and Q is the unit converted to. Here's
     * a real example:
     * <p>
     * "321.0 pounds is 145603.15077 grams"
     * <p>
     * Pay attention to plurals, but don't worry about singulars. In other
     * words, it's ok to always write pounds, even "1 pounds".
     * <p>
     * The output must be followed by a single newline character.
     *
     * @param number    The weight being converted
     * @param from      The unit being converted from
     * @param converted The converted value
     * @param to        The unit of the converted value
     */
    // todo: implement printAnswer() method
    public void printAnswer(double number, Weight from, double converted, Weight to) {
       System.out.printf("%s %ss is %s %ss",
               number,
               from.toString().toLowerCase(),
               converted,
               to.toString().toLowerCase()
               );
    }

}
