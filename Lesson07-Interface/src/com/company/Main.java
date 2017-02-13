package com.company;
//האינטרפס מתאים למבחן האיז אה.. וגם מתאים לאינסטנס אוף- בודק האם נעזה דאוןקאסט למחלקה מסויימת האם זה יכשל או לא
//

import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {

        Shape shape = new Cylinder();
        Rollable rollable = new Ball();//הרחבנו את המרחק בין סוג האובייקט לסוג המשתנה
        rollable.roll(13);//אם נעשה לו דאוןקאסט לבול נוכל להפעיל את המתודה באונס בלי זה אי אפשר להפעיל את המתודה
        Drawable[] drawables;

        Point[] myPoint={
                new Point(4,5),
                new Point(1,2),
                new Point(7,1),
                new Point(98,22),
                new Point(2,7),//אותו מרחק כמו ה7,2 אבל פה הזוית יותר גדולה
                new Point(7,2)
        };
        bubbleSort(myPoint);//ממיין את המערך

        for (int i = 0; i <myPoint.length ; i++) {
            System.out.print(myPoint[i]);
        }

    }

    //מיון בועות- משווה כל נתון עם הנתון שלידו ואם השני קטן יותר אז מחליפים בינהם
    static void bubbleSort(Comparable[] arr){
        int upTo=arr.length-1;
        boolean isSorted=false;
        while(!isSorted){
            isSorted=true;
            for (int i = 0; i <upTo ; i++) {
                if(arr[i].compareTo(arr[i+1])>0){//גדול מ0 כי אמור להחזיר חיובי שלילי או 0
                    Comparable temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    isSorted=false;//אם יש פעם שהוא לא נכנס לעשות שום החלפה אז ז"א שהוא סיים את המיון (ולא סומן הדגל בשקר)
                }
            }
            upTo--;//  פחות האיבר האחרון כיון שבכל איטרציה האיבר האחרון הוא האיבר שנכנס למקום שלו
        }
    }
}
interface Rollable{
    void roll(float degree);
}

interface Drawable{
    void draw(boolean[][] canvas);
}

class Ball implements Rollable{

    void bounce(){

    }

    //חייב לממש את הפונקציה הזאת
    @Override
    public void roll(float degree) {

    }
}

class Shape implements Drawable {

    @Override
    public void draw(boolean[][] canvas) {

    }
}

class Circle implements Drawable,Rollable{

    @Override
    public void roll(float degree) {

    }

    @Override
    public void draw(boolean[][] canvas) {

    }
}
//תמיד הירושה קודמת לאינטרפייס
class Cylinder extends Shape implements Rollable{

    @Override
    public void roll(float degree) {

    }
}
interface Edible{
    void eat (String foo);
}
//אינטרפייס שגאווה כתבו
//
/*interface Comparable{
    public int compareTo(Object obj);//למה התכוון המשורר במתודה הזאת? התכוון שיוחזר מהמתודה מספר 1,0,-1
    // אם האובייקט שעליו הופעלה המתודה יותר גדול יוחזר 1 אם שווים יוחזר 0 ואם הוא קטן יוחזר -1
}*/

class Point implements Comparable{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    //מכריע מי יותר גדול בין 2 נקודות
    @Override
    public int compareTo(Object o) {
        if(o== null || !(o instanceof Point))
            throw new InvalidParameterException("must sent a valid point");
        if(o==this)
            return 0;
        Point other=(Point)o;
        double d1=this.distanceFromOrigin();
        double d2=other.distanceFromOrigin();
        if(d1>d2)
            return 1;
        else if(d1<d2)
            return -1;
        if(this.x>=0){
            if(other.x>=0) {//אם שני האיקסים חיוביים ז"א ברביע הראשון או הרביעי
                if (this.y * other.y >= 0) {//וגם שני הוויים חיוביים או שניהם שליליים כי זווית יותר גדולה זה זה עם הוואי הגדול יותר
                    if (this.y >= other.y)
                        return 1;
                    else
                        return -1;
               }else{//אם הם שוני סימן.. שניהם בצד הימני
                    if(this.y<0)//אז הדיס נמצא ברביע הרביעי ואזר ברביע הראשון אז זה שברביע הרביעי הזווית יותר גדולה
                        return 1;
                    else
                        return -1;
                }
            }else{//אם אזר נקודה איקס שלילי ואזר נמצא ברביע ...
                if (this.y>=0)
                    return -1;
                else
                    return 1;

            }
        }else {
            //כל מה שעשינו זה תחת העולם של דיס נקודה איקס גדול מ0
            //מה שנשאר לכתוב זה שדיס נקודה איקס קטן מ0 רביע שלישי ורביעי
        }
        return 0;
    }

    double distanceFromOrigin(){
        return Math.sqrt(x*x + y*y);//המרחק מראשית הצירים
    }
}

