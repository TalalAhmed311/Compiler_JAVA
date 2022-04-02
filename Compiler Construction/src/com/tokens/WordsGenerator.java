package com.tokens;

import java.util.Scanner;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;


// EXAMPLE
// ==========
// void class A:B_C_D
// while(a<<=b!=d
// if_else((bcd)+==-=56
// char ch;;
// }}

//	EXAMPLE 2
//	========================
/*	Void interface //A_B;C<<D!!d
	dowhile (a+=b*==*=/=d)
	String str=="abc+=\\"+=56
	return ch+'n'+'\f'+'\n'+'abc'+'\\n'+5
	//a.b.55.89.c
	99.897.775.abc5b
	$ a55.5bc.b55.999
	44.5.7bdx#c.55 $ */

public class WordsGenerator {
	
		
	private static ArrayList<ArrayList<String>> KW = new ArrayList<ArrayList<String>>();
static {
		
		KW.add(new ArrayList<String>(Arrays.asList("int", "DT")));
		KW.add(new ArrayList<String>(Arrays.asList("float", "DT")));
		KW.add(new ArrayList<String>(Arrays.asList("long", "DT")));
		KW.add(new ArrayList<String>(Arrays.asList("short", "DT")));
		KW.add(new ArrayList<String>(Arrays.asList("char", "DT")));
		KW.add(new ArrayList<String>(Arrays.asList("bool", "DT")));
		KW.add(new ArrayList<String>(Arrays.asList("String", "String")));
		KW.add(new ArrayList<String>(Arrays.asList("var", "var")));
		KW.add(new ArrayList<String>(Arrays.asList("if", "if")));
		KW.add(new ArrayList<String>(Arrays.asList("else", "else")));
		KW.add(new ArrayList<String>(Arrays.asList("elif", "elif")));
		KW.add(new ArrayList<String>(Arrays.asList("switch", "switch")));
		KW.add(new ArrayList<String>(Arrays.asList("do", "do")));
		KW.add(new ArrayList<String>(Arrays.asList("while", "while")));
		KW.add(new ArrayList<String>(Arrays.asList("for", "for")));
		KW.add(new ArrayList<String>(Arrays.asList("foreach", "foreach")));
		KW.add(new ArrayList<String>(Arrays.asList("break", "break")));
		KW.add(new ArrayList<String>(Arrays.asList("pass", "pass")));
		KW.add(new ArrayList<String>(Arrays.asList("case", "case")));
		KW.add(new ArrayList<String>(Arrays.asList("interface", "interface")));
		KW.add(new ArrayList<String>(Arrays.asList("class", "class")));
		KW.add(new ArrayList<String>(Arrays.asList("abstract", "abstract")));
		KW.add(new ArrayList<String>(Arrays.asList("static", "static")));
		KW.add(new ArrayList<String>(Arrays.asList("const", "const")));
		KW.add(new ArrayList<String>(Arrays.asList("try", "try")));
		KW.add(new ArrayList<String>(Arrays.asList("catch", "catch")));
		KW.add(new ArrayList<String>(Arrays.asList("new", "new")));
		KW.add(new ArrayList<String>(Arrays.asList("this", "this")));
		KW.add(new ArrayList<String>(Arrays.asList("throw", "throw")));
		KW.add(new ArrayList<String>(Arrays.asList("return", "return")));
		KW.add(new ArrayList<String>(Arrays.asList("void", "void")));
		KW.add(new ArrayList<String>(Arrays.asList("enum", "enum")));
		KW.add(new ArrayList<String>(Arrays.asList("in", "in")));
		KW.add(new ArrayList<String>(Arrays.asList("overwride", "overwride")));
		KW.add(new ArrayList<String>(Arrays.asList("base", "base")));
		KW.add(new ArrayList<String>(Arrays.asList("public", "public")));
		KW.add(new ArrayList<String>(Arrays.asList("private", "private")));
		KW.add(new ArrayList<String>(Arrays.asList("NULL","NULL")));
		KW.add(new ArrayList<String>(Arrays.asList("Null","NULL")));
		KW.add(new ArrayList<String>(Arrays.asList("null","NULL")));
		KW.add(new ArrayList<String>(Arrays.asList("main","main")));
	}
	
