import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class radixSort extends wordArray{

    //Array to be sort for every Case
    static String[] bestCaseRadix;
    static String[] worstCaseRadix;
    static String[] averageCaseRadix;


    //Current Directory
    Path currentRelativePath = Paths.get("");
    String currentPathLocation = currentRelativePath.toAbsolutePath().toString();

    //Radix inheritance constructor
    radixSort(){
        averageCaseRadix=  new String[asciiOnly.length];
        for(int i=0;i<asciiOnly.length;i++)
        {
            averageCaseRadix[i]=asciiOnly[i];
        }

        bestCaseRadix= new String[bestCaseArrayWord.length];
        for(int j=0;j<bestCaseArrayWord.length;j++)
        {
            bestCaseRadix[j]=bestCaseArrayWord[j];
        }
        worstCaseRadix= new String[worstCaseArrayWord.length];
        for(int k=0;k<worstCaseArrayWord.length;k++)
        {
            worstCaseRadix[k]=worstCaseArrayWord[k];
        }
    }

    public long radixSorting( String[] array, int arrayTopMax)
    {
        String arrayToBeSort[]= new String[arrayTopMax];
        for(int k=0;k<arrayTopMax;k++)
        {
            arrayToBeSort[k]=array[k];
        }

        int epoch =0;
        final int BUCKETS =256;
        int maxLen = arrayToBeSort.length;


        ArrayList<String>[ ] wordsByLength = new ArrayList[ maxLen + 1 ];

        ArrayList<String> [ ] buckets = new ArrayList[ BUCKETS ];


        for( int i = 0; i < wordsByLength.length; i++ )
            wordsByLength[ i ] = new ArrayList<>( );

        for( int i = 0; i < BUCKETS; i++ )
            buckets[ i ] = new ArrayList<>( );

        for( String s : arrayToBeSort )
            wordsByLength[ s.length( ) ].add( s );

        //System.out.println(wordsByLength[1]);

        int idx = 0;
        for( ArrayList<String> wordList : wordsByLength )
            for( String s : wordList )
                arrayToBeSort[ idx++ ] = s;

        int startingIndex = arrayToBeSort.length;
        for( int pos = maxLen - 1; pos >= 0; pos-- )
        {
            startingIndex -= wordsByLength[ pos + 1 ].size( );

            for( int i = startingIndex; i < arrayToBeSort.length; i++ ) {
                buckets[ arrayToBeSort[ i ].charAt( pos ) ].add( arrayToBeSort[ i ] );

            }

            idx = startingIndex;
            for( ArrayList<String> thisBucket : buckets )
            {
                for( String s : thisBucket )
                {
                    arrayToBeSort[ idx++ ] = s;
                    epoch++;
                }
                thisBucket.clear( );
            }
        }
        return epoch;
    }

    public void radixToStore( String[] arrayToBeSort, String filePath)
    {

        final int BUCKETS =256;
        int maxLen = arrayToBeSort.length;


        ArrayList<String>[ ] wordsByLength = new ArrayList[ maxLen + 1 ];

        ArrayList<String> [ ] buckets = new ArrayList[ BUCKETS ];


        for( int i = 0; i < wordsByLength.length; i++ )
            wordsByLength[ i ] = new ArrayList<>( );

        for( int i = 0; i < BUCKETS; i++ )
            buckets[ i ] = new ArrayList<>( );

        for( String s : arrayToBeSort )
            wordsByLength[ s.length( ) ].add( s );

        //System.out.println(wordsByLength[1]);

        int idx = 0;
        for( ArrayList<String> wordList : wordsByLength )
            for( String s : wordList )
                arrayToBeSort[ idx++ ] = s;

        int startingIndex = arrayToBeSort.length;
        for( int pos = maxLen - 1; pos >= 0; pos-- )
        {
            startingIndex -= wordsByLength[ pos + 1 ].size( );

            for( int i = startingIndex; i < arrayToBeSort.length; i++ ) {
                buckets[ arrayToBeSort[ i ].charAt( pos ) ].add( arrayToBeSort[ i ] );

            }

            idx = startingIndex;
            for( ArrayList<String> thisBucket : buckets )
            {
                for( String s : thisBucket )
                {
                    arrayToBeSort[ idx++ ] = s;
                }
                thisBucket.clear( );
            }
        }

        try {
            Path currentRelativePath = Paths.get("");
            String currentPathLocation = currentRelativePath.toAbsolutePath().toString();
            PrintWriter pr = new PrintWriter(currentPathLocation + "\\src\\radixSort\\"+filePath+"RadixSort.txt");
            for (int y = 0; y < arrayToBeSort.length; y++) {
                pr.println(arrayToBeSort[y]);
            }
            pr.close();
            System.out.println("Done sorted all the words and put in text file");
            System.out.println("Text File Location: "+"\\src\\radixSort\\"+filePath+"RadixSort.txt" );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }

        return;
    }


    public void bestCase(){
        String bc= "bestCase";
      // radixSorting(bestCaseRadix,bc);

        long epoch []= new long [100000];
        int numberOfInput [] = new int [100000];
        int store=0;

        for(int i=3000;i<bestCaseRadix.length;i+=8000)
        {
            numberOfInput[store]=i;
            epoch[store] =radixSorting(bestCaseRadix,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\radixSort\\caseTimeCompleixity\\"+bc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

        //THIS METHOD IS TO SORTED ALL WORDS AND STORE INSIDE THE TEXT FILE AS A PROVE
        radixToStore(bestCaseRadix,bc);
    }


    public void worstCase()
    {
        String wc= "worstCase";
       // radixSorting(worstCaseRadix,wc);

        long epoch []= new long [100000];
        int numberOfInput [] = new int [100000];
        int store=0;

        for(int i=3000;i<worstCaseRadix.length;i+=8000)
        {
            numberOfInput[store]=i;
            epoch[store] =radixSorting(worstCaseRadix,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\radixSort\\caseTimeCompleixity\\"+wc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

        //THIS METHOD IS TO SORTED ALL WORDS AND STORE INSIDE THE TEXT FILE AS A PROVE
        radixToStore(worstCaseRadix,wc);
    }

    //Testing
    public static void printtestRadix()
    {
        int iTest;
        for (int i=0;i<100;i++)
        {
            iTest= worstCaseRadix.length-1-i;
            System.out.println(worstCaseRadix[iTest]);
        }
    }
    public void testCase(){
        String bc= "testingCase";
       // radixSorting(averageCaseRadix,bc);

        long epoch []= new long [100000];
        int numberOfInput [] = new int [100000];
        int store=0;

        for(int i=3000;i<worstCaseRadix.length;i+=8000)
        {
            numberOfInput[store]=i;
            epoch[store] =radixSorting(worstCaseRadix,i);
            store++;
        }

        //Writing the time compleixity inside the text file
        String pathForTextTimeFrame= ("\\src\\radixSort\\caseTimeCompleixity\\"+bc+"TimeCompleixity.txt");
        writingTheTimeCompleixity(epoch,pathForTextTimeFrame,numberOfInput);

        //THIS METHOD IS TO SORTED ALL WORDS AND STORE INSIDE THE TEXT FILE AS A PROVE
        radixToStore(worstCaseRadix,bc);
    }


}
