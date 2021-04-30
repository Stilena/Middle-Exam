import java.util.*;
import java.util.stream.Collectors;

public class Numbers_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        double sum=0;
        int count=0;
        for (int i = 0; i < numbers.size(); i++) {
            sum+=numbers.get(i);
            count++;
            if (i==numbers.size()-1){
                sum=Math.round(sum/count*100)/100.0;
            }
            }
        List<Integer>newList=new ArrayList<>();


        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i)>sum){
                int num=numbers.get(i);
                newList.add(num);
            }
            Collections.sort(newList);
            Collections.reverse(newList);
        }

        if (newList.size()<2){
            System.out.println("No");
        }
        int countOfMaxNumber=0;
        for (Integer integer : newList) {
            if (countOfMaxNumber==5){
                break;
            }
            if (!(numbers.indexOf(integer) == numbers.size() - 1)) {
                System.out.print(integer + " ");
            } else {
                System.out.print(integer+ " ");
            }
            countOfMaxNumber++;

        }

    }
}
