import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>collectItems= Arrays.stream(scanner.nextLine().split("\\, "))
        .collect(Collectors.toList());
        String command=scanner.nextLine();
        while (!command.equals("Craft!")){
            String [] tokens=command.split(" - ");
            String input=tokens[0];
            String items=tokens[1];
            if (input.equals("Collect")){
                if (!collectItems.contains(items)){
                 collectItems.add(items);
                }
            }else if (input.equals("Drop")){
                if (collectItems.contains(items)){
                    collectItems.remove(items);
                }
            }else if (input.equals("Combine Items")){
                String[] oldItem=items.split(":");
                String old=oldItem[0];
                String newItem=oldItem[1];
               int  index = collectItems.indexOf(old);
                if (index>=0) {
                    collectItems.add(index + 1, newItem);
                }
            }else if (input.equals("Renew")){
                if (collectItems.contains(items)) {
                    int index =collectItems.indexOf(items);
                    collectItems.add(items);
                    collectItems.remove(index);

                }
            }
            command=scanner.nextLine();
        }
        System.out.print(String.join(", ",collectItems));
       
    }
}
