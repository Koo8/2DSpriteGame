package SpriteGame.Utils;

import java.io.*;

public class Util {

    public static String loadFileToString(String path) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while( (line = reader.readLine())!= null){
               sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static int parseStringToInt(String string) {
        try{
            return Integer.parseInt(string);
        } catch(NumberFormatException e) {
            System.out.println("not a string");
            return 1; // 1 is for grassTile
        }
    }

}
