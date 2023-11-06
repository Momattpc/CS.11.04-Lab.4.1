import java.util.Scanner;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {

        return s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')';
    }

    // 2. reverseInteger
    public static String reverseInteger(int o) {


        String input = Integer.toString(o);
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output = output + input.charAt(input.length() - 1 - i);
        }
        return output;
    }


    // 3. encryptThis
    public static String encryptThis(String str) {
        String output2 = "";
        int notSpaceCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {

                String word = str.substring(i - notSpaceCounter, i);
                int firstChar = word.charAt(0);
                String firstcha = Integer.toString(firstChar);
                output2 = output2 + firstcha + word.charAt(word.length() - 1) + word.substring(2, word.length() - 1) + word.charAt(1) + " ";
                notSpaceCounter = 0;
            } else if (i == str.length() - 1) {
                String word = str.substring(i - notSpaceCounter, i+1);
                int firstChar = word.charAt(0);
                output2 = output2 + String.valueOf(firstChar) + word.charAt(word.length() - 1) + word.substring(0+notSpaceCounter, word.length() - 1);
                if (word.length() > 2){
                    output2 = output2 + word.charAt(1);
                }
                notSpaceCounter = 0;
            } else {
                notSpaceCounter++;
            }

        }
        return output2;
    }


    //need to use checking for spaces in order to allow for each word to switch


    // 4. decipherThis
    public static String decipherThis(String str) {

        String output2 = "";
        int notSpaceCounter = 0;
        int notNumberCounter = 0;
        int limit = 2;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {

                String word = str.substring(i - notSpaceCounter, i);
                for (int j = 0; j < word.length(); j++){
                    if (!(word.charAt(j) / 10 < 10)){
                        limit = j;
                        break;
                    }
                }

                String firstcha = (word.substring(0,limit));
                int char1 = Integer.valueOf(firstcha);
                char firstchar = (char) char1;

                if (limit == word.length() -1){
                    output2 = output2 + firstchar + word.substring(limit+1, word.length() - 1);
                }
                else {
                    output2 = output2 + firstchar + word.charAt(word.length() - 1) + word.substring(limit+1, word.length() - 1) + word.charAt(limit) + " ";
                }

                notSpaceCounter = 0;
                notNumberCounter = 0;
            }
            else if (i == str.length() -1){
                String word = str.substring(i - notSpaceCounter, i+1);
                for (int j = 0; j < word.length(); j++){
                    if (!(word.charAt(j) / 10 < 10)){
                        limit = j;
                        break;
                    }
                }

                String firstcha = (word.substring(0,limit));
                int char1 = Integer.valueOf(firstcha);
                char firstchar = (char) char1;
                if (limit == word.length() -1){
                    output2 = output2 + firstchar + word.substring(limit, word.length());
                }
                else {
                    output2 = output2 + firstchar + word.charAt(word.length() - 1) + word.substring(limit+1, word.length() - 1) + word.charAt(limit) + " ";
                }
            }

            else {
                notSpaceCounter++;
            }

        }
        return output2.trim();
    }
}