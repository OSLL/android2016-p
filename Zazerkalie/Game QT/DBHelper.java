package com.zazerk.lie.successapp;

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
                "STAT INTEGER, " +
                "THEME INTEGER);");

        db.execSQL("CREATE TABLE PLAYERTABLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "SCORE INTEGER);");

        ContentValues value = new ContentValues();
        value.put("QUES","Какое из представленных деревьев является хвойным?");
        value.put("VARS","#Сосна#Береза#Дуб#Клен");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто придумал радио?");
        value.put("VARS","#Тесла#Попов#Лебедев#Лейбниц");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто первым побывал в космосе?");
        value.put("VARS","#Гагарин#Терешкова#Армстонг#Стрелка");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто из представленных змей не является ядовитым?");
        value.put("VARS","#Гремучая змея#Шипохвост Австралийский#Адельфийская змея#Гадюка Обыкновенная");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой из представленных фильмов был выпущен студией Pixar?");
        value.put("VARS","#В поисках Немо#Тачки#Вверх#Шрек");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Главного персонажа какого сериала зовут Барби?");
        value.put("VARS","#Во все тяжкие#Сплетница#Под куполом#Офис");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой главой заканчивается 'Герой нашего времени'?");
        value.put("VARS","#Княжная Мэри#Тамань#Бэла#Фаталист");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто из этих людей является скрипачем? ");
        value.put("VARS","#Томас Адес#Ванесса Мэй#Пабло Казаль#Себастьян Бах");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какое дерево используется для изготовления газет?");
        value.put("VARS","#Дуб#Вяз#Ива#Ель");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой фрукт самый распространенный в мире?");
        value.put("VARS","#Яблоко#Апельсин#Банан#Ананас");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой сахар добывали в глубокой древности в Китае?");
        value.put("VARS","#Сорговый#Ягре#Кленовый#Свекольный");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой краситель добавляют в сырье для получения красного стекла?");
        value.put("VARS","#Железо#Ванадий#Оксид серебра#соединение карбонита");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой из представленных естественных красителей красит в красный цвет?");
        value.put("VARS","#Ветви вишни#Оболочка лука#Брусника#Смородина");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какая из пород легче всего обрабатывается?");
        value.put("VARS","#Береза#Клен#Вяз#Сосна");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","В каком веке жил Иоган Себастьян Бах?");
        value.put("VARS","#XVI#XVII#XVIII#XIX");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Даты жизни Жукова?");
        value.put("VARS","#19.11.1896 -18.06.1974#22.04.1870 -21.01.1924#21.12.1879 -05.09.1953#30.11.1874 -24.01.1965");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Вторая Мировая Война началась с нападения Германии на:");
        value.put("VARS","#Данию#Австрию#Польшу#Чехословакию");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто из представленных игроков не входит в команду 'Спартак'?");
        value.put("VARS","#Песьяков Сергей#Боккетти Сальваторе#Юрий Лодыгин#Глушаков Денис ");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Про кого сказали:'Не ручей-море ему имя'?");
        value.put("VARS","#В.А.Моцарт#И.С.Бах#Бетховен#Ф.Лист");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Дата жизни Черчеля?");
        value.put("VARS","#19.11.1896 - 18.06.1974#22.04.1870 - 21.01.1924#21.12.1879 - 05.09.1953#30.11.1874 - 24.01.1965");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой из представленных дятлов считается самым крупным?");
        value.put("VARS","#Большой пестрый дятел#Белоспинный дятел#Черный дятел#Белоклювый королевский дятел");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Что из перечисленного не является достоинством резьбового соединения?");
        value.put("VARS","#Простота конструкции#Технологичность#Многократное использование#Повышенное напряжение на впадинах резьбы");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Что из перечисленного не является видом резьбы по кости?");
        value.put("VARS","#Гладкая#Зигзагообразная#Рельефная#Сквозная");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто из перечисленных не является лисой?");
        value.put("VARS","#Фенек#Корсак#Майконг#Пасюк");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","С какого расстояния назначают пенальти в футболе?");
        value.put("VARS","#с 10 м#с 11 м#с 12 м#с 13 м");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кто похож на сказочного единорога?");
        value.put("VARS","#Нарвал#Морж#Тюлень#Морской котик");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Что из перечисленного не является достоинством резьбового соединения?");
        value.put("VARS","#Простота конструкции#Технологичность#Многократное использование#Повышенное напряжение на впадинах резьбы");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES"," На территории каких стран расположен водопад Виктория?");
        value.put("VARS","#Танзания и Мозамбик#Зимвабве и Мозамбик#Зимбабве и Замбия#Танзания и Замбия");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какие две страны имеют ровно полгода между их нациаональными праздниками?");
        value.put("VARS","#США и Россия#Кения и Франция#Германия и Парагвай#Финляндия и Швеция");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES"," К чему относится полиэтилен?");
        value.put("VARS","#Спирт#Пластмасса#Пакет#Каучуки");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Как звучит официально правильное обращение к российскому туристу в Японии?");
        value.put("VARS","#Иван-джан#Иван-ага#Иван-сан#Иван-оглы");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME", 3);
        db.insert("APPTABLE", null, value);

        value.put("QUES","Какую египетскую богиню изображали женщиной с кошачьей головой?");
        value.put("VARS","#Аш#Бастет#Исида#Маат");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой континент является родиной домашней кошки? ");
        value.put("VARS","#Евразия#Австралия#Америка#Африка");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какая священная книга с уважением отзывается о кошке — совсем не так, как о «презренной собаке»?");
        value.put("VARS","#Библия#Трипитака#Коран#Гаты");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES"," В какой священной книге нет ни одного упоминания о кошке? ");   //почему ответ библия не правельный?
        value.put("VARS","#Библия#Трипитака#Коран#Гаты");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Как звали кота в романе Михаила Булгакова «Мастер и Маргарита»?");
        value.put("VARS","#Берлиоз#Бегемот#Мурчум#Римский");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какая страна в мире занимает первое место по численности домашних кошек?");
        value.put("VARS","#Египет#Австралия#США#Англия");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Как звали самого знаменитого кота из мультсериала Уолта Диснея.");
        value.put("VARS","#Том#Кот в сапогах#Гарфилд#Тулуза");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES"," Контрабанда кошек в какой стране каралась смертной казнью.");
        value.put("VARS","#Египет#Австралия#США#Англия");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","С какой максимальной скоростью могут передвигаться кошки на короткие расстояния?");
        value.put("VARS","#20 км/ч#32 км/ч#50 км/ч#35 км/ч");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какой представитель кошачьих не может прятать когти?");
        value.put("VARS","#пантера#гепард#пума#снежный барс");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Как называется чрезмерная любовь к кошкам?");
        value.put("VARS","#Айлурофилия#Айлурофобия#Анемофилия#Анемофобия");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","В каких годах кошек завезли в Юж. и Сев.Америки для борьбы с вредителями?");
        value.put("VARS","#1710-х#1720-х#1730-х#1740-х");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Сколько зубов у взрослой кошки?");
        value.put("VARS","#30#32#26#24");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Самое большое зарегистрированное количество котят родила кошка за всю жизнь?");
        value.put("VARS","#150#220#300#420");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Какого вкуса не чувствуют кошки?");
        value.put("VARS","#соленого#сладкого#кислого#горького");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","В каком году было снято самое старое видео с кошками, размещенное на YouTube?");
        value.put("VARS","#1894#1927#1949#1987");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кого можно назвать самой большой кошкой?");
        value.put("VARS","#гепард#снежный барс#пума#тигр");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","В каких годах кошек завезли в Юж. и Сев.Америки для борьбы с вредителями?");
        value.put("VARS","#1710-х#1720-х#1730-х#1740-х");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Кому преписывают изобретение кошачьей двери?");
        value.put("VARS","#Я.Перельману#И.Ньютону#М.Ломомносову#Д.Булю");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Сколько котов содержал в Белом доме Авраам Линкольн?");
        value.put("VARS","#1#4#10#14");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","В версии 'Золушки' какой страны крестная фея была кошкой? ");
        value.put("VARS","#египетской#эстонской#швецкой#итальянской");
        value.put("ANS","г");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Что делали члены семьи в Др.Египте после смерти своей домашней кошки?");
        value.put("VARS","#брили брови#стригли волосы#одевались в черное#мумицировали кошку");
        value.put("ANS","а");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","Сколько существует основных пород кошек?");
        value.put("VARS","#170#33#330#67");
        value.put("ANS","б");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);
        value.put("QUES","От чего кошки выпускают и втягивают когти, растопыривая пальцы?");
        value.put("VARS","#от разочарования#от злости#от удовольствия#от возбуждения");
        value.put("ANS","в");
        value.put("STAT",0);
        value.put("THEME",2);
        db.insert("APPTABLE", null, value);

        value.put("QUES", "Кто написал сказку про приключения Алисы в Стране чудес?");
        value.put("VARS", "#Р.Кипплинг#Ш.Перро#Г.Х.Андерсен#Л.Кэрролл");
        value.put("ANS", "г");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Как звали птицу, встреченную Алисой на берегу Моря Слёз?");
        value.put("VARS", "#Орленок Эд#Додо#Квази#Орел");
        value.put("ANS", "б");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Во что был одет Белый кролик?");
        value.put("VARS", "#В лакированные сапожки и шляпу с пером#В жилетку и лайковые перчатки#В сюртук из зелёной парчи#В красную жилетку и шляпу с пером");
        value.put("ANS", "б");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "В кого превратился младенец в доме Герцогини?");
        value.put("VARS", "#В поросенка#В козленка#В кролика#В мышь");
        value.put("ANS", "а");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Какая птица выступала в качестве клюшки на королевском крокете?");
        value.put("VARS", "#Гусь#Лебедь#Страус#Фламинго");
        value.put("ANS", "г");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "За что судили Валета Червей?");
        value.put("VARS", "#За кражу тарелок#За кражу клюшек для крокета#За непочтительное обращение к Королеве#За съедение королевского торта");
        value.put("ANS", "а");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "За что Королева приговорила Герцогиню к казни?");
        value.put("VARS", "#За то, что она очень уродливая#За то, что та не явилась на крокет#За то, что та надавала ей пощёчин#За то, что не поддавалась при игре");
        value.put("ANS", "в");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "В какое время года происходили события сказки?");
        value.put("VARS", "#зимой#весной#летом#осенью");
        value.put("ANS", "в");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Как звали кошку девочки?");
        value.put("VARS", "#Дина#Марго#Алиса#Марфа");
        value.put("ANS", "а");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "С каким предметом сравнила Алиса своё внезапное уменьшение ? ");
        value.put("VARS", "#с подзорной трубой#с пирамидой#с песочным домиком#с зонтиком");
        value.put("ANS", "а");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "На волшебном пирожке была выложена надпись: «Съешь меня», чем ?");
        value.put("VARS", "#изюмом#курагой#кремом#черными и красными ягодами");
        value.put("ANS", "г");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Почему в крокет было трудно играть?");
        value.put("VARS", "#фламинго убегал#сбегали ежи#отсутствие правил#было невозможно выйграть");
        value.put("ANS", "в");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Кто посоветовал Алисе съесть гриб?");
        value.put("VARS", "#Безумный Шляпник#Гусеница#Мартовский заяц#Герцогиня");
        value.put("ANS", "б");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Кем был персонаж, которого завли Квази");
        value.put("VARS", "#птица#черепаха#белуга#орел");
        value.put("ANS", "б");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Кто из перечисленных не участвовал в безумном чаепитии?");
        value.put("VARS", "#Безумный Шляпник#Мартовский заяц#Птица Додо#мышка Соня");
        value.put("ANS", "в");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Какая любимая фраза у Королевы в оригинальной книге?");
        value.put("VARS", "#Отрубить ему голову!#Стража!#Голову долой!#Молчать!");
        value.put("ANS", "а");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Каким маслом чинили часы Шляпника?");
        value.put("VARS", "#машинным#оливковым#подсолнечным#сливовым");
        value.put("ANS", "г");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Что так напугало голубку при встрече с Алисой?");
        value.put("VARS", "#ее рост#ее рост#ее шея#ее хитрые глаза");
        value.put("ANS", "в");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Что показывали часы Кролика?");
        value.put("VARS", "#секунду#минуту#час#день");
        value.put("ANS", "г");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Кто был первым свидетелем на суде?");
        value.put("VARS", "#Алиса#Шляпник#кухарка#Герцогиня");
        value.put("ANS", "б");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Каким маслом чинили часы Шляпника?");
        value.put("VARS", "#машинным#оливковым#подсолнечным#сливовым");
        value.put("ANS", "г");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
        value.put("QUES", "Каким маслом чинили часы Шляпника?");
        value.put("VARS", "#машинным#оливковым#подсолнечным#сливовым");
        value.put("ANS", "г");
        value.put("STAT", 0);
        value.put("THEME", 1);
        db.insert("APPTABLE", null, value);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}