package com.company;
//3. local inner class
//הגדרת מחלקה בתוך מתודה
//הגדרנו מחלקה בתוך פונקציה והתוקף שלה הוא לאותה מתודה והאובייקט שנוצר בזיכרון מסוג סקוור
//מה מופעל בפועל מה שיש בפועל- כאשר דורסים פונקציה בתוך המחלקה סקוור שבתוך המתודה מייקמיסקוור אז אפשר לקרוא לזה מבחוץ
/**
 * Created by hackeru on 2/12/2017.
 */
public class Ractangle {

    int width,height;

    public Ractangle makeMeSquare(){
        class Square extends  Ractangle{
            public Square(int side){
                this.width=side;
            }
            public int getSide(){
                return this.width;//אי אפשר מבחוץ לגשת לפונקציה גטסייד אבל היא קיימת
            }

            @Override
            public String toString() {
                return "i am a square with side "+ width;//כשדורסים מתודה הוא מגיע לטוסטרינג הזה גם מבחוץ ומפעיל את זה
            }
        }
        Square s=new Square(width);
        s.getSide();//אפשר לגשת רק מתוך הפונקציה
        return new Square(width);
    }


    @Override
    public String toString() {
        return "I am rectangle width: "+ width + "height: "+ height;
    }
}
