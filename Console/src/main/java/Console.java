import java.util.Scanner;

public class Console {
    public static int readInt(String msg) {

        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        int parsedInt = Integer.MIN_VALUE;

        while (!isValid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedInt = Integer.parseInt(userInput);
                isValid = true;

            } catch (NumberFormatException ex) {

            }

        }
        return parsedInt;
    }


    public static void print(String pmsg) {
        System.out.println(pmsg);
    }

    public static int readInt(String msg, int min, int max) {

        int parsedInt = readInt(msg);
        while (parsedInt >= max || parsedInt <= min) {
            parsedInt = readInt(msg);
        }
        return parsedInt;
    }

    public static double readDouble(String msg) {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        double parsedDouble = Double.MIN_VALUE;

        while (!isValid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedDouble = Double.parseDouble(userInput);
                isValid = true;

            } catch (NumberFormatException ex) {

            }

        }
        return parsedDouble;
    }

    public static double readDouble(String msg, double min, double max) {

        double parsedDub = readDouble(msg);
        while (parsedDub >= max || parsedDub <= min) {
            parsedDub = readDouble(msg);
        }
        return parsedDub;
    }


}
