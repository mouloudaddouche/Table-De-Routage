package main;

import java.lang.Math;
public class Outils {
	

	public static int Rand(int max,int min) { 
	        int range = max - min + 1; 
	        int rand = (int)(Math.random() * range) + min; 
	        return rand;
	}
}

