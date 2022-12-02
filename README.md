# BattleShipsGame

Proiect BattleShips

Tivadar Maria Simona

Proiectul meu de bazeaza pe jocul classic de avioane – doar ca e cu vapoare.
	Avem o tabla de 5x5 si fiecare jucator trebuie sa plaseze 3 barci und doreste (computer-ul le plaseaza random). Primul jucator care gasestea toate vapoarele adversarului va castiga.
	![image](https://user-images.githubusercontent.com/69772634/205262172-0607dd81-cbca-40d2-8699-a106e1f15fb4.png)

Proiectul are ca interfata grafica JAVA SWING si este construit pe structura MVC – Model View Controller.
Aici se gaseste lista claselor:
 
Clasa HartaVapoare reprezinta strucutra de date, ca sa zi casa, folosita pentru a genera harta jucatorului si harta inamicului. Este de fapt o lista de int uri, fiecare avand o insemnatate: am barca acolo, am apa acolo, am lovit vapor acolo si asa mai departe.
Controller-ul continue metodele de baza (setter si getteri in mare parte) pentru a extrage datele din HartaVapoare sau alte clase – cam toate elementele din clase sunt private.
View reprezinta pagina de strat, unde se introduce numele jucatorului si se decide inceperea jocului.
 
![image](https://user-images.githubusercontent.com/69772634/205262897-eb7eabe3-4902-4a1f-9daa-f20ea32eef46.png)

Prin apasarea butonului de start, debuteaza View2, care cere jucatorului sa-si pozitioneze ele 3 vapoare. Prima harta care ii apare jucatorului pe ecran este de fapt un vector de butoane Analog se intampla si pentru a doua harta, unde jucatorul trebuie sa caute vapoarele adversarului. 
 
Dar in loc sa fac 25 de Listeneri (cum am incercat initial), am folosit aceste metode (se aplica si la a doua harta) care primeste un anumit tip de buton, de pe harta respective – pentru ca toate butoanele fac acelasi lucru, nu era efficient si nici rapid scrierea a 25 de listener ce fac acelasi lucru.
 

Mai mult decat atat, atasez ce face metoda de action listener din controller. Am folosit diferite metode din Java pentru buton – cum ar fi getSource – pentru a stii exact care buton din cele 25 a fost apasat – fiecare buton a primit ‘titlul’ de un numar. Ele fiind numerotate de la 1 la 25. Mai apoi, in functie de butonul apasat si de cee ace se gaseste pe el (apa sau vapor – depinde care harta este), imaginea acelui buton se schimba.
 

Castigatorul este primul care gasete toate cele 3 vapoare ale inamicului. Jocul se termina.
