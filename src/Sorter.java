import java.util.*;

public class Sorter {

	public static void main(String args[]) {
		List<Integer> input;
		List<Integer> output;
		input = takeInput();
		output = sort(input);
		for(int i : output){
			System.out.println(i);
		}

	}

	private static List<Integer> sort(List<Integer> input) {
		int length = input.size();
		int height = Collections.max(input);
		int[][] abacus = new int[length][height];
		List<Integer> output = new ArrayList<Integer>();
		//fill abacus
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < input.get(i); j++) {
				abacus[i][j] = 1;
			}
		}
		//apply gravity
		for (int i = 0; i < height; i++){
			int sum = 0;
			for (int j = 0; j < length; j++){
				sum += abacus[j][i];
				abacus[j][i] = 0;
			}
			for (int j = length - sum; j < length; j++){
				abacus[j][i] = 1;
			}
		}
		//fill list
		for (int i = 0; i < length; i++){
			int sum = 0;
			for (int j = 0; j < height; j++){
				sum += abacus[i][j];
			}
			output.add(sum);
			sum = 0;
		}
		return output;
	}

	private static List<Integer> takeInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input a list of numbers, one per line. Any non-number will start the sort.");
		List<Integer> numbers = new ArrayList();
		int value = 0;
		while (scanner.hasNextInt()){
			value = scanner.nextInt();
			numbers.add(value);
		}
		return numbers;
	}


}
