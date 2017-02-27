package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //כל אלא אינטרפייסים
	    // Important Abstract Classes and Interfaces regarding Collections:
        // Iterable
        // Collection- קבוצה אין חשיבות לסדר
        // List- רשימה יש חשיבות לסדר
        // Set-אין משמעות למקום או שאתה נמצא בקבוצה או שאתה לא נמצא בקבוצה - לא מעניין האינדקס ,קבוצה בלי כפיליות
        // SortedSet- סט ממוין
        // NavigableSet- אם נשאל האם איבר קיים אז אפר להגדיר תנאים של בערך אם איבר נמצא והוא ימצא את זה
        // Queue- תור, פיפו
        // Dequeue- מחסנית, ליפו
        // Map- אוסף של זוגות קי ווליו ככה שבאוסף אין 2 זוגות עם אותו קי וכן יכול להיות 2 זוגות עם אותו וליו
        // Map<Integer, User> map- שכלול של סט כי יש גם ווליו להבדיל מסט שזה רק הקיאים
        // SortedMap, NavigableMap


        //מחלקות שמממשות את האינטרפייסים הנ"ל
        // ArrayList
        // LinkedList
        // HashSet
        // TreeSet
        // HashMap
        // TreeMap- יכול לתת לך את הדברים ממויינים אבל לא ממיין אותו
        // PriorityQueue- תור קדימיות

        //השימוש בהאק קוד זה רק לשימוש מקדים לפני איקוואל... רוצים לחסוך את ההפעלה של איקוואל
        //אם שני אובייקטים אין להם אותו האשקוד איקוואלס בוודאות יחסיר פולס
        //המטרה לממש את האשקוד בצורה כזאת שבהכרח אם איקוואלס יחזיר טרו האשקודים יהיו שונים
        //
        Set<Point> points=new HashSet<>();
        Point p1= new Point(4,5);
        Point p2= new Point(3,4);
        points.add(p1);
        points.add(p2);

        //Set<User> users=new HashSet<>();
        //במקום להגדיר האשקוד איקוואל וסט נעשה :
        //מאפ זה אינטרפייס והאשמאפ זה מחלקה שמממשת את המאפ
        //יש להם זוגות של יוזר- ווליו מסוג יוזר והקאי הוא מסוג סטרינג- וסיסמא שאין חזרה על היוזר
        //המתודות החדשות פוט וגט וזה פוט ולא אדד כי הוא מוסיף רק אם אין יוזר כזה
        //זה אחלה דבר לשמירת יוזרים
        Map<String,User> users=new HashMap<>();
        User user1=new User("hadasa", "12345");
        User user2= new User("zofiya", "123456");
        //פוט אומר שאם הקאי הזה לא קיים אז נוסיף אותו
        // ואם הוא קיים אני מעדכן את הווליו שלו-הפסוורד שלו, להיות מה ששלח לפונקציה פוט
        users.put(user1.getUserName(),user1);
        users.put(user2.getUserName(),user2);

        //לא מחפשים לפי וליו אלא רק לפי קאי
        User user3= users.get(user1.getUserName());
        //אי אפשר לעבור על היוזרס בפוראיץ אבל על הוליו שלו כן אפשר
        System.out.println(users.size());
        Iterator<User> allTheUsers= users.values().iterator();
        while (allTheUsers.hasNext()){//ללואה שעוברת על כל היוזרים
            User u=allTheUsers.next();
        }
        char []c={'e','r','r','t','y','u'};
        char []c1={'t','y','u','e','r','r','t','y','u'};
        MyString myString=new MyString(c);
        MyString m=new MyString(c1);
        System.out.println(myString.indexOf1(m));

        char []c2={'e','r','r','t','y','u'};
        MyString m2= new MyString(c2);
        MyString m3= m2.toUpper();

        for (int i = 0; i <m3.getValue().length ; i++) {
            System.out.print(m3.getValue()[i]);

        }
        MyString m4= new MyString(c2);
        System.out.println();
        boolean b = m2.equals(m);
        System.out.println(b);


    }
}

class User{
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*@Override
    public int hashCode() {
        int passwordHashCode= password.hashCode();
        return 11*userName.hashCode()^7*passwordHashCode^ 17*passwordHashCode;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }*/
}
