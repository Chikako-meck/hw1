import java.io.*;
import java.util.*;
import java.lang.String;

public class Lex {
    
    static ArrayList<String> makeArray(String word){
	ArrayList<String> wordArray = new ArrayList<String>(word.length());
	for(int i=0; i<word.length(); i++){
	    String newString = String.valueOf(word.charAt(i));
	    wordArray.add(i,newString);
	}
	return wordArray;
    }
    
    static String sort(ArrayList<String> wordArray){
	Collections.sort(wordArray);
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
		sortedWord = sort(makeArray(word));
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

    static void matchWord(ArrayList<String> input,
			  ArrayList<String> wordList,
			  ArrayList<String> sortedWordList){
	String sortedInput = sort(input);
	if(sortedWordList.contains(sortedInput) == true){
	    String word =wordList.get(sortedWordList.indexOf(sortedInput));
	    System.out.println(word);
	}
    }
    
    public static void main(String args[]){
        String dictionaly = "dictionaly.txt";
	File file = new File(dictionaly);
	ArrayList<String> wordList = makeDictionaly(file);
	ArrayList<String> sortedWordList = makeSortedDictionaly(file);	
	try{
	    BufferedReader in
		= new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("input string >>>");
	    String input = new String(in.readLine());
	    ArrayList<String> word = makeArray(input);
	    matchWord(word, wordList, sortedWordList);
	    for(int i=0; i<word.size(); i++){
		word.remove(i);
		ArrayList<String> word2 = word;
		matchWord(word , wordList, sortedWordList);
		for(int k=0; k<word2.size(); k++){
		    word2.remove(k);
		    ArrayList<String> word3 = word2;
		    matchWord(word2 , wordList, sortedWordList);
		    for(int l=0; l<word3.size(); l++){
			word3.remove(l);
			ArrayList<String> word4 = word3;
			matchWord(word3 , wordList, sortedWordList);
			for(int m=0; m<word4.size(); m++){
			    word4.remove(m);
			    ArrayList<String> word5 = word4;
			    matchWord(word4 , wordList, sortedWordList);
			    for(int n=0; n<word5.size(); n++){
				word5.remove(n);
				ArrayList<String> word6 = word5;
				matchWord(word5 , wordList, sortedWordList);
				for(int o=0; o<word6.size(); o++){
				    word6.remove(o);
				    ArrayList<String> word7 = word6;
				    matchWord(word6 , wordList, sortedWordList);
				    for(int p=0; p<word7.size(); p++){
					word7.remove(p);
					ArrayList<String> word8 = word7;
					matchWord(word7 , wordList,
						  sortedWordList);
					for(int q=0; q<word8.size(); q++){
					    word8.remove(q);
					    ArrayList<String> word9 = word8;
					    matchWord(word8 , wordList,
						      sortedWordList);
					    for(int r=0; r<word9.size(); r++){
						word9.remove(r);
						ArrayList<String> word10 = word9;
						matchWord(word9 , wordList,
							  sortedWordList);
						for(int s=0; s<word10.size(); s++){
						    word10.remove(s);
						    ArrayList<String> word11 = word10;
						    matchWord(word10 , wordList,
							      sortedWordList);
						    for(int t=0; t<word11.size(); t++){
							word11.remove(t);
							ArrayList<String> word12 = word11;
							matchWord(word11 , wordList,
								  sortedWordList);
							for(int u=0; u<word12.size(); u++){
							    word12.remove(u);
							    ArrayList<String> word13 = word12;
							    matchWord(word12 , wordList,
								      sortedWordList);
							}
						    }
						}
					    }
					}
				    }
				}
			    }
			}
		    }
		}
		word = makeArray(input);
	    }	
	    
	}catch(IOException ioe){
	    ioe.printStackTrace();
	}
    }
}

