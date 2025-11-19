// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.out.println(minus(2,7));
		System.out.println(times(-2,3));
	}  

	// Returns x1 + x2
public static int plus(int x1, int x2) {
		if (x2 > 0){
			for (int i = 0 ; i < x2 ; i++){
			x1++; 
			}
		} else if (x2 < 0){
			for (int i = 0 ; i <- x2 ; i++){
				x1--; 	
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2){
		if (x2 > 0){
			for (int i = 0; i < x2; i++){
			x1--;
		}
	} else if (x2 < 0) {
		for (int i = 0; i<-x2; i++){
			x1++;

		}
	}
		return x1;
}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multi = 0;
		if (x2 == 0 || x1 == 0){ 
			return multi;
		} else if ((x2 < 0 && x1 > 0) ^ (x1 < 0 && x2 > 0)){ 
			int larger = x1 > x2 ? x1 : x2;
			int smaller = x1 > x2 ? x2 : x1;
			multi = smaller;
			for (int i = 1 ; i < larger ; i++){
				multi = plus(multi , smaller); 
			}
		} else if(x1 < 0 && x2 < 0) { 
			multi = x1;
			for (int i = 1 ; i > x2 ; i--){
				multi = minus(multi , x1); 
			}
		} else {
			multi = x2; 
			for (int i = 1 ; i < x1 ; i++){
				multi = plus(multi,x2); 
			}
		}
		return multi; 
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0){
			return 1;
		}
		
		int pow = x;
		for (int i = 1; i < n; i++){
			pow = times(pow, x); 
		
			}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2){ 
		
		int counter = 0;

		if (x2 == 0){
			return -1;
		} else if (((x2<0 && x1<0) && (x1>x2)) || ((x2>0 && x1>0) && (x1<x2))){
			return 0;
		} else if (x1 < 1 && x2 > 0){
			x1 = times (x1, -1);
			while (x2 <= x1){
				x1 = minus(x1, x2);
				counter++;
			}
			return times (counter, -1);
		} else if (x2 < 0 && x1 < 0){
			x1 = times (x1,-1);
			x2 = times (x2,-1);
			while (x2 <= x1){
				x1 = minus(x1,x2);
				counter++;
			} 
			return counter;
		} else {
			while (x2 <= x1){
				x1 = minus(x1,x2);
				counter++;
			}
			return counter;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int div = div(x1 , x2);
		int multi = times(div , x2);
		int remainder = minus(x1, multi);
		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 1;

		if (x == 0){
			return 0;
		} else if (x < 0){
			return -1;
		} else {
			while (times(i, i) <= x){
				i = plus(i, 1);
			}
		}
		return minus(i, 1);
	}
}