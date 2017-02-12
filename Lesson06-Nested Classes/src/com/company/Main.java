package com.company;
//ארבעה סוגים של מחלקות מקוננות

public class Main {

    public static void main(String[] args) {

        Shape.Color myColor= new Shape.Color(34,45,100);//מחלקה מקוננת סטטית
        Circle.Point point= new Circle().new Point(4,5);//חייבים ליצור אובייקא מסוג סירקל כדי שנוכל ליצור את הפויינט, מחלקה מקוננת פנימית
        Circle c= new Circle();
        Circle.Point point1= c.new Point(7,8);
    }
}
