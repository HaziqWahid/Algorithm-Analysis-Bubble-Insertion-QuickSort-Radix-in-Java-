import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class wordArray {

    //Initial Variable to hold asciiOnly character after getting filtered
   public static  String[] asciiOnly;

   //All words from the text file
    public static String[] words;


    //Best Case For Array/ Already Sorted
    public static String [] bestCaseArrayWord;

    //Worst Case Array
    public static String[] worstCaseArrayWord;


    // Text File Path
    Path currentRelativePath = Paths.get("");
    String currentPathLocation = currentRelativePath.toAbsolutePath().toString();

    //Class constructor
    wordArray()
    {
        //Read the text file and store it in array
         words = readArray(currentPathLocation+"\\src\\wordList.txt");
        System.out.println("There are "+ words.length+"Words non filter");

        //Filter out the non Ascii Characters from the text file;
         asciiOnly = arrayFilter(words);
        System.out.println("Inside main There are "+asciiOnly.length+ " Words");


        //Storing for the best Case array
        bestCaseArrayWord=bestCaseArrayWordMethod(currentPathLocation+"\\src\\bestCase.txt");

        //Storing for the worst Case Array
        worstCaseArrayWord= worstCaseArrayWordMethod(currentPathLocation+"\\src\\bestCase.txt");

    }


    //Storing the words in text file into an array
    public static String[] readArray(String file)
    {
        //Count how many elements in the text file
        int count=0;
        try
        {
            Scanner s1 = new Scanner(new File(file));
            while(s1.hasNextLine())
            {
                count++;
                s1.next();
            }
            String [] words = new String [count];

            Scanner s2= new Scanner(new File(file));
            for (int i = 0; i < count; i++)
            {
                words[i]= s2.next();
            }
            return words;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        return null;
    }


    //A method to check if the words is Ascii or not
    public static boolean isPureAscii(String v) {
        return Charset.forName("US-ASCII").newEncoder().canEncode(v);
    }


    // Removing the non-ascii charater from the array
    public static String[] arrayFilter (String [] filterArray)
    {
        //Counting how many word in the file that contain ascii only
        int asciiOnlyCount =0;

        //Initiator
        boolean checking= false;

        for (int i=0;i<filterArray.length;i++) {
            checking = isPureAscii(filterArray[i]);
            if (checking == true) {
                asciiOnlyCount++;
            }
        }
        System.out.println("There are "+ asciiOnlyCount+ " only ascii words in the methods");
        String [] asciiOnly = new String [asciiOnlyCount];
        int x=0;
        for (int y=0;y<filterArray.length;y++)
        {
            checking=isPureAscii(filterArray[y]);
            if(checking==true) {
                asciiOnly[x]=filterArray[y];
                x++;
            }
        }

        return asciiOnly;
    }

    //A method to print Ascii Character
    public static void print()
    {
        for(int i=0;i<100;i++) {
            System.out.println(asciiOnly[i]+"- "+i);
        }
    }

    //Getting Array From Already Sorted List To Get The Best Case
    public static String[]  bestCaseArrayWordMethod(String file)
    {
        String bestCaseFilePath = (file);

        //Count how many elements in the text file
        int count2=0;
        try
        {
            Scanner s1 = new Scanner(new File(file));
            while(s1.hasNextLine())
            {
                count2++;
                s1.next();
            }
            String []bestCaseArrayWord  = new String [count2];

            Scanner s2= new Scanner(new File(file));
            for (int i = 0; i < count2; i++)
            {
                bestCaseArrayWord[i]= s2.next();
            }
            return bestCaseArrayWord;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        return null;
    }

    //GETTING THE SORTED ARRAY AND STORE FROM BEHIND TO GET THE WORSTCASE
    public static String[] worstCaseArrayWordMethod(String file)
    {
        String worstCaseFilePath = (file);

        //Count how many elements in the text file
        int count2=0;
        try
        {
            Scanner s1 = new Scanner(new File(file));
            while(s1.hasNextLine())
            {
                count2++;
                s1.next();
            }
            String [] worstCaseArrayWord  = new String [count2];

            int Countminus= count2-1;
            Scanner s2= new Scanner(new File(file));
            for (int i = Countminus; i >= 0; i--)
            {
                worstCaseArrayWord[i]= s2.next();
            }
            return worstCaseArrayWord;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        return null;
    }



    //Method to put the input and counters into the text file. So we can use excel to find the graph.
     public static void writingTheTimeCompleixity(long epoch [],String fileNameText,int numberOfInput[])
     {
         try {
             Path currentRelativePath = Paths.get("");
             String currentPathLocation = currentRelativePath.toAbsolutePath().toString();
             PrintWriter pr = new PrintWriter(currentPathLocation + fileNameText);
             for (int y = 0; y < epoch.length; y++) {
                 pr.println(numberOfInput[y]+ "    "+epoch[y]);

             }
             pr.close();
             System.out.println("Done putting timeFrame into the"+fileNameText);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("No such file exists.");
         }
     }
}
