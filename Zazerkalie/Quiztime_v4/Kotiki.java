package com.example.weller.successapp;

/**
 * Created by Weller on 09.06.2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Kotiki extends SQLiteOpenHelper {
    private static final String DB_NAME = "quiestions"; // Имя базы данных
    private static final int DB_VERSION = 1; // Верcия базы данных

    Kotiki(Context context) {
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
        value.put("QUES","Кто из писателей, заметив свободолюбивый характер кошки, написал сказку об этом животном «Кошка, которая гуляла сама по себе»");
        value.put("VARS","#Р.Кипплинг#А.С.Пушкин#Г.Х.Андерсен#К.Г.Паустовский");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какую египетскую богиню изображали женщиной с кошачьей головой?");
        value.put("VARS","#Аш#Бастет#Исида#Маат");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой континент является родиной домашней кошки? ");
        value.put("VARS","#Евразия#Австралия#Америка#Африка");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какая священная книга с уважением отзывается о кошке — совсем не так, как о «презренной собаке»?");
        value.put("VARS","#Библия#Трипитака#Коран#Гаты");
        value.put("ANS","в");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES"," В какой священной книге нет ни одного упоминания о кошке? ");
        value.put("VARS","#Библия#Трипитака#Коран#Гаты");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Как звали кота в романе Михаила Булгакова «Мастер и Маргарита»?");
        value.put("VARS","#Берлиоз#Бегемот#Мурчум#Римский");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какая страна в мире занимает первое место по численности домашних кошек?");
        value.put("VARS","#Египет#Австралия#США#Англия");
        value.put("ANS","в");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Как звали самого знаменитого кота из мультсериала Уолта Диснея.");
        value.put("VARS","#Том#Кот в сапогах#Гарфилд#Тулуза");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какая порода кошек записана под номером один в стандартах Международной Федерации европейских любителей кошек ('ФИФЕ,)?");
        value.put("VARS","#Русская голубая#Черная персидская кошка#Сиамская кошка#Мейн-кун");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES"," Контрабанда кошек в какой стране каралась смертной казнью.");
        value.put("VARS","#Египет#Австралия#США#Англия");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","С какой максимальной скоростью могут передвигаться кошки на короткие расстояния?");
        value.put("VARS","#20 км/ч#32 км/ч#50 км/ч#35 км/ч");
        value.put("ANS","в");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой представитель кошачьих не может прятать когти?");
        value.put("VARS","#пантера#гепард#пума#снежный барс");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Как называется чрезмерная любовь к кошкам?");
        value.put("VARS","#Айлурофилия#Айлурофобия#Анемофилия#Анемофобия");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","В каких годах кошек завезли в Юж. и Сев.Америки для борьбы с вредителями?");
        value.put("VARS","#1710-х#1720-х#1730-х#1740-х");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Сколько зубов у взрослой кошки?");
        value.put("VARS","#30#32#26#24");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Самое большое зарегистрированное количество котят родила кошка за всю жизнь?");
        value.put("VARS","#150#220#300#420");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какого вкуса не чувствуют кошки?");
        value.put("VARS","#соленого#сладкого#кислого#горького");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","В каком году было снято самое старое видео с кошками, размещенное на YouTube?");
        value.put("VARS","#1894#1927#1949#1987");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кого можно назвать самой большой кошкой?");
        value.put("VARS","#гепард#снежный барс#пума#тигр");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","В каких годах кошек завезли в Юж. и Сев.Америки для борьбы с вредителями?");
        value.put("VARS","#1710-х#1720-х#1730-х#1740-х");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}