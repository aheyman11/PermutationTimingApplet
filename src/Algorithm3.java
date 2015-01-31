import java.util.Arrays;
import java.util.Random;

/**
 * Created by andreahe on 1/31/15.
 */
public class Algorithm3 implements PermutationAlgorithm{
    public  void permute (int n) {
        int[] permutationArray = new int[n];
        Random generator = new Random();
        for (int i = 0; i < n; i++){
            permutationArray[i] = i+1;
        }
        for (int i = 1; i < n; i++) {
            int randomInt = generator.nextInt(i+1);
            int temp = permutationArray[i];
            permutationArray[i] = permutationArray[randomInt];
            permutationArray[randomInt] = temp;
        }
        //System.out.println(Arrays.toString(permutationArray));
    }
}
