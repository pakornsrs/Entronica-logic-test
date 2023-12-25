import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Invoice;

public class App {
    public static void main(String[] args) throws Exception {
        // question 1
		int[] arr1 = {1,2,3};
		int[] arr2 = {5,4,-3};
		var ans1 = GetIntersection(arr1,arr2);
        System.out.println("\nQuestion 1 Answer :");
		System.out.println(ans1);

        // question 2
        int[] arr = {5,3,7,13,-5,6,9,17,4,0,1};
        var ans2 = SortNumber(arr);
        System.out.println("\nQuestion 2 Answer :");
		System.out.println(Arrays.toString(ans2));

        // question 3
        int[] input = {1,2,3,4,5};
        int target = 5;
        var ans3 = Sum(input,target);
        System.out.println("\nQuestion 3 Answer :");
        ans3.forEach(pair -> System.out.println(Arrays.toString(pair)));

        // question 4
        var invoices = GetInvoiceMocking();
        var ans4 = VerifyInvoiceOverDate(invoices);
        System.out.println("\nQuestion 4 Answer :");
        ans4.forEach(invoice -> System.out.println(invoice.toJson()));
    }

    // Question1
    public static ArrayList<Integer> GetIntersection(int[] arr1, int[] arr2){

		var result = new ArrayList<Integer>();
		try{

			for(int i = 0; i < arr1.length; i++){
				for(int j = 0; j < arr2.length; j++){
					
					if(arr2[j] == arr1[i]){
						result.add(arr2[j]);
					}
				}
			}
		}
		catch(Exception ex){
			return result;
		}

		return result;
	}

    // Question2 : bubble sort
    public static int[] SortNumber(int[] arr){
		
        // validate in put
        if(arr.length == 0){
            return arr;
        }

        try{
             
            for(int i = 0; i< arr.length; i++){

                for(int j =0; j < arr.length - 1; j++){
                    
                    if(arr[j] > arr[j+1]){
                        // swap
                        var temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
        catch(Exception ex){

        }

        return arr;
		
	}

    // Question3
    public static ArrayList<int[]> Sum(int[] arr, int target){
        
        var result = new ArrayList<int[]>();

        try{
            
            for(int i = 0; i < arr.length; i++){

                for(int j = 0; j < arr.length; j++){

                    if(j == i) continue;

                    if(arr[i] + arr[j] == target){
                        int[] pair = {arr[i], arr[j]};
                        result.add(pair);
                    }

                }
            }

            return result;

        }
        catch(Exception ex){
            return result;
        }

    }

    // Question4
    public static ArrayList<Invoice> GetInvoiceMocking(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        var Invoices = new ArrayList<Invoice>();

        // Not over due date.
        Invoices.add(new Invoice(1, 100, LocalDate.parse("2023-12-31", formatter), null));
        // Over due date.
        Invoices.add(new Invoice(2, 200, LocalDate.parse("2023-12-01", formatter), null));
        // Paid not over due date.
        Invoices.add(new Invoice(3, 150, LocalDate.parse("2023-04-30", formatter), LocalDate.parse("2023-04-22", formatter)));
        // Paid over due date.
        Invoices.add(new Invoice(4, 300, LocalDate.parse("2023-04-01", formatter), LocalDate.parse("2023-04-30", formatter)));

        return Invoices;
    }

    public static ArrayList<Invoice> VerifyInvoiceOverDate(ArrayList<Invoice> invoices){

        var result = new ArrayList<Invoice>();

        try{

            // validate
            if(invoices == null || invoices.size() == 0) return result;

            LocalDate currentDate = LocalDate.now();

            for(int i = 0; i < invoices.size(); i++){

                var dueDate = invoices.get(i).getDueDate();

                if(invoices.get(i).getPaidDate() == null){
                    
                    if(dueDate.compareTo(currentDate) < 0){
                        // over due date
                        result.add(invoices.get(i));
                    }
                }
                else{

                    var paidDate = invoices.get(i).getPaidDate();

                    if(dueDate.compareTo(paidDate) < 0){
                        // Already paid but over date
                        result.add(invoices.get(i));
                    }
                }
            }

            return result;
        }
        catch(Exception ex){
            return result;
        }
    }

}
