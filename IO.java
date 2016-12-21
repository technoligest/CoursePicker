/*This file is for all IO for running the program.
 *Whenever a new format needs to be read, it needs to be done within here.
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class IO {
	public static Degree readDegree(Scanner kb){
		Degree result=null;
		if(kb.hasNext()){
			List<String> temp=parseLine(kb.nextLine());
			if(temp.size()<1)
				return null;
			result=new Degree(temp.get(0), (ArrayList)parseLine(kb.nextLine()));
		}
		return result;
	}
	public static Student readStudent(Scanner kb){
		Student result=null;
		if(kb.hasNext()){
			
			List<String> temp=parseLine(kb.nextLine());
			if(temp.size()<3)
				return null;
			result= new Student(temp.get(0), temp.get(1), temp.get(2),(ArrayList)parseLine(kb.nextLine()));
		}

		return result;
	}
	public static TimeTable readTimeTable(Scanner kb) {

		TimeTable result= new TimeTable();
		int[]count= new int[50];
		while (kb.hasNext()) {
			// use comma as separator
			List<String> temp= parseLine(kb.nextLine());
			if(temp.size()==23){
				result.addSection(new Section((ArrayList)temp));
			}
			count[temp.size()]++;
		}

		System.out.println();
		for(int i=0; i<count.length; ++i) {
			if(count[i]>1)
			System.out.println(i+" "+count[i] + "\t");
		}

		return result;

	}
	
	
	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE = '"';
	public static List<String> parseLine(String cvsLine) {
		return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
	}

	public static List<String> parseLine(String cvsLine, char separators) {
		return parseLine(cvsLine, separators, DEFAULT_QUOTE);
	}

	public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

		List<String> result = new ArrayList<>();

		//if empty, return!
		if (cvsLine == null && cvsLine.isEmpty()) {
			return result;
		}

		if (customQuote == ' ') {
			customQuote = DEFAULT_QUOTE;
		}

		if (separators == ' ') {
			separators = DEFAULT_SEPARATOR;
		}

		StringBuffer curVal = new StringBuffer();
		boolean inQuotes = false;
		boolean startCollectChar = false;
		boolean doubleQuotesInColumn = false;

		char[] chars = cvsLine.toCharArray();

		for (char ch : chars) {

			if (inQuotes) {
				startCollectChar = true;
				if (ch == customQuote) {
					inQuotes = false;
					doubleQuotesInColumn = false;
				} else {

					//Fixed : allow "" in custom quote enclosed
					if (ch == '\"') {
						if (!doubleQuotesInColumn) {
							curVal.append(ch);
							doubleQuotesInColumn = true;
						}
					} else {
						curVal.append(ch);
					}

				}
			} else {
				if (ch == customQuote) {

					inQuotes = true;

					//Fixed : allow "" in empty quote enclosed
					if (chars[0] != '"' && customQuote == '\"') {
						curVal.append('"');
					}

					//double quotes in column will hit this!
					if (startCollectChar) {
						curVal.append('"');
					}

				} else if (ch == separators) {

					result.add(curVal.toString());

					curVal = new StringBuffer();
					startCollectChar = false;

				} else if (ch == '\r') {
					//ignore LF characters
					continue;
				} else if (ch == '\n') {
					//the end, break!
					break;
				} else {
					curVal.append(ch);
				}
			}

		}

		result.add(curVal.toString());

		return result;
	}

}