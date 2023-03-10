import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Collections {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("H:/Stas/Education/JavaRush/JavaRushUniversity" +
                "/Java Syntax/Collection/buildings.csv");
        int lenght = stream.available();
        byte [] data = new byte[lenght];
        stream.read(data);

        String text = new String(data);

        ArrayList<String []> lineWords = new ArrayList<>();

        String [] lines = text.split("\n");
        for (String line : lines){
            String [] words = line.split(",");
            lineWords.add(words);
        }

        //Обычный HashMap
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        for (String [] words : lineWords){
//            if (map.containsKey(words[9])){
//                Integer k = map.get(words[9]);
//                k = k + 1;
//                map.put(words[9], k);
//            } else {
//                map.put(words[9], 1);
//            }
//        }
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (String [] words : lineWords){
            if (map.containsKey(words[9])){
                Integer k = map.get(words[9]);
                k = k + 1;
                map.put(words[9], k);
            } else {
                map.put(words[9], 1);
            }
        }

//        System.out.println("Построенно домов в этом году 1980: " + map.get("1980"));
//        System.out.println("Построенно домов в этом году 1999: " + map.get("1999"));

        for (String key : map.keySet()){
            System.out.println("Год: " + key + " Количество: " + map.get(key));
        }
//        //Обычный ArrayList
//        for (String [] words : lineWords) {
//            if (words[9].equals("1999")) {
//                for (String word : words) {
//                    System.out.print(word);
//                    System.out.print("|");
//                }
//                System.out.println("--------------------------------------");
//            }
//        }
    }
}