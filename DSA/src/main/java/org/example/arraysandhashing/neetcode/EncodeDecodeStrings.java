package org.example.arraysandhashing.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EncodeDecodeStrings {

    public static final String DELIMITER = ":/";

    //Chunked transfer Encoding
    //Encodes a list of strings
    public static String encode(List<String> string){
        return string.stream().map(s ->s.length()+ DELIMITER +s).collect(Collectors.joining());
    }

    public static List<String> decode(String str){

        List<String> decodedString = new ArrayList<>();

        int index = 0;

        while( index < str.length()){

            int delimitedIndex = str.indexOf(DELIMITER , index);

            if( delimitedIndex == -1){
                break;
            }

            int strlength =Integer.parseInt(str.substring(index,delimitedIndex));

            decodedString.add(str.substring(delimitedIndex+2  , delimitedIndex+2+strlength));

            index =  delimitedIndex + 2 +strlength;

        }

        return decodedString;

    }

    public static void main( String args[]){
        String[] str = {"abc", "def","ghi"};
        String encodedStr = encode(Arrays.asList(str)) ;
        System.out.println(encodedStr);
        List<String> decodedStr = decode(encodedStr);
        System.out.println(decodedStr.toString());
    }
}
