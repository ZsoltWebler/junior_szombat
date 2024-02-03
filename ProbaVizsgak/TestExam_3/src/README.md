# Junior Java Backend fejlesztő tanfolyam

## Vizsga

### 1. Feladat - Java programozási nyelv alapjai:

A `java_basics` package-ben található felhasználónév létrehozó alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

- A felhasználónév létrehozása a vezetéknév, keresztnév és születési év alapján történik.
- A felhasználónév első kettő karaktere nagybetű a vezetéknév első két karaktere, majd ezt követi a keresztnév első
  három karaktere kisbetűvel. Végül egy alulvonás és a születési év utolsó két karaktere.
- Egy lehetséges bemenet: Teszt (Vezetéknév) Elek (Keresztnév) 1996 (Születési év) -> TEele_96

Jelenleg egyik teszt eset sem fut le sikeresen, javítsa ki a megfelelő metódust vagy metódusokat.

Bővítse az alkalamzást: Készítsen egy új metódust a `UserNameGenerator` osztályba, ahol születési év 3 számjegye kerül a
felhasználónévbe, ha 2000 előtt
született a felhasználó és mind a négy karakter, ha 2000 után.

Írjon két új tesztesetet, az új metódus tesztelésére.

### 2. Feladat - Java objektumorientált programozás:

A `java_oop` package-ben található alkalmazott szabadság számoló alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

Egy alkalmazott lehetséges szabadnapjait a következő formulával kapjuk:

- 25 év alatti munkavállaló esetén az alap 20 nap szabadság jár.
- 25 - 27 éves korig 21 nap szabadság jár.
- 28 - 30 éves korig 22 nap szabadság jár.
- 31 - 32 éves korig 23 nap szabadság jár.
- 33 éves kortól 24 nap szabadság jár.

Jelenleg nem minden teszteset fut le sikeresen, a feladatod a megfelelő metódus vagy metódusok javítása, hogy a
tesztesetek sikeresen lefussanak.

Bővítsd az alkalmazást, hogy figyelembe vegye az alkalmazott kezdő hónapját. Ehhez készíts egy új konstruktort, ami
paraméterül vár egy hónapot `int` értékként (1-12). Ha a hónap:

- 1,2,3 - Akkor a teljes szabadság jár.
- 4,5,6 - Akkor a szabadság 75%-a jár, napra felfelé kerekítve.
- 7,8,9 - Akkor a szabadság 50%-a jár, napra felfelé kerekítve.
- 10,11,12 - Akkor a szabadság 25%-a jár, napra felfelé kerekítve.

Példa számítás: Ha az alkalmazott 30 éves, akkor 22 nap szabadság jár neki, ha a 4. hónapban csatlakozott, akkor a 22
nap 75%-a illeti meg. 22 * 0.75 = 16.5, vagyis az alkalmazottnak 17 nap szabadnap jár.

Készíts 2 új tesztesetet, amiben teszteled az új funkciót.

### 3. Feladat - Java kollekciók:

A `java_collections` package-ben található könyv nyilvántartó rendszert kell folytatnia a következő szempontok
figyelembevételével.

- Vizsgálja meg az alkalmazást és tekintse meg a felhasznált osztályokat.
- A `BookStore` osztályban található lekérdezések közül, nem lett mind befejezve. Ezen metódusok implementálása az ön
  feladata lesz.
  - `getBooksGroupedByGenre` : Térjen vissza a könyvekkel csoportosítva a múfaj alapján.
  - `getBookByISBN` : Térjen vissza az adott ISBN-el rendelkező könyvvel, csak `null` értékkel, ha nincs ilyen könyv.
- A két új metódus átható tesztelése is az ön feladata lesz.
- A `BookStoreTest` osztályban található tesztesetek közül nem fut le mind sikeresen. Keresse meg a hiba okát és javítsa
  az almalmazást, amíg a tesztesetek sikeresen le nem futnak.

### Feladat 4 - Java io:

A `java_io` package-ben található széndioxid kibocsájtás feldolgozó alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

```text
Make,Model,Vehicle Class,Engine Size(L),Cylinders,Transmission,Fuel Type,Fuel Consumption City (L/100 km),Fuel Consumption Hwy (L/100 km),Fuel Consumption Comb (L/100 km),Fuel Consumption Comb (mpg),CO2 Emissions(g/km)
ACURA,ILX,COMPACT,2,4,AS5,Z,9.9,6.7,8.5,33,196
ACURA,ILX,COMPACT,2.4,4,M6,Z,11.2,7.7,9.6,29,221
ACURA,ILX HYBRID,COMPACT,1.5,4,AV7,Z,6,5.8,5.9,48,136
ACURA,MDX 4WD,SUV - SMALL,3.5,6,AS6,Z,12.7,9.1,11.1,25,255
```

> A feldolgozás során, nem kell az összes oszlopot felhasználni!

- Olvassa be az emission.csv fáljban található adatokat az `EmissionReader` osztály felhasználásával.
- Valósítsa meg a `readEmissionFromCSV` metódust, ami `CarEmissionInfo` objektumok listájával tér vissza.
- Készítsen 2 új tesztesetet:
  - Ellenőrizze, hogy a maximum co2 kibocsájtás 522 és a minimum 96.
  - Ellenőrizze, hogy 51 különböző **engineSize** érték van a cvs-ben.

### Feladat 5 - Java adatbázis:

A `java_database` package-ben található Spotify alkalmazást kell folytatnia. Hozz létre egy adatbázist és csatlakozz
hozzá a `Database` osztályban található `createConnection` metódus megfelelő paraméterezésével.

A PgAdmin felületen futtasd az alábbi SQL-t, hogy létrehozd a táblákat és beszúrd a kezdő adatokat.


```sql
CREATE TABLE IF NOT EXISTS song (
  song_id serial PRIMARY KEY,
  song_title VARCHAR ( 50 ) UNIQUE NOT NULL,
  song_artist VARCHAR ( 50 ) NOT NULL,
  song_genre VARCHAR ( 50 ) NOT NULL,
  song_release_year INT NOT NULL
  );


INSERT INTO song(song_title,song_artist,song_genre,song_release_year) VALUES
            ('Hey, Soul Sister','Train','neo mellow',2010),
            ('Love The Way You Lie','Eminem','detroit hip hop',2010),
            ('TiK ToK','Kesha','dance pop',2010),
            ('Bad Romance','Lady Gaga','dance pop',2010),
            ('Just the Way You Are','Bruno Mars','pop',2010),
            ('Baby','Justin Bieber','canadian pop',2010),
            ('Dynamite','Taio Cruz','dance pop',2010),
            ('Secrets','OneRepublic','dance pop',2010),
            ('Empire State of Mind (Part II) Broken Down','Alicia Keys','hip pop',2010),
            ('Only Girl (In The World)','Rihanna','barbadian pop',2010),
            ('Club Cant Handle Me (feat. David Guetta)','Flo Rida','dance pop',2010);
```

A feladatod, befejezni az alkalmazást az alábbi szempontok figyelembevételével:

- Az `Spotify` osztály tartalmaz egy grafikus felületet, de jelenleg az `Add Song` gomb nem működik.
  - Találsz egy `addSong(SongDao song)` metódust a `Spotify` osztályban. A gomb megnyomására hozz létre egy `Dialog`-t
    amin a felhasználó fel tudja vinni az új dal adatait és az **Ok** gomb lenyomására az új szoba szúrodjon be az
    adatbázisba.
  - Old meg, hogy a táblázat frissüljön az új dal adataival, minden beszúrás után.

