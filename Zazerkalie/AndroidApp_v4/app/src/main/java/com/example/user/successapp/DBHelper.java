package com.example.user.successapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 6/7/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "quiestions"; // Имя базы данных
    private static final int DB_VERSION = 1; // Верчия базы данных

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
        value.put("ANS","а");
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
        value.put("QUES","Какой краситель добавляют в сырье для получения красного стекла?");
        value.put("VARS","#железо#ванадий#оксид серебра#соединение карбонита");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой из представленных естественных красителей красит в красный цвет?");
        value.put("VARS","#ветви вишни#оболочка лука#брусника#смородина");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какая из пород легче всего обрабатывается?");
        value.put("VARS","#береза#клен#вяз#сосна");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","В каком веке жил Иоган Себастьян Бах?");
        value.put("VARS","#XVI#XVII#XVIII#XIX");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Даты жизни Жукова?");
        value.put("VARS","#19.11.1896 -18.06.1974#22.04.1870 -21.01.1924#21.12.1879 -05.09.1953#30.11.1874 -24.01.1965");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Вторая Мировая Война началась с нападения Германии на:");
        value.put("VARS","#Данию#Австрию#Польшу#Чехословакию");
        value.put("ANS","в");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто из представленных игроков не входит в команду 'Спартак'?");
        value.put("VARS","#Песьяков Сергей#Боккетти Сальваторе#Юрий Лодыгин#Глушаков Денис ");
        value.put("ANS","в");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Про кого сказали:'Не ручей-море ему имя'?");
        value.put("VARS","#В.А.Моцарт#И.С.Бах#Бетховен#Ф.Лист");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Дата жизни Черчеля?");
        value.put("VARS","#19.11.1896 -18.06.1974#22.04.1870 -21.01.1924#21.12.1879 -05.09.1953#30.11.1874 -24.01.1965");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой из представленных дятлов считается самым крупным?");
        value.put("VARS","#Большой пестрый дятел#Белоспинный дятел#Черный дятел#Белоклювый королевский дятел");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Что из перечисленного не является достоинством резьбового соединения?");
        value.put("VARS","#простота конструкции#технологичность#многократное использование#повышенное напряжение на впадинах резьбы");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Что из перечисленного не является видом резьбы по кости?");
        value.put("VARS","#гладкая#зигзагообразная#рельефная#сквозная");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто из перечисленных не является лисой?");
        value.put("VARS","#фенек#корсак#майконг#пасюк");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","С какого расстояния назначают пенальти в футболе?");
        value.put("VARS","#с 10 м#с 11 м#с 12 м#с 13 м");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто похож на сказочного единорога?");
        value.put("VARS","#нарвал#морж#тюлень#морской котик");
        value.put("ANS","а");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Что из перечисленного не является достоинством резьбового соединения?");
        value.put("VARS","#простота конструкции#технологичность#многократное использование#повышенное напряжение на впадинах резьбы");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES"," На территории каких стран расположен водопад Виктория?");
        value.put("VARS","#Танзания и Мозамбик#Зимвабве и Мозамбик#Зимбабве и Замбия#Танзания и Замбия");
        value.put("ANS","в");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какие две страны имеют ровно полгода между их нациаональными праздниками?");
        value.put("VARS","#США и Россия#Кения и Франция#Германия и Парагвай#Финляндия и Швеция");
        value.put("ANS","г");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES"," К чему относится полиэтилен?");
        value.put("VARS","#спирт#пластмасса#пакет#каучуки");
        value.put("ANS","б");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
        value.put("QUES","Как звучит официально правильное обращение к российскому туристу в Японии?");
        value.put("VARS","#Иван-джан#Иван-ага#Иван-сан#Иван-оглы");
        value.put("ANS","в");
        value.put("STAT","0");
        db.insert("APPTABLE", null, value);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
