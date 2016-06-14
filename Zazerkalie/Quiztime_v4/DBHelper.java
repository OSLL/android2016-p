package com.example.weller.successapp;

/**
 * Created by Weller on 09.06.2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 6/7/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "quiestions"; // Имя базы данных
    private static final int DB_VERSION = 1; // Верcия базы данных

    DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE APPTABLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "QUES TEXT, " +
                "VARS TEXT, " +
                "ANS TEXT," +
                "STAT INTEGER);");

        db.execSQL("CREATE TABLE PLAYERTABLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "SCORE INTEGER);");

        ContentValues value = new ContentValues();
        value.put("QUES","Какое из представленных деревьев является хвойным?");
        value.put("VARS","#сосна#береза#дуб#клен");
        value.put("ANS","а");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто придумал радио?");
        value.put("VARS","#Тесла#Попов#Лебедев#Лейбниц");
        value.put("ANS","б");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто первым побывал в космосе?");
        value.put("VARS","#Гагарин#Терешкова#Армстонг#Стрелка");
        value.put("ANS","г");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто из представленных змей не является ядовитым?");
        value.put("VARS","#Гремучая змея#Шипохвост Австралийский#Адельфийская змея#Гадюка Обыкновенная");
        value.put("ANS","в");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой из представленных фильмов был выпущен студией Pixar?");
        value.put("VARS","#В поисках Немо#Тачки#Вверх#Шрек");
        value.put("ANS","a");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Главного персонажа какого сериала зовут Барби?");
        value.put("VARS","#Во все тяжкие#Сплетница#Под куполом#Офис");
        value.put("ANS","в");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой главой заканчивается 'Герой нашего времени'?");
        value.put("VARS","#Княжная Мэри#Тамань#Бэла#Фаталист");
        value.put("ANS","г");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто из этих людей являются скрипачем? ");
        value.put("VARS","#Томас Адес#Ванесса Мэй#Пабло Казаль#Себастьян Бах");
        value.put("ANS","б");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какое дерево используется для изготовления газет?");
        value.put("VARS","#дуб#вяз#ива#ель");
        value.put("ANS","г");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой фрукт самый распространенный в мире?");
        value.put("VARS","#яблоко#апельсин#банан#ананас");
        value.put("ANS","в");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой сахар добывали в глубокой древности в Китае?");
        value.put("VARS","#Сорговый#Ягре#кленовый#свекольный");
        value.put("ANS","б");
        value.put("STAT",0);
        db.insert("APPTABLE", null, value);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
