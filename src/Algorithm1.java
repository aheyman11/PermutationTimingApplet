import java.util.Random;

/**
 * Created by andreahe on 2/4/15.
 * Implementation of Weiss's first permutation algorithm.
 */
public class Algorithm1 implements PermutationAlgorithm {
        public void permute(int n) {
            int[] permutationArray = new int[n];
            Random generator = new Random();
            for (int i = 0; i < n; i++) {
                boolean alreadyUsed;
                do {
                    permutationArray[i] = generator.nextInt(n) + 1;
                    alreadyUsed = false;
                    for (int j = 0; j < i; j++) {
                        if (permutationArray[j] == permutationArray[i]) {
                            alreadyUsed = true;
                            break;
                        }
                    }
                } while (alreadyUsed);
            }
        }
}
