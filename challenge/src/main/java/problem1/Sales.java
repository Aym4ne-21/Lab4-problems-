package problem1;
import java.util.Scanner;
public class Sales
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of salespersons : ");
        int salespeople = scan.nextInt();

        if (salespeople <= 0) {
            System.out.println("The number of salespersons must be positive.");
            scan.close();
            return;
        }

        int[] sales = new int[salespeople];
        int sum;
        for (int i=0; i<sales.length; i++)
        {
            System.out.print("Enter sales for salesperson " + (i+1) + ": ");
            sales[i] = scan.nextInt();
        }
        System.out.println("\nSalesperson Sales");
        System.out.println("--------------------");
        sum = 0;

        int max_sale = sales[0] ;
        int max_sale_id = 0;

        int min_sale = sales[0];
        int min_sale_id = 0 ;
        for (int i=0; i<sales.length; i++)
        {
            System.out.println(" " +(i+1) + " " + sales[i]);
            sum += sales[i];
            if(max_sale < sales[i]){
                max_sale = sales[i];
                max_sale_id = i ;
            }

            if(min_sale > sales[i]){
                min_sale = sales[i];
                min_sale_id = i ;
            }
        }
        System.out.println("\nTotal sales: " + sum);

        System.out.println("\nAverage sales : " +  (double)  sum / sales.length);

        System.out.println("\nSalesperson " + (max_sale_id+1) + " had the highest sales with $" + max_sale );

        System.out.println("\nSalesperson " + (min_sale_id+1) + " had the minimum sales with $" + min_sale );


        int threshold ;
        int counter = 0 ;
        System.out.print("\nEnter a value : ");
        threshold = scan.nextInt();

        System.out.println("\nSalesperson who exceeded "+ threshold + " :");
        System.out.println("--------------------");
        for(int i = 0 ; i < salespeople ; i++){
            if(sales[i] > threshold){
                System.out.println(" " + (i+1)+ " " + sales[i]);
                counter++;
            }
        }

        System.out.println("\nTotal number of salespeople whose sales exceeded "+ counter);


    }
}