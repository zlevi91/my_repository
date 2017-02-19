package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList<Dog> linkedList=new LinkedList<Dog>();
        linkedList.add(new Dog());
        LinkedList<Cat> cats=new LinkedList<>();//אפשר להשאיר פה את הסוגריים המשולשים ריקים כי הוא מבין שצריך לשים קאט

        //linkedList.add(new Cat());//אי אפשר להפעיל את האדד עם קאט כי הוא יכול לקבל רק דוג

        Pair<Dog,Cat> pair=new Pair<>(new Dog(),new Cat());
        Pair<Dog,Dog> pair2=new Pair<>(new Dog(),new Dog());

        List list=new LinkedList();//לא נתנו לאובייקט טיפוס גנרי ר=אז שניהם נוצרו מסוג אובגיקט
        //List<Object> list1=new LinkedList<Object>();//אם היינו כותבים ככה במקום השורה הקודמת הוא לא היה מקבל את ההמרה אחכ לסטרינג
        //List<String> strings=list //אם היינו עושים המרה לאובגקט הוא כן היה מקבל את זה
        list.add("First");
        list.add("Second");
        list.add(123);
        List<String> strings=list;//עשינו שהפויינטר יצביע לאותו מקום בזיכרון אבל הפעם זה ליסט של סטרינגים במקום ליסט של אובגקטים
        //String s1=strings.get(2);//פה הוא יפול כי זה לא מסןג סטרינג אלא מסוג אינט
        String s1=strings.get(0);
        System.out.println(s1);
    }


}

class Dog{

}

class Cat{

}
