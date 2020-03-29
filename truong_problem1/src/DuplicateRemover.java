import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover {
	private static HashSet<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile)
	{
		dataFile = "problem1.txt";
		//exception handling
		try 
		{
			Scanner input = new Scanner(new File(dataFile));
			//while the scanner has a next line, lowercase and add to hashset, punctuation adds to uniqueness
			while (input.hasNextLine())
			{
				String unique = input.next().toLowerCase();
				uniqueWords.add(unique);
			}
			//close scanner
			input.close();
		} 
		//exception handling
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found, please insert a file named 'problem1.txt'.");
			e.printStackTrace();
		}
		//testing on how it output in console
		//System.out.println(uniqueWords);
	}
	
	public void write(String outputFile)
	{
		//'remove' method and outputFile
		remove(null);
		outputFile = "unique_words.txt";
		//exception handling
		try 
		{
			//writes a txt file populated with the uniqueWords hashset uniqueness
			PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
			writer.println(uniqueWords);
			//close writer
			writer.close();
		} 
		//exception handling
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found, please insert a file named 'unique_words.txt'.");
			e.printStackTrace();
		} 
		//exception handling
		catch (UnsupportedEncodingException e) 
		{
			System.out.println("UTF-8 is not supported, please try again on another machine.");
			e.printStackTrace();
		}
	}	
}
