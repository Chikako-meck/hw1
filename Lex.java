import java.io.*;
import java.util.*;
import java.lang.String;

public class Lex {

    static String sort(String word){
	String[] wordArray = new String[word.length()];
	for(int i=0; i < word.length(); i++){
	    String newString = String.valueOf(word.charAt(i));
	    wordArray[i] = newString;
	}
	Arrays.sort(wordArray);
	return String.join("", wordArray);
    }

    static ArrayList<String> makeDictionaly(File file){
	try{
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    ArrayList<String> wordList = new ArrayList<String>(72412);
	    String word = br.readLine();
	    while(word != null){
		wordList.add(word);
		word = br.readLine();
	    }
	    br.close();
	    return wordList;
	}catch(IOException ioe){
	    System.out.println(ioe);
	    return null;
	}
    }
    
    static ArrayList<String> makeSortedDictionaly(File file){
	try{
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    ArrayList<String> sortedWordList = new ArrayList<String>(72412);
	    String word = br.readLine();
	    String sortedWord;
	    while(word != null){
		sortedWord = sort(word);
		sortedWordList.add(sortedWord);
		word = br.readLine();
	    }
	    br.close();
	    return sortedWordList;
	}catch(IOException ioe){
	    System.out.println(ioe);
	    return null;
	}
    }
    public static void main(String args[]){
        String dictionaly = "dictionaly.txt";
	File file = new File(dictionaly);
	ArrayList<String> wordList = makeDictionaly(file);
	ArrayList<String> sortedWordList = makeSortedDictionaly(file);

	try{
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String input = new String(in.readLine());
	    String sortedInput = sort(input);
	    if(sortedWordList.contains(sortedInput) == true){
		String word =wordList.get(sortedWordList.indexOf(sortedInput));
		System.out.println(word);
	    }else{
		System.out.println("Not Found");
	    }
	}catch(IOException ioe){
	    ioe.printStackTrace();
	}
    }
}
