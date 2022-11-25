import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class insertion extends wordArray{

    //Array to be sort for every Case
    static String[] bestCaseInsertion;
    static String[] worstCaseInsertion;
    static String[] averageCaseInsertion;


    //Current Directory
    Path currentRelativePath = Paths.get("");
    String currentPathLocation = currentRelativePath.toAbsolutePath().toString();

    //Insertion inheritance constructor
    insertion(){
        averageCaseInsertion=  new String[asciiOnly.length];
        for(int i=0;i<asciiOnly.length;i++)
        {
            averageCaseInsertion[i]=asciiOnly[i];
        }

        bestCaseInsertion= new String[bestCaseArrayWord.length];
        for(int j=0;j<bestCaseArrayWord.length;j++)
        {
            bestCaseInsertion[j]=bestCaseArrayWord[j];
        }
        worstCaseInsertion= new String[worstCaseArrayWord.length];
        for(int k=0;k<worstCaseArrayWord.length;k++)
        {
            worstCaseInsertion[k]=worstCaseArrayWord[k];
        }
    }

    //Printing Ascii Character inside Insertion Class
    public static void printInsertionAscii()
    {
        System.out.println("Inside insertion inheritrance");
        System.out.println("Ascii only length is " + averageCaseInsertion.length);
       for(int i=0;i<100;i++) {
            System.out.println( averageCaseInsertion[i]+"- ");
        }
    }


    //METHODS TO SORT THE ARRAY REGARDLESS BESTCASE, AVERAGE OR WORST CASE
    //RETURNING THE NUMBER OF THE COUNTERS

    public static long insertionSort(String [] arrayToBeSort, int arrayTopMax) {

        int epochBest = 0;

        int i, j;
        String key;
        epochBest+=3;

        for (j = 1; j < arrayTopMax; j++) {
            key = arrayToBeSort[j];
            i = j - 1;
            epochBest+=5;
            while (i >= 0) {
                if (key.compareTo(arrayToBeSort[i]) > 0) {
                    epochBest+=2;
                    break;

                }
                arrayToBeSort[i + 1] = arrayToBeSort[i];
                i--;
                epochBest+=2;
            }

            arrayToBeSort[i + 1] = key;

            epochBest++;
        }
        System.out.println("Number of iterration is "+ epochBest);

        return epochBest;
    }

    //METHOD TO STORE THE SORTED ARRAY INTO TEXT FILE, CALLED ONLY ONCE
    public static void insertionSortToStore(String [] arrayToBeSort, String filePath) {

        int i, j;
        String key;
        for (j = 1; j < arrayToBeSort.length; j++) {
            key = arrayToBeSort[j];
            i = j - 1;
            while (i >= 0) {  //compareToIgmoreCase
                if (key.compareTo(arrayToBeSort[i]) > 0) {
                    break;
                }
                arrayToBeSort[i + 1] = arrayToBeSort[i];
                i--;
            }
            arrayToBeSort[i + 1] = key;
        }

        //Storing the sorted array into the text file
        try {
            Path currentRelativePath = Paths.get("");
            String currentPathLocation = currentRelativePath.toAbsolutePath().toString();
            PrintWriter pr = new PrintWriter(currentPathLocation + "\\src\\insertionSort\\"+filePath+"Insertion.txt");
            for (int y = 0; y < arrayToBeSort.length; y++) {
                pr.println(arrayToBeSort[y]);
            }
            pr.close();
            System.out.println("Done sorted all the words and put in text file");
            System.out.println("Text File Location: "+"\\src\\insertionSort\\"+filePath+"Insertion.txt" );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }

    }



    //This is a function to find the time complexity for the
    public static void bestCase(){
        String bc= "bestCase";

        //insertionSortToStore(bestCaseInsertion, bc);
        long epoch []= new long [10000];
        int numberOfInput [] = new int [10000];
        int store=0;

        for(int i=2;i<bestCaseInsertion.length;i+=4000)
        {
            numberOfInput[store]=i;
            epoch[store] =insertionSort(bestCaseInsertion,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\insertionSort\\caseTimeCompleixity\\"+bc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

        //SORTED THE ARRAY AND STORE IT IN TEXT FILE
        insertionSortToStore(bestCaseInsertion, bc);
    }

    public static void worstCase()
    {
        String wc= "worstCase";
        //insertionSortToStore(worstCaseInsertion, wc);

        long epoch []= new long [10000];
        int numberOfInput [] = new int [10000];
        int store=0;

        for(int i=2;i<worstCaseInsertion.length;i+=4000)
        {
            numberOfInput[store]=i;
            epoch[store] =insertionSort(worstCaseInsertion,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\insertionSort\\caseTimeCompleixity\\"+wc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

        //SORTED THE ARRAY AND STORE IT IN TEXT FILE
        insertionSortToStore(worstCaseInsertion, wc);
    }


    public static void printtestinsertion()
    {
        int iTest;
        for (int i=0;i<100;i++)
        {
            //iTest= worstCaseInsertion.length-1-i;
            System.out.println(worstCaseInsertion[i]);
        }
    }
    public static void testCase(){
        String bc= "testingCase";
        //insertionSort(averageCaseInsertion,bc);

        long epoch []= new long [10000];
        int numberOfInput [] = new int [10000];
        int store=0;

        for(int i=1;i<6000;i+=200)
        {
            numberOfInput[store]=i;
            epoch[store] =insertionSort(worstCaseInsertion,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\insertionSort\\caseTimeCompleixity\\"+bc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);
        //SORTED THE ARRAY AND STORE IT IN TEXT FILE
        insertionSortToStore(worstCaseInsertion, bc);
    }

}
