import java.util.ArrayList;
import java.util.List;

public class Permuter {
// Java program to print all permutations of a
// given string.

    List<String> perms;
    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        Permuter permutation = new Permuter();
        permutation.permute(str, 0, n - 1);
    }

    public Permuter() {

    }

    public List<String> permute(String string){
        int n = string.length();
        perms = new ArrayList<String>();
        permute(string, 0, n-1);
        for(int j = 0; j < 50; j++){
            System.out.print(j+"...");
            string = randomizeString(string);
            for(int i = 0; i<n; i++) {
                String s1 = string.substring(i, n - 1);
                permute(s1, 0, s1.length() - 1);
                String s2 = string.substring(0, 1);
                permute(s2, 0, s2.length() - 1);
            }
        }
        return  perms;


    }

    public void shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        System.out.println(output.toString());
    }

    private String randomizeString(String input) {
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
                perms.add(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

// This code is contributed by Mihir Joshi
}
