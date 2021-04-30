import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPeople = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleOnTheCurrentWagon = 0;
        int peopleonTheLyft = 0;
        boolean NoMorePeople = false;

        for (int i = 0; i < wagons.length; i++) {
            while (wagons[i] < 4) {
                wagons[i]++;
                peopleOnTheCurrentWagon++;
                if (peopleonTheLyft + peopleOnTheCurrentWagon == countOfPeople) {
                    NoMorePeople = true;
                    break;
                }
            }
            peopleonTheLyft += peopleOnTheCurrentWagon;
            if (NoMorePeople) {
                break;
            }
            peopleOnTheCurrentWagon = 0;
        }

        if (countOfPeople > peopleonTheLyft) {
            System.out.printf("There isn't enough space! %d people in a queue!%n",countOfPeople-peopleonTheLyft);
            System.out.println(Arrays.toString(wagons));
        } else if (countOfPeople < wagons.length * 4){
            System.out.println("The lift has empty spots!");
            System.out.println(Arrays.toString(wagons)+" " );
        }else if (NoMorePeople){
            System.out.println(Arrays.toString(wagons));
        }
    }
}