package htables;

import htables.list.List;
import htables.map.HashMap;
import htables.map.MyKey;
import htables.map.MyValue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HTables {
    static int testNumber,aux;
    private static Scanner openFile(){
        FileReader file;
        Scanner read;
        try {
            file = new FileReader("input.txt");
            read = new Scanner(file);
            return read;
        } catch (FileNotFoundException ex) {
            System.out.println("File open error");
            return null;
        }
    }
    static void getValues(String keyString, HashMap hmap, int bucketNumber){
        List valList = new List();
        MyKey key = new MyKey(keyString,valList);
        int hash = key.hashCode();
        List list = (List)hmap.get(key);
        System.out.println(list.toString());
    }
    
    static void insertValue(String keyString, String val, HashMap hmap, int bucketNumber){
        List valList = new List();
        MyKey key = new MyKey(keyString,valList);
        int hash = key.hashCode();
        MyValue v = new MyValue(val);
        if(!hmap.put(key, v)){
            System.out.println("Insert error");
        }
    }
    static void checkKey(String keyString, HashMap hmap, int bucketNumber){
        List valList = new List();
        MyKey key = new MyKey(keyString,valList);      
        System.out.println(hmap.containsKey(key));
    }
    
    public static void main(String[] args) {
        int bucketNumber = 5;
        System.out.println("Test");
        
        Scanner read = openFile();
        if(read == null){
            System.out.println("File open error");
            return ;
        }
        System.out.println("File open error");
        HashMap hmap = new HashMap(bucketNumber);
        testNumber = read.nextInt();
        while(read.hasNextLine()){
            aux = read.nextInt();
            System.out.println(aux);
            switch(aux){
                case 0:
                    getValues(read.next(),hmap,bucketNumber);
                    break;
                case 1:
                    insertValue(read.next(),read.next(),hmap,bucketNumber);
                    break;
                case 2:
                    checkKey(read.next(),hmap,bucketNumber);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Wrong input (action type)");
                    break;
            }
        }
        read.close();
    }

}
