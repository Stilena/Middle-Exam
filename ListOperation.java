import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>numbers= Arrays.stream(scanner.nextLine().split("\\s+"))
        .map(Integer::parseInt).collect(Collectors.toList());
        String command=scanner.nextLine();

        while (!command.equals("End")){
            String [] tokens=command.split("\\s+");
            String text=tokens[0];

            if (text.equals("Add")){
                int number=Integer.parseInt(tokens[1]);
                if (numbers.size()<number){
                    System.out.println("Invalid index");
                }
                numbers.add(number);
            }else if (text.equals("Insert")){
                int number=Integer.parseInt(tokens[1]);
                int index=Integer.parseInt(tokens[2]);
                if (numbers.size()<number){
                    System.out.println("Invalid index");
                }
                numbers.add(index,number);
            }else if (text.equals("Remove")){
                int index=Integer.parseInt(tokens[1]);
                if (numbers.size()<index){
                    System.out.println("Invalid index");
                }
                numbers.remove(index);
            }else if (text.equals("Shift left ")){
                int count=Integer.parseInt(tokens[1]);
                for (int i = 0; i <count ; i++) {
                    int firstNum=numbers.get(0);
                    numbers.add(firstNum);
                }
            }else if (text.equals("Shift right ")){
                int count=Integer.parseInt(tokens[1]);
                for (int i = 0; i <count ; i++) {
                 int lastNum=numbers.get(numbers.size()-1);
                 numbers.remove(lastNum);
                numbers.set(0,lastNum);
            }
            }
            command=scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
