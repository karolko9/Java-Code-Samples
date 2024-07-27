package org.example;

import java.util.Collections;


public class GraWojna extends Gra {

    public GraWojna() {
        Gracz gracz1 = new Gracz();
        Gracz gracz2 = new Gracz();
        this.gracze.add(gracz1);
        this.gracze.add(gracz2);
        talia = new Talia();
        talia.potasuj();
        rozdajKarty();
    }


    public void rozdajKarty() {
        boolean flag = true;
        for (Karta karta : talia.karty) {
            if (flag) {
                gracze.get(0).reka.add(karta);
            } else {
                gracze.get(1).reka.add(karta);
            }
            flag = !flag;
        }
    }


    public void przeniesKarty(Gracz od_, Gracz do_) {
        do_.reka.addAll(od_.reka);
        Collections.shuffle(do_.reka);
        od_.reka.clear();
    }


    public String graj() {
        int tura = 0;
        Gracz stos1 = new Gracz();
        Gracz stos2 = new Gracz();
        boolean pomin = false;
        while (true) {
            System.out.println("Tura:" + tura);
            tura++;
            if (gracze.get(0).reka.isEmpty() && gracze.get(1).reka.isEmpty()) {
                return "remis";
            }
            if (gracze.get(0).reka.isEmpty()) {
                return "gracz 2 wygrywa";
            }
            if (gracze.get(1).reka.isEmpty()) {
                return "gracz 1 wygrywa";
            }
            stos1.reka.add(gracze.get(0).reka.remove(0));
            stos2.reka.add(gracze.get(1).reka.remove(0));
            System.out.println(stos1.reka.size() + "/" + stos2.reka.size() + "/" + gracze.get(0).reka.size() + "/" + gracze.get(1).reka.size());
            if (!pomin) {
                System.out.println(stos1.reka.getLast().typ + "-" + stos1.reka.getLast().kolor);
                System.out.println(stos2.reka.getLast().typ + "-" + stos2.reka.getLast().kolor);

                if (stos1.reka.getLast().typ == stos2.reka.getLast().typ) {
                    System.out.println("te same karty");
                    pomin = true;
                } else {
                    pomin = false;
                    System.out.println("różne karty");
                    if (stos1.reka.getLast().typ.ordinal() > stos2.reka.getLast().typ.ordinal()) {
                        przeniesKarty(stos1, gracze.get(0));
                        przeniesKarty(stos2, gracze.get(0));
                        System.out.println("1-0");

                    } else {
                        przeniesKarty(stos1, gracze.get(1));
                        przeniesKarty(stos2, gracze.get(1));
                        System.out.println("0-1");
                    }
                }
            } else {
                pomin = false;
            }
        }
    }
}
