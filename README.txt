Jantea Dragos Valentin 321CC
2 saptamani
mediu spre dificil


Pentru realizarea acestei teme:
am implementat conform cerintei design pattern-urile,
am adaugat niste functii de testare care pot fi decomentate in clasa Game
am facut cate o metoda toString pentru a afisa frumos informatiile 

Clasa Game contine 
- lista de conturi 
- un dictionar ce contine lista cu siruri ce modeleaza povestile
- metoda run ce porneste un joc nou, aici fiind functiile de testare
- aici am implementat si Singleton pattern

Clasa Acount contine
- contine informatii despre jucator
- class Information ce are credentiale, lista cu jocurile favorite, nume si tara
- class Builder se afla in interiorul clasei Information ce creaza un obiect de tip Information numai ca nu se apeleaza
tot constructorul deodata ci seteaza separat atributele obiectului

Clasa Entity
- implementeaza Element pattern
- contine lista de abilitati
- campuri pentru viata si mana
- protectiile la elementele jocului (ice, earth, fire)
- metode pentru regenerarea manei, vietii si pentru folosirea uneia dintre abilitati
- metode pentru damage si pierdere viata ce sunt implementate ulterior in clasele Enemy, Rogue, Warrior si Mage

Clasa Spell
- implementeaza Visitor pattern

Clasa Character
- implementeaza Factory pattern pentru instantierea personajelor
- contine numele personajului
- coordonatele curente ale personajului
- obiect de tip Inventory
- experienta curenta
- nivelul curent 
- campuri ce definesc puterea, carisma si dexteritatea
- metoda de cumparare a unei potiuni

Clasele Warrior, Mage si Rogue extind clasa Character