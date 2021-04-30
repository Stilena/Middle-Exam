import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Go Shopping!")) {
            String [] tokens = command.split("\\s+");
            String text = tokens[0];
            String item = tokens[1];

            if (text.equals("Urgent")) {
                if (!groceries.contains(item)) {
                    groceries.set(0, item);
                }
            } else if (text.equals("Unnecessary")) {
                if (groceries.contains(item)) {
                    groceries.remove(item);
                }
            } else if (text.equals("Correct")) {

                String newItem = tokens[2];
                if (groceries.contains(item)) {
                    int index = groceries.indexOf(item);
                    // groceries.remove(index);
                    groceries.set(index, newItem);
                }
            } else if (text.equals("Rearrange")) {
                if (groceries.contains(item)) {
                    groceries.remove(item);
                    groceries.add(item);
                }
            }
            command = scanner.nextLine();
        }
        System.out.print(String.join(", ",groceries));
        }
    }
