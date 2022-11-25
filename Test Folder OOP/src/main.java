import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class main {

    public static void main( String [] args)
    {
        //Getting The Current Directory Location
        Path currentRelativePath = Paths.get("");
        String currentPathLocation = currentRelativePath.toAbsolutePath().toString();


        //Creating the arrayClass to store and filter the word in text file

       // insertion xwv = new insertion();

       // xwv.bestCase();
        //xwv.worstCase();
       // xwv.testcase2();

        Scanner sc = new Scanner(System.in);


        //USER INTERFACE

        System.out.println("Which algorithm do you want to access?");
        System.out.println("1 : Insertion Sort");
        System.out.println("2 : Bubble Sort");
        System.out.println("3 : Quick Sort");
        System.out.println("4 : Radix Sort");
        System.out.println("0 : Terminate the Program");
        int input = sc.nextInt();

        while(input<0||input>4)
        {
            System.out.println("Wrong input, key again");
            input = sc.nextInt();
        }

        if( input ==1)
        {
            insertion ist = new insertion();
            System.out.println("What Case Do you want to run?");
            System.out.println("1) Best Case");
            System.out.println("2) Worst Case");
            System.out.println("3) Test Case (DEVELOPER)");
            System.out.println("0 : Terminate the Program");
            int input2 = sc.nextInt();

            while(input2<0||input2>3)
            {
                System.out.println("Wrong input, key again");
                input2 = sc.nextInt();
            }

            if(input2==1)
            {
                System.out.println("Running the bestCase for Insertion Sort");
                ist.bestCase();
            }
            else if(input2==2)
            {
                System.out.println("Running the worstCase for Insertion Sort");
                ist.worstCase();
            }
            else if (input2==3)
            {
                System.out.println("Running the testCase for Insertion Sort");
                ist.testCase();
            }
            else
            {
                System.out.println("Terminating the program");
                return;
            }
        }
        else if(input ==2)
        {
            bubble bub = new bubble();
            System.out.println("What Case Do you want to run?");
            System.out.println("1) Best Case");
            System.out.println("2) Worst Case");
            System.out.println("3) Test Case (DEVELOPER)");
            System.out.println("0 : Terminate the Program");
            int input3 = sc.nextInt();

            while(input3<0||input3>3)
            {
                System.out.println("Wrong input, key again");
                input3 = sc.nextInt();
            }

            if(input3==1)
            {
                System.out.println("Running the bestCase for Bubble Sort");
                bub.bestCase();
            }
            else if(input3==2)
            {
                System.out.println("Running the worstCase for Bubble Sort");
                bub.worstCase();
            }
            else if (input3==3)
            {
                System.out.println("Running the testCase for Bubble Sort");
                bub.testCase();
            }
            else
            {
                System.out.println("Terminating the program");
                return;
            }

        }
        else if(input ==3)
        {
            quickSort srt = new quickSort();
            System.out.println("What Case Do you want to run?");
            System.out.println("1) Best Case");
            System.out.println("2) Worst Case");
            System.out.println("3) Test Case (DEVELOPER)");
            System.out.println("0 : Terminate the Program");
            int input4 = sc.nextInt();

            while(input4<0||input4>3)
            {
                System.out.println("Wrong input, key again");
                input4 = sc.nextInt();
            }

            if(input4==1)
            {
                System.out.println("Running the bestCase for Quick Sort");
                srt.bestCase();
            }
            else if(input4==2)
            {
                System.out.println("Running the worstCase for Quick Sort");
                srt.worstCase();
            }
            else if (input4==3)
            {
                System.out.println("Running the testCase for Quick Sort");
                srt.testCase();
            }
            else
            {
                System.out.println("Terminating the program");
                return;
            }

        }
        else if(input==4){
            radixSort rdx = new radixSort();
            System.out.println("What Case Do you want to run?");
            System.out.println("1) Best Case");
            System.out.println("2) Worst Case");
            System.out.println("3) Test Case (DEVELOPER)");
            System.out.println("0 : Terminate the Program");
            int input5 = sc.nextInt();

            while(input5<0||input5>3)
            {
                System.out.println("Wrong input, key again");
                input5 = sc.nextInt();
            }

            if(input5==1)
            {
                System.out.println("Running the bestCase for Radix Sort");
                rdx.bestCase();
            }
            else if(input5==2)
            {
                System.out.println("Running the worstCase for Radix Sort");
                rdx.worstCase();
            }
            else if (input5==3)
            {
                System.out.println("Running the testCase for Radix Sort");
                rdx.testCase();
            }
            else
            {
                System.out.println("Terminating the program");
                return;
            }

        }
        else if(input==0)
        {
            System.out.println("Terminating the program");
            return;
        }
        else{
            System.out.println("There is some bug");
        }
    }
}