	private static ArrayList<ArrayList<String>> OP = new ArrayList<ArrayList<String>>();
	static { 
		OP.add(new ArrayList<String>(Arrays.asList("++","inc_dec")));
		OP.add(new ArrayList<String>(Arrays.asList("--","inc_dec")));
		OP.add(new ArrayList<String>(Arrays.asList("*","MDM")));
		OP.add(new ArrayList<String>(Arrays.asList("/","MDM")));
		OP.add(new ArrayList<String>(Arrays.asList("%","MDM")));
		OP.add(new ArrayList<String>(Arrays.asList("+","PM")));
		OP.add(new ArrayList<String>(Arrays.asList("-","PM")));
		OP.add(new ArrayList<String>(Arrays.asList("<","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList(">","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList("<=","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList(">=","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList("==","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList("!=","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList("&&","AND")));
		OP.add(new ArrayList<String>(Arrays.asList("||","OR")));
		OP.add(new ArrayList<String>(Arrays.asList("=","=")));
		OP.add(new ArrayList<String>(Arrays.asList("+=","CAO")));
		OP.add(new ArrayList<String>(Arrays.asList("/=","CAO")));
		OP.add(new ArrayList<String>(Arrays.asList("-=","CAO")));
		OP.add(new ArrayList<String>(Arrays.asList("*=","CAO")));
		OP.add(new ArrayList<String>(Arrays.asList("%=","CAO")));
	}
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> l = new ArrayList<ArrayList<String>>();
		
		ArrayList<ArrayList<String>> tokens = new ArrayList<ArrayList<String>>();
		
		l = breakWord("C:\\Users\\Dell\\Desktop\\syntax.txt");
		
		// print the list of words
	    
		String word = "", Class = "", lineNum = "";
		
		FileWriter writer = new FileWriter("C:\\Users\\Dell\\Desktop\\Tokens.txt");
		writer.write("");
		
		for(int i = 0; i<l.size(); i++) {
	    	
	    	word = l.get(i).get(0);
	    	lineNum = l.get(i).get(1);
	    	
	    	char ch = word.charAt(0);
	    	//System.out.println(ch);
	    	
	    	if(Character.isLetter(ch)) {
	    		
	    		if(isID(word)) {
	    			
	    			Class = isKW(word);
	    			if(Class.equals("")) {
	    				
	    				Class = "ID";	 
	    			}
	    			if(Class.equals(word)) {
	    				
	    				writer.write("( "+Class + " ,  , " + lineNum+ " )\r\n");
	    				tokens.add(new ArrayList<String>(Arrays.asList(Class," ",lineNum)));
	    			}
	    			else{
	    				
	    				writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    				tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    			}
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token"+" , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if(ch == '_') {
	    		
	    		if(isID(word)) {
	    			
	    			Class = "ID";
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else {
	    			
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if(ch == '\"') {
	    		
	    		if(isStrConst(word)) {
	    			
	    			Class = "str_const";
	    			word = word.substring(1, word.length()-1);
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token "+" , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if (ch == '\'') {
	    		
	    		if(isCharConst(word)) {
	    			
	    			Class = "char_const";
	    			word = word.substring(1, word.length()-1);
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token "+ " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if (Character.isDigit(ch)) {
	    		
	    		if(isIntConst(word)) {
	    			
	    			Class = "int_const";
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else if (isFloatConst(word)) {
	    			
	    			Class = "float_const";
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token "+" , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if (ch == '.') {
	    		
	    		
	    		if (isFloatConst(word)) {
	    			
	    			Class = "float_const";
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else if (word.equals(".")) {
	    			
	    			writer.write("( ."+" ,  , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("."," ", lineNum)));
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token "+" , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if (isPunctuator(ch)) {
	    		
	    		Class = word;
	    		writer.write("( "+Class + " ,  , " + lineNum+ " )\r\n");
	    		tokens.add(new ArrayList<String>(Arrays.asList(Class," " , lineNum)));
	    	}
	    	else if(isOperator(ch)) {
	    		
	    		Class = isOP(word);
	    		writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    		tokens.add(new ArrayList<String>(Arrays.asList(Class, word , lineNum)));
	    	}
	    	else {
	    		
	    		writer.write("( Invalid Token "+" , "+word+" , " + lineNum+ " )\r\n");
	    		tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    	}
	    	
	    }

		writer.close();
	    	   
		for (int i = 0; i < tokens.size(); i++) {
			
			System.out.println(tokens.get(i));
		}
	    
	
		
}
	
	
	public ArrayList<ArrayList<String>> getTokens() throws Exception{
		ArrayList<ArrayList<String>> l = new ArrayList<ArrayList<String>>();
		
		ArrayList<ArrayList<String>> tokens = new ArrayList<ArrayList<String>>();
		
		l = breakWord("C:\\Users\\Dell\\Desktop\\syntax.txt");
		
		// print the list of words
	    
		String word = "", Class = "", lineNum = "";
		
		FileWriter writer = new FileWriter("C:\\Users\\Dell\\Desktop\\Tokens.txt");
		writer.write("");
		
		for(int i = 0; i<l.size(); i++) {
	    	
	    	word = l.get(i).get(0);
	    	lineNum = l.get(i).get(1);
	    	
	    	char ch = word.charAt(0);
	    	//System.out.println(ch);
	    	
	    	if(Character.isLetter(ch)) {
	    		
	    		if(isID(word)) {
	    			
	    			Class = isKW(word);
	    			if(Class.equals("")) {
	    				
	    	 			if(word.equals("true") || word.equals("false")) {
		    				Class = "bool_const";
			    		
		    			}else {
		    				
		    				Class = "ID";	 
		    			}
	    			}
	    		
	    			if(Class.equals(word)) {
	    				
	    				writer.write("( "+Class + " ,  , " + lineNum+ " )\r\n");
	    				tokens.add(new ArrayList<String>(Arrays.asList(Class," ",lineNum)));
	    			}
	    			else{
	    				
	    				writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    				tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    			}
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token"+" , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if(ch == '_') {
	    		
	    		if(isID(word)) {
	    			
	    			Class = "ID";
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else {
	    			
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if(ch == '\"') {
	    		
	    		if(isStrConst(word)) {
	    			
	    			Class = "str_const";
	    			word = word.substring(1, word.length()-1);
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token "+" , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if (ch == '\'') {
	    		
	    		if(isCharConst(word)) {
	    			
	    			Class = "char_const";
	    			word = word.substring(1, word.length()-1);
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token "+ " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if (Character.isDigit(ch)) {
	    		
	    		if(isIntConst(word)) {
	    			
	    			Class = "int_const";
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else if (isFloatConst(word)) {
	    			
	    			Class = "float_const";
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token "+" , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if (ch == '.') {
	    		
	    		
	    		if (isFloatConst(word)) {
	    			
	    			Class = "float_const";
	    			writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList(Class, word, lineNum)));
	    		}
	    		else if (word.equals(".")) {
	    			
	    			writer.write("( ."+" ,  , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("."," ", lineNum)));
	    		}
	    		else {
	    			
	    			writer.write("( Invalid Token "+" , "+word+" , " + lineNum+ " )\r\n");
	    			tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    		}
	    	}
	    	else if (isPunctuator(ch)) {
	    		
	    		Class = word;
	    		writer.write("( "+Class + " ,  , " + lineNum+ " )\r\n");
	    		tokens.add(new ArrayList<String>(Arrays.asList(Class," " , lineNum)));
	    	}
	    	else if(isOperator(ch)) {
	    		
	    		Class = isOP(word);
	    		writer.write("( "+Class + " , "+word+" , " + lineNum+ " )\r\n");
	    		tokens.add(new ArrayList<String>(Arrays.asList(Class, word , lineNum)));
	    	}
	    	else {
	    		
	    		writer.write("( Invalid Token "+" , "+word+" , " + lineNum+ " )\r\n");
	    		tokens.add(new ArrayList<String>(Arrays.asList("Invalid Token", word, lineNum)));
	    	}
	    	
	    }

		writer.close();
	    
		return tokens;
	}
	// method to check whether a character is operator or not
	
	private static boolean isOperator(char c) {
		
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '&' || c == '|' || c == '!' || c == '<' || c == '>' || c == '=' ) {
			return true;
		}
		return false;
	}
	
	// method to check whether a character is punctuator, if true, return true else, return false
	
	private static boolean isPunctuator(char c) {
		
		if(c == ';' || c == ':' || c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']' || c == ',' || c == '?' ) {
			return true;
		}
		return false;
	}

	// method to check whether a word is operator or not
	// return class of word if it is operator
	private static String isOP (String word) {
		
		String Class = "";
		for (int i = 0; i < OP.size(); i++) {
			
			if(OP.get(i).get(0).equals(word)) {
				Class = OP.get(i).get(1);
			}
		}
		return Class;
	}
	
	// method to check whether a word is keyword or not
	// return class of word if it is keyword
	private static String isKW (String word) {
		
		String Class = "";
		for(int i = 0; i < KW.size(); i++) {
			
			if(KW.get(i).get(0).equals(word)) {
				Class = KW.get(i).get(1);
			}
		}
		return Class;
	}
	
	// for bool constant
	private static boolean isBoolConst(String input) {
		
		if(input.equals("true") || input.equals("false")) {
			return true;
		}
		return false;
	}
	
	// RE for identifier
	private static boolean isID(String input){
		
		Pattern p = Pattern.compile("(([a-zA-Z_]\\w*[a-zA-Z\\d])|([a-zA-Z]))");
		Matcher m = p.matcher(input);
		
		if(m.matches()) {
			
			return true;
		}
		
		return false;
		
	}
	
	// RE for character constants
	private static boolean isCharConst(String input){
		
		Pattern p = Pattern.compile("\'((\\\\[\'\"\\\\])|(\\\\[bfnrt0])|([\\!#-&\\(-/0-9:-@A-Z\\[\\]-`ac-eg-mo-qsu-z\\{-~])|([bnfrt0]))\'");
		Matcher m = p.matcher(input);
		
		if(m.matches()) {
			
			return true;
		}
		
		return false;
		
	}
	
	// RE for string constants
	private static boolean isStrConst(String input){
		
		Pattern p = Pattern.compile("\"((\\\\[\'\"\\\\])|(\\\\[bfnrt0])|([\\!#-&\\(-/0-9:-@A-Z\\[\\]-`ac-eg-mo-qsu-z\\{-~])|([bnfrt0])|(\\s))*\"");
		Matcher m = p.matcher(input);
		
		if(m.matches()) {
			return true;
		}
		return false;
		
	}
	
	// RE for integer constants
	private static boolean isIntConst(String input){
		
		Pattern p = Pattern.compile("[+-]?\\d+");
		Matcher m = p.matcher(input);
		
		if(m.matches()) {
			
			return true;
		}
		
		return false;
		
	}
	
	// RE for floating point constants
	private static boolean isFloatConst(String input){
		
		Pattern p = Pattern.compile("[+-]?\\d*\\.\\d+");
		Matcher m = p.matcher(input);
		
		if(m.matches()) {
			
			return true;
		}
		
		return false;
		
	}

	
	// method to read file and return data as string and throws exception if if there is any
	
	private static String readFileAsString(String fileName)throws Exception
	{
		
		// variable to store file data
		
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}
	
	private static ArrayList breakWord(String filename) throws Exception {
		
		
		// List to store words
		//ArrayList<String> list=new ArrayList<String>(); 
		ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();

		
		// read text file and store its data as a string in data variable
		String data = readFileAsString(filename);
	    
		// a temporary variable to hold characters to form word
	    String temp = "";
	    
	    int ln= 1;
	    
	    for(int i =0; i<data.length(); i++) {
	    	
	    	
	    	
	    	// check for all break points at which a word can be formed
	    	
	    	// check for space, carriage return or new line feed
	    	// if occur, add the word temporarily stored in temp in the word list and empty temp
	    
	    	if(data.charAt(i)=='\t') {
	    		if(!temp.isEmpty()) {
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    			temp = "";
	    		}
	    		ln++;
	    	}else if(data.charAt(i)==' ') { 
	    		
	    		
	    		if(!temp.isEmpty()) {
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    			temp = "";
	    		}
	    		ln++;
	    	}
	    	
	    	
	    	else if(data.charAt(i) == '\r' || data.charAt(i) == '\n') {
	    		
	    		if(!temp.isEmpty()) {
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    			temp = "";
	    		}
	    	}
	    	
	    	// condition for string literals
	    	
	    	else if(data.charAt(i)=='\"') { 
	    		
	    		// if temp is not empty , add temp to word list and empty temp
	    		if(!temp.isEmpty()) {
	    			
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    			temp = "";
	    		}
	    		// if temp is empty add " in temp and increment the index
	    		temp += String.valueOf(data.charAt(i));
	    		i++;
	    		
	    		// search for closing inverted commas and stop if i = source file length
	    		while(data.charAt(i)!='\"' && i < data.length()-1) {
	    			
	    			// if line change character occurs then break loop 
	    			if(data.charAt(i)=='\r' || data.charAt(i)=='\n') {
	    				
	    				ln++;
	    				break;
	    			}
	    			
	    			// if backslash occur and next character is not backslash then simply add both characters
	    			// in temp
	    			else if(data.charAt(i)=='\\') {
	    				
	    				if(data.charAt(i+1)!='\\') {
	    					
	    					temp+= String.valueOf(data.charAt(i)) + String.valueOf(data.charAt(i+1));
	    					i++;
	    				}
	    			}
	    			
	    			// if none of the above condition is true then simply add character in temp
	    			else {
	    				temp += String.valueOf(data.charAt(i));
	    			}
    				i++;
	    		}
	    		
	    		// if the string ends at " then concatenate it in temp
	    		if (data.charAt(i)=='\"') {
	    			
	    			temp+=String.valueOf(data.charAt(i));
	    		}
	    		list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    		temp = "";
	    	}
	    	
	    	// check for character constants
	    	
	    	else if(data.charAt(i)== '\'') { 
	    		
	    		if(!temp.isEmpty()) {
	    		
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
		    		temp = "";
	    		}
	    		
	    		// add ' to temp
	    		temp+=String.valueOf(data.charAt(i));
	    		i++;
	    		
	    		// if space occur after (') then add (') to list and empty temp
	    		
	    		if(data.charAt(i)==' ' || i == data.length()-1) {
	    			
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    			temp = "";
	    		}
	    		
	    		// if program ends at (') or line ends at (') then add (') to list 
	    		// and empty temp
	    		
	    		else if (data.charAt(i)=='\r' || data.charAt(i)=='\n') {
	    			
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    			temp = "";
	    			ln++;
	    		}
	    		
	    		// if backslash occur after (')
	    		else if(data.charAt(i)=='\\') {
	    			
	    			// concatenate backslash with (')
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// increment the index
	    			i++;
	    			
	    			int j = 0;
	    			
	    			// loop to read next two characters 
	    			
	    			while (j < 2 && i < data.length()-1) {
	    				
	    				if (data.charAt(i)==' ') {
	    					break;
	    				}
	    				
	    				if (data.charAt(i)=='\r' || data.charAt(i)=='\n') {
	    					
	    					ln++;
	    					break;
	    				}
	    				// if character is other than space or line change line change
	    				// then concatenate it
	    				
	    				temp += String.valueOf(data.charAt(i));
	    				
	    				// increment the index
	    				i++;
	    				j++;
	    			}
	    			
	    			// decrement the index to start next iteration from the character next to (')
	    			i--;
	    			
	    			// add the word formed above in the list
		    		list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
		    		
		    		// empty temp
	    			temp = "";
	    		}
	    		
	    		// if character if not backslash, space, and line change
	    		
	    		else {
	    			
	    			
	    			int j =0;
	    			
	    			// loop to read next two characters 
	    			
	    			while (j < 2 && i < data.length()-1) {
	    				
	    				if (data.charAt(i)==' ') {
	    					break;
	    				}
	    				
	    				if(data.charAt(i)=='\r' || data.charAt(i)=='\n') {
	    					
	    					ln++;
	    					break;
	    				}
	    				// if character is other than space or line change line change
	    				// then concatenate it
	    				
	    				temp += String.valueOf(data.charAt(i));
	    				
	    				// increment the index
	    				i++;
	    				j++;
	    			}
	    			
	    			// decrement the index to start next iteration from the character next to (')
	    			i--;
	    			
	    			// add the word formed above in the list
		    		list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
		    		
		    		// empty temp
	    			temp = "";
	    		}
	    		
	    	}
	    	
	    	else if(isOperator(data.charAt(i))) { // check if the current character is operator
	    		
	    		if(!temp.isEmpty()) {
	    		
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));	// if condition true, add temp to list and empty temp
		    		temp = "";
	    		}
	    		
	    		
	    		// check operators
	    		
	    		switch (data.charAt(i)) {		
	    		
	    		
	    		case '+':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// if + is current character then check for the possibility 
	    			// of next character to be + or = to match (++, +=)
	    			
	    			if(data.charAt(i+1)=='+' || data.charAt(i+1) == '=') {		
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		case '-':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for (--, -=)
	    			
	    			if(data.charAt(i+1)=='-' || data.charAt(i+1) == '=') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		case '*':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for (*, *=)
	    			
	    			if(data.charAt(i+1) == '=') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		case '/':
	    			
	    			//temp += String.valueOf(data.charAt(i));
	    			
	    			// check for compund assignment operator (/=)
	    			
	    			if(data.charAt(i+1) == '=') {
	    				temp += String.valueOf(data.charAt(i))+ String.valueOf(data.charAt(i+1));
	    				list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    				temp = "";
	    				i++;
	    			}
	    			
	    			// check for single line comment
	    			// if two divide signs occur simultaneously then it will be single line comment
	    			// simply ignore all the character till line change character
	    			
	    			else if (data.charAt(i+1)=='/') {
	    				
	    				// start reading character after (//)
	    				i+=2;
	    				
	    				while(data.charAt(i)!='\r' && data.charAt(i)!='\n') {
	    					i++;
	    				}
	    				i--;
	    			}
	    			
	    			// if none of above condition is true then it will be divide operator
	    			else {
	    				temp += String.valueOf(data.charAt(i));
	    				list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    				temp = "";
	    			}
	    			break;
	    			
	    		case '%':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for (%, %=)
	    			
	    			if(data.charAt(i+1) == '=') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		case '&':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for logical AND (&&)
	    			
	    			if(data.charAt(i+1) == '&') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		case '|':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for logical OR (||)
	    			
	    			if(data.charAt(i+1)=='|') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		case '!':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for NOT (!) and NOT equals (!=)
	    			
	    			if(data.charAt(i+1)=='=') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		case '<':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for (<, <=)
	    			
	    			if(data.charAt(i+1)=='=') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		case '>':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for (>, >=)
	    			
	    			if(data.charAt(i+1) == '=') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    			
	    		
	    		case '=':
	    			
	    			temp += String.valueOf(data.charAt(i));
	    			
	    			// check for (=, ==)
	    			
	    			if(data.charAt(i+1) == '=') {
	    				temp += String.valueOf(data.charAt(i+1));
	    				i++;
	    			}
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    				temp = "";
	    			break;
	    		}
	    
	    	}
	    	
	    	// if the current character is punctuator then simply add temp to the list, add punctuator to the temp,
	    	// and then add punctuator to the list and empty temp
	    	
	    	else if(isPunctuator(data.charAt(i))) {	
	    		
	    		
	    		if(!temp.isEmpty()) {
	    		
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    			temp = "";
	    		}
	    		
    			temp += String.valueOf(data.charAt(i));
    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
    			temp = "";
    			
    			
	    	}
	    	
	    	// if (.) occurs check for preceding and following characters
	    	
	    	else if(data.charAt(i)=='.' ) {
	    		
	    		// RE to check if all the characters in temp are digits
	    		
	    		boolean valid = Pattern.matches("[0-9]+", temp);
	    		
	    		// if not digits then simply add them as a separate word in list
	    		if(!temp.isEmpty() && !valid) {
	    			
	    			list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
	    			temp = "";
	    		}
	    		
	    		// if characters stored in temp are digits then concatenate (.) with them
	    		temp += String.valueOf(data.charAt(i));
	    		
	    		// if next character after (.) if digit then simply concatenate all following characters 
	    		// till (.), space or line change character
	    		if(Character.isDigit(data.charAt(i+1))) {
	    			
	    			i++;
	    			while(data.charAt(i)!= '.' && data.charAt(i)!= ' ' && data.charAt(i)!= '\n' 
	    					&& data.charAt(i)!= '\r' && i < data.length() -1) {
	    				
	    				temp += String.valueOf(data.charAt(i));
	    				i++;
	    			}
	    			i--;
	    		}
				
	    		// add temp to list
	    		list.add(new ArrayList<String>(Arrays.asList(temp,String.valueOf(ln))));
				
	    		// empty temp
				temp = "";
	    		
	    	}
	    	
	    	// multiline comment, ignore all characters till $
	    	else if(data.charAt(i)=='$') {
	    		
	    		i++;
	    		while(data.charAt(i)!='$') {
	    			
	    			if(data.charAt(i)=='\r' || data.charAt(i)=='\n') {
	    				ln++;
	    			}
	    			i++;
	    		}
	    	}
	    	
	    	// if none of the above condition is true then simply add character to temp 
	    	
	    	else {
	    		
	    		temp+= String.valueOf(data.charAt(i));
	    	}
	    }
	
	    return list;
	}
}
