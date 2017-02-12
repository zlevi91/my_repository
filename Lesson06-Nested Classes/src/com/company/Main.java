package com.company;
//ארבעה סוגים של מחלקות מקוננות

public class Main {

    public static void main(String[] args) {

        Shape.Color myColor= new Shape.Color(34,45,100);//מחלקה מקוננת סטטית
        Circle.Point point= new Circle().new Point(4,5);//חייבים ליצור אובייקא מסוג סירקל כדי שנוכל ליצור את הפויינט, מחלקה מקוננת פנימית
        Circle c= new Circle();
        Circle.Point point1= c.new Point(7,8);
        Circle.Point point2=c.new Point(87,32);
        c.setCenter(point1);

    }
    //אילוף כלבים
    static Dog trainDog(Dog d){
        class TrainedDog extends Dog{
            @Override
            void bark() {
                System.out.println("abcdefghijklmnop...");
            }
        }
        TrainedDog trainedDog=new TrainedDog();
        trainedDog.name=d.name;
        return trainedDog;
    }
}

class Dog{
    String name;
    void bark(){
        System.out.println("waf waf..." +name);
    }
}
