import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class bubble extends wordArray{

    //Array to be sort for every Case
    static String[] bestCaseBubble;
    static String[] worstCaseBubble;
    static String[] averageCaseBubble;


    //Current Directory
    Path currentRelativePath = Paths.get("");
    String currentPathLocation = currentRelativePath.toAbsolutePath().toString();

    //bubble  constructor
    bubble(){
        averageCaseBubble=  new String[asciiOnly.length];
        for(int i=0;i<asciiOnly.length;i++)
        {
            averageCaseBubble[i]=asciiOnly[i];
        }

        bestCaseBubble= new String[bestCaseArrayWord.length];
        for(int j=0;j<bestCaseArrayWord.length;j++)
        {
            bestCaseBubble[j]=bestCaseArrayWord[j];
        }
        worstCaseBubble= new String[worstCaseArrayWord.length];
        for(int k=0;k<worstCaseArrayWord.length;k++)
        {
            worstCaseBubble[k]=worstCaseArrayWord[k];
        }

    }

    //Printing Ascii Character inside Bubble Class
    public static void print()
    {
        System.out.println("Inside bubble inheritrance");
        System.out.println("Ascii only length is " + averageCaseBubble.length);
        for(int i=0;i<100;i++) {
            System.out.println( averageCaseBubble[i]+"- ");
        }
    }


    //METHODS TO SORT THE ARRAY REGARDLESS BESTCASE, AVERAGE OR WORST CASE
    public static long bubbleSort(String[] arrayToBeSort, int arrayTopMax)
    {
        long epochBest = 0;
        String temp;
        int n = arrayTopMax;
        boolean swapped;

        epochBest+=4;

        // Sorting strings using bubble sort
        for (int j = 0; j < n - 1; j++)
        {
            swapped=false;
            epochBest+=5;
            for (int i = j + 1; i < n; i++)
            {
                epochBest+=2;
                if (arrayToBeSort[j].compareTo(arrayToBeSort[i]) > 0)
                {
                    temp = arrayToBeSort[j];
                    arrayToBeSort[j] = arrayToBeSort[i];
                    arrayToBeSort[i] = temp;
                    swapped=true;
                    epochBest+=4;
                }
            }
            if(swapped==false)
                break;

        }
        System.out.println("Number of iterration is "+ epochBest);
        return epochBest++;
    }

    //METHOD TO STORE THE SORTED ARRAY INTO TEXT FILE, CALLED ONLY ONCE
    public static void bubbleSortToStore(String [] arrayToBeSort, String filePath) {

        String temp;
        int n = arrayToBeSort.length;

        // Sorting strings using bubble sort
        for (int j = 0; j < n - 1; j++) {
            for (int i = j + 1; i < n; i++) {
                if (arrayToBeSort[j].compareTo(arrayToBeSort[i]) > 0) {
                    temp = arrayToBeSort[j];
                    arrayToBeSort[j] = arrayToBeSort[i];
                    arrayToBeSort[i] = temp;
                }
            }
        }

        //Storing the sorted array into the text file
        try {
            Path currentRelativePath = Paths.get("");
            String currentPathLocation = currentRelativePath.toAbsolutePath().toString();
            PrintWriter pr = new PrintWriter(currentPathLocation + "\\src\\bubbleSort\\"+filePath+"BubbleSort.txt");
            for (int y = 0; y < arrayToBeSort.length; y++) {
                pr.println(arrayToBeSort[y]);
            }
            pr.close();
            System.out.println("Done sorted all the words and put in text file");
            System.out.println("Text File Location: "+"\\src\\bubbleSort\\"+filePath+"BubbleSort.txt" );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }

    }



    public static void bestCase(){
        String bc= "bestCase";
        long epoch []= new long [100000];
        int numberOfInput [] = new int [100000];
        int store=0;

        for(int i=2;i<bestCaseBubble.length;i+=4000)
        {
            numberOfInput[store]=i;
            epoch[store] =bubbleSort(bestCaseBubble,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\bubbleSort\\caseTimeCompleixity\\"+bc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

        //SORTED THE ARRAY AND STORE IT IN TEXT FILE
       // bubbleSortToStore(bestCaseBubble,bc);
    }


    public static void worstCase()
    {
        String wc= "worstCase";
        long epoch []= new long [100000];
        int numberOfInput [] = new int [100000];
        int store=0;

        for(int i=2;i<worstCaseBubble.length;i+=4000)
        {
            numberOfInput[store]=i;
            epoch[store] =bubbleSort(worstCaseBubble,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\bubbleSort\\caseTimeCompleixity\\"+wc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

        //SORTED THE ARRAY AND STORE IT IN TEXT FILE
      //  bubbleSortToStore(worstCaseBubble,wc);
    }

    //Testing
    public static void printtestBubble()
    {
        int iTest;
        for (int i=0;i<100;i++)
        {
            iTest= worstCaseBubble.length-1-i;
            System.out.println(worstCaseBubble[iTest]);
        }
    }
    public static void testCase(){
        String bc= "testingCase";
        long epoch []= new long [100000];
        int numberOfInput [] = new int [100000];
        int store=0;

        for(int i=2;i<40000;i+=5000)
        {
            numberOfInput[store]=i;
            epoch[store] =bubbleSort(worstCaseBubble,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\bubbleSort\\caseTimeCompleixity\\"+bc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

        //SORTED THE ARRAY AND STORE IT IN TEXT FILE
        //bubbleSortToStore(worstCaseBubble,bc);
    }

    public static void testcase2()
    {
        String bc= "testingCase";
        bubbleSortToStore(worstCaseBubble,bc);
    }
}
