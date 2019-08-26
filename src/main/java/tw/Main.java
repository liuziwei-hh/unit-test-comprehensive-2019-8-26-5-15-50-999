package tw;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import tw.commands.GuessInputCommand;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {

    private static final int RUN_TIMES = 6;
    static int A=0;
    static int B=0;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < RUN_TIMES; i++) {
            String input = new GuessInputCommand().input();
            set_Random_Not_Same();
        } 
    }

	public static void set_Random_Not_Same() throws IOException {
		Set<Integer> answer = new HashSet<>();
		if (answer.size() < 4) {
			answer.add(new Random().nextInt(9));
		}
		Iterator<Integer> answerIt = answer.iterator();
		System.out.println(answerIt);
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String[] guess = (guessInputCommand.input()).split(" ");
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < set.size(); i++) {
			set.add(Integer.parseInt(guess[i]));
			System.out.println(guess[i]);
		}
		Iterator<Integer> setIt = set.iterator();
		for (int i = -1; i < answer.size() - 1; i++) {
			for (int j = -1; j < set.size() - 1; i++) {
				if (answerIt.next() == setIt.next()) {
					if (i == j) {
						A = A + 1;
					}
					B = B + 1;
				}
			}
		}
		System.out.println(A+"A"+B+"B");
	} 
}
