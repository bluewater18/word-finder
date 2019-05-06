import java.util.*;

public class App {
    public static void main(String [] args) {
        WordReader wordReader = new WordReader();
        Permuter permuter = new Permuter();

        String in = ("pitul").toLowerCase();

        //List<String> out = new ArrayList<String>();
        Set<String> out = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                else if (o1.length()< o2.length())
                    return -1;
                else
                    return o1.compareTo(o2);
            }
        });


        //Set<String> out = new HashSet<String>();





        for(String s : permuter.permute(in)){
            if(wordReader.getWords().contains(s)){
//                System.out.println(s);
//                System.out.println(out.add(s));
                if(s.length()>=2)
                    out.add(s);
            }

        }
        System.out.println("Words for "+in+ ":");

        int length = 0;
        for(String s : out){
            if(s.length() > length){
                length = s.length();
                System.out.println("---- length " + length + " ----");
            }
            System.out.println(s);
        }
    }


}
