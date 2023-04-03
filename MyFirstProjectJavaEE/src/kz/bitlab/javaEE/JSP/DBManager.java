package kz.bitlab.javaEE.JSP;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Item>items = new java.util.ArrayList<>();
    protected static void addItem(Item item){
        items.add(item);
    }
    public static ArrayList<Item> getAllItems(){
        return items;
    }
}