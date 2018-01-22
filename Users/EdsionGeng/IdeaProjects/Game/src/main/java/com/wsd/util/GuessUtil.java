package com.wsd.util;
import java.util.Random;
public class GuessUtil {
	Random random = new Random();
	public String gameRunSmall() {
		int a[] = {1, 2, 3};
		int m = random.nextInt(3);
		if (a[m] == 1) {
			return "small";
		}
		return "big";
	}
	public String gameRunBig() {
		int a[] = {1, 2, 3};
		int m = random.nextInt(3);
		if (a[m] == 1) {
			return "big";
		}
		return "small";
	}
	public String gameRunFu() {
		int a[] = {2, 1, 3, 4};
		int m = random.nextInt(4);
		if (a[m] == 1) {
			return "fu";
		}
		return "small";
	}
}