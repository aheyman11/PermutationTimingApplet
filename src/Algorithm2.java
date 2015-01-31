import java.util.Arrays;
import java.util.Random;

/**
 * Created by andreahe on 1/29/15.
 */
public class Algorithm2 implements PermutationAlgorithm {
    public void permute(int n) {
        int[] permutationArray = new int[n];
        boolean[] used = new boolean[n];
        Random generator = new Random();
        for (int i = 0; i < n; i++) {
            while (true) {
                permutationArray[i] = generator.nextInt(n) + 1;
                if (!used[permutationArray[i] - 1]) {
                    used[permutationArray[i]-1] = true;
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(permutationArray));
    }
}
