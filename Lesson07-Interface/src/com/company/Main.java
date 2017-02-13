package com.company;
//האינטרפס מתאים למבחן האיז אה.. וגם מתאים לאינסטנס אוף- בודק האם נעזה דאוןקאסט למחלקה מסויימת האם זה יכשל או לא
//

public class Main {

    public static void main(String[] args) {

        Shape shape = new Cylinder();
        Rollable rollable = new Ball();//הרחבנו את המרחק בין סוג האובייקט לסוג המשתנה
        rollable.roll(13);//אם נעשה לו דאוןקאסט לבול נוכל להפעיל את המתודה באונס בלי זה אי אפשר להפעיל את המתודה
        Drawable[] drawables;

    }

    //מיון בועות- משווה כל נתון עם הנתון שלידו ואם השני קטן יותר אז מחליפים בינהם
    static void bubbleSort(int[] arr){
        int upTo=arr.length-1;
        boolean isSorted=false;
        while(!isSorted){
            isSorted=true;
            for (int i = 0; i <upTo ; i++) {
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
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

interface Comparable{
    public int compareTo(Object obj);//למה התכוון המשורר במתודה הזאת? התכוון שיוחזר מהמתודה מספר 1,0,-1
    // אם האובייקט שעליו הופעלה המתודה יותר גדול יוחזר 1 אם שווים יוחזר 0 ואם הוא קטן יוחזר -1
}

