package com.example.PackageChallenge;

public class Series {
	
	public static double nSum(int n) {
		double temp = 0;
		for(int i =1; i<=n; i++) {
			temp = temp + i;
		}
		return temp;
	}
	
	public static double factorial(int n) {
		double temp = 1;
		for(int i =1; i<=n; i++) {
			temp = temp * i;
		}
		return temp;
	}
	
	public static int fibonacci(int n) {
		if(n==0) {
			return 0;
		} else if (n ==1) {
			return 1;
		} else {
			return ((n-1) + (n-2));
		}
	}
}