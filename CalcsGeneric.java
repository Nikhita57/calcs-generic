import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class CalcsGeneric {

	public static void main(String[] args) {
		//A generic version of the probability calculators I made sometime ago.
		//It doesn't necessarily have all of the precise features, but it has
		//the basics allowing the user to plug in any numbers for a particular problem.
		
		//If each result can have a different effect rather than simply causing
		//failure, use the Generic Payout Calculator, coming soon!
		
		//If the probabilities change over time based on the result,
		//that's more difficult to calculate.
		Scanner scan =  new Scanner(System.in);
		
		System.out.println("How many trials do you want?");
		int m = scan.nextInt();
		double arrt[] = new double[m];
		int atts[] = new int[m];
		
		System.out.println("How many different probabilties are there to multiply?");
		int n = scan.nextInt();
		int[] nums = new int[n];
		int[] denoms = new int[n];
		
		System.out.println("Type the probability numerator first, then press enter and type the denominator for each probability.");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scan.nextInt();
			denoms[i] = scan.nextInt();
		}
		
		Random r = new Random();
		double t[] = new double[n];
		System.out.println("How much time does each section take? (Type 0 if that does not matter).");
		for (int a = 0; a < n; a++) {
			t[a] = scan.nextDouble();
		}
		
		for (int j = 0; j < m; j++) {
			boolean goal = false;
            double time = 0;
			int attempts = 0;
			while (!goal) {
				for (int k = 0; k < n; k++) {
					int tr = r.nextInt(denoms[k])+1;
					time += t[k];
					if (tr <= nums[k]) {
						if (k == (n-1)) {
							attempts++;
							goal = true;
						}
					} else {
						attempts++;
						break;
					}
				}
			}
			arrt[j] = time;
			atts[j] = attempts;
		}
		
		double avgtime = 0;
		int avgattempts = 0;
		
		for (int b = 0; b < m; b++) {
			avgtime += arrt[b];
			avgattempts += atts[b];		
		}
		
		System.out.println("Avg time: " + (avgtime/m));
		System.out.println("Avg attempts: " + (avgattempts/m));
		

	}

}
