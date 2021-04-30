import java.util.Scanner;

public class ComputerStore_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double priceWithoutTax=Double.parseDouble(scanner.nextLine());
        String command=scanner.nextLine();
        double sum=priceWithoutTax;
        double sumWithTax=0;
        double totalPrice=0;
        while (!command.equals("special") && !command.equals("regular")){
            double digits=Double.parseDouble(command);
            if (digits>0){
                sum+=digits;
            }else if (digits<0){
                System.out.println("Invalid price!");
            }else if (digits==0){
                System.out.println("Invalid order!");
                break;
            }

            command=scanner.nextLine();
        }
        sumWithTax=sum*0.2;
        totalPrice=sum+sumWithTax;
        if (command.equals("special") ){
            if (totalPrice==0){
                System.out.println("Invalid order!");
                return;
            }
           totalPrice=0.9*totalPrice;
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",sum);
            System.out.printf("Taxes: %.2f$%n",sumWithTax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",totalPrice);
        }else if (command.equals("regular") && totalPrice>0){
            if (totalPrice==0){
            System.out.println("Invalid order!");
            return;
        }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",sum);
            System.out.printf("Taxes: %.2f$%n",sumWithTax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",totalPrice);
        }

    }
}
