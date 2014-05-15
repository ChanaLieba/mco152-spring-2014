package stein.maxsum;

import java.util.Scanner;

public class MaxSum {
	
	int[][] field;
	
	public MaxSum(int a, int b){
		field = new int[a][b];
	}
	
	public int maxValue(int[][] field) {
	    int r = field.length;
	    int c = field[0].length;
	    int[][] maxValues = new int[r][c];
	    for (int i = 0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	            if (i == 0 && j == 0) {
	                maxValues[i][j] = field[i][j];
	            } else if (i == 0) {
	                maxValues[i][j] = maxValues[i][j-1] + field[i][j];
	            } else if (j == 0) {
	                maxValues[i][j] = maxValues[i-1][j] + field[i][j];
	            } else {
	                maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i-1][j]) + field[i][j];
	            }
	        }
	    }
	    return maxValues[r-1][c-1];
	}   
	public int[][] getField() {
		return field;
	}

	public void setField(int[][] field) {
		this.field = field;
	}

	public int max(int r, int c) {
	    //Base case
	    if (r == 0 && c == 0) {
	        return field[r][c];
	    }
	    int maxTop = -1000, maxLeft = -1000;
	    //We can't come from the top if we're in the top row
	    if (r != 0) {
	        maxTop = field[r-1][c];
	    }
	    if (c != 0) {
	        maxLeft = field[r][c-1];
	    }
	    return Math.max(maxTop, maxLeft) + field[r][c];
	}
	public int checkMax(){
		Integer highest = 0;
		for(int i = 0; i<field.length; i++){
			for(int j = 0; j<field.length; j++){
				if(field[i][j]>highest){
				highest = field[i][j];
				}
			}
		}
		return highest;
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the question mark int[?][]");
		int aa = scanner.nextInt();
		System.out.println("Please enter the question mark int[][?]");
		int b = scanner.nextInt();
		int[][] i = new int[aa][b];
		System.out.println("Please enter the numbers you would like to add separated by a space");
		MaxSum m = new MaxSum(aa,b);
		m.setField(i);
		int a = m.max(i.length-1, i[0].length-1);
		if(a>m.checkMax()){
		System.out.println(m.max(i.length-1, i[0].length-1));	
	} else {
		System.out.println(m.checkMax());
	}



}}