import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class quickSort extends wordArray{

    //Array to be sort for every Case
     String[] bestCaseQuickSort;
     String[] worstCaseQuickSort;
     String[] averageCaseQuickSort;

    //Current Directory
    Path currentRelativePath = Paths.get("");
    String currentPathLocation = currentRelativePath.toAbsolutePath().toString();

    //Insertion inheritance constructor
    quickSort(){
        averageCaseQuickSort  =new String[asciiOnly.length];
        for(int i=0;i<asciiOnly.length;i++)
        {
            averageCaseQuickSort[i]=asciiOnly[i];
        }

        bestCaseQuickSort= new String[bestCaseArrayWord.length];
        for(int j=0;j<bestCaseArrayWord.length;j++)
        {
            bestCaseQuickSort[j]=bestCaseArrayWord[j];
        }
        worstCaseQuickSort= new String[worstCaseArrayWord.length];
        for(int k=0;k<worstCaseQuickSort.length;k++)
        {
            worstCaseQuickSort[k]=worstCaseArrayWord[k];
        }
    }

    private String names[];
    private int length;

    public long quickSortBuffer(String [] arrayToBeSort, int arrayTopMax)
    {
        long epochBest=0;
        String arrayWithTopBoundaries[]= new String[arrayTopMax];
        for(int k=0;k<arrayTopMax;k++)
        {
            arrayWithTopBoundaries[k]=arrayToBeSort[k];
        }

         epochBest = sort(arrayWithTopBoundaries);
        return epochBest;
    }

    public long sort(String array[]) {
        long epoch = 0;
        if (array == null || array.length == 0) {
            return 0;
        }
        this.names = array;
        this.length = array.length;
        long iter = quickSort(0, length - 1, epoch);
        return iter;
    }


    private long quickSort(int lowerIndex, int higherIndex, long epoch) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.names[lowerIndex + (higherIndex - lowerIndex) / 2];

        long start = System.currentTimeMillis();

        while (i <= j) {


            while (this.names[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.names[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
                //Counter placement is to change
                //Put where you thought would be suitable
                epoch++;
            }
        }

        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j, epoch);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex, epoch);
        }

        return epoch;
    }

    private void exchangeNames(int i, int j) {
        String temp = this.names[i];
        this.names[i] = this.names[j];
        this.names[j] = temp;
    }


    //Printing Ascii Character inside Quick Class
    public void printquick()
    {
        System.out.println("Inside insertion inheritrance");
        System.out.println("Ascii only length is " + averageCaseQuickSort.length);
        for(int i=0;i<100;i++) {
            System.out.println( averageCaseQuickSort[i]+"- ");
        }
    }

    public  void bestCase(){
        String bc= "bestCase";

        long epoch[] = new long [100000];
        int numberOfInput []= new int [100000];

        int store= 0;

        for (int i =2;i<bestCaseQuickSort.length;i+=500)
        {
            numberOfInput[store]=i;
            epoch[store] =quickSortBuffer(bestCaseQuickSort,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame = ("\\src\\quickSort\\caseTimeCompleixity\\"+bc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);
    }

    public  void worstCase()
    {
        String wc= "worstCase";

        long epoch[] = new long [100000];
        int numberOfInput []= new int [100000];

        int store= 0;

        for (int i =2;i<worstCaseQuickSort.length;i+=500)
        {
            numberOfInput[store]=i;
            epoch[store] =quickSortBuffer(worstCaseQuickSort,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame = ("\\src\\quickSort\\caseTimeCompleixity\\"+wc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);
    }

    //Testing
    public void printtest()
    {
        int iTest;
        for (int i=0;i<100;i++)
        {
            System.out.println(worstCaseQuickSort[i]);
        }
    }
    public void testCase(){
        String bc= "testingCase";


        long epoch[] = new long [100000];
        int numberOfInput []= new int [100000];

        int store= 0;

        for (int i =2;i<bestCaseQuickSort.length;i+=500)
        {
            numberOfInput[store]=i;
            epoch[store] =quickSortBuffer(bestCaseQuickSort,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame = ("\\src\\quickSort\\caseTimeCompleixity\\"+bc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

    }
}
