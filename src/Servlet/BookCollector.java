package Servlet;

import java.util.LinkedHashMap;

/**
 * @author yhs
 * @date 2020/4/29 19:54
 * @description
 */
public class BookCollector {
    private static LinkedHashMap<Integer,Book> linkedHashMap = new LinkedHashMap<>();
    static {
        linkedHashMap.put(1,new Book(1,"javaWeb"));
        linkedHashMap.put(2,new Book(2,"coreJava"));
        linkedHashMap.put(3,new Book(3,"mysql"));
        linkedHashMap.put(4,new Book(4,"javaScript"));
        linkedHashMap.put(5,new Book(5,"hadoop"));
    }

    public static LinkedHashMap<Integer,Book>getAllBook(){
        return BookCollector.linkedHashMap;
    }
    public static String getById(String idString){
        int id = Integer.parseInt(idString);
        return linkedHashMap.get(id).getName();
    }
}

class Book{
    private int id;
    private String name;

    public Book() {
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
