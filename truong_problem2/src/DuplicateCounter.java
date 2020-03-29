import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {

	private static HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	public void count(String dataFile)
	{
		dataFile = "problem2.txt";
		//exception handling
		try 
		{
			Scanner input = new Scanner(new File(dataFile));
			//while the scanner has a next line, punctuation adds to uniqueness
			while (input.hasNextLine())
			{
				String line = input.nextLine();
				//for strings that are separated by " "
				for (String word : line.split(" "))
				{
					if (word == null || word.equals(""))
					{
						continue;
					}
					//lowercases, and counts the uniqueness depending on the word
					String lowerCase = word.toLowerCase(); 
					//detects a unique word and gives it an instance value of 1
					if (wordCounter.containsKey(lowerCase))
					{
						wordCounter.put(lowerCase, wordCounter.get(lowerCase) + 1);
					}
					//detects if the word occurs again, if it does, increase the instance values by 1
					else
					{
						wordCounter.put(lowerCase, 1);
					}
				}
			}
			//close scanner
			input.close();
		} 
		//exception handling
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found, please insert a file named 'problem2.txt'.");
			e.printStackTrace();
		}
		//testing on how it output in console
		//System.out.println(wordCounter);
	}
	
	public void write(String outputFile)
	{
		//'count' method and outputFile
		count(null);
		outputFile = "unique_word_counts.txt";
		//exception handling
		try 
		{
			//writes a txt file populated with the wordCounter hashset uniqueness
			PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
			writer.println(wordCounter);
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
