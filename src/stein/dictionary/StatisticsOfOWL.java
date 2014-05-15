package stein.dictionary;

import java.io.FileNotFoundException;

public class StatisticsOfOWL {
	
	public static void main(String[] args){
		try {
			StatisticsOfOWLBackend st = new StatisticsOfOWLBackend();
			for(int i = 0; i<st.getStatistics().length-1; i++){
				System.out.println(st.getAlphabet()[i]+ " "+ st.getStatistics()[i] + "%\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	}

}
