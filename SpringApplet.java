package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class SpringApplet extends JApplet{

    //1
    private SimEngine simEngine;
    //2
    private SimTask simTask;
    //3
    private Timer timer;

    private int szerokosc=600;
    private int wysokosc=600;

    @Override
    public void init() {

    setSize(szerokosc, wysokosc);
    //tworze obiekt SimEngine
    simEngine = new SimEngine(15,0.45,0.35,100,300,250,0,300,10);
    //nowy obiekt SimTask
    simTask = new SimTask(simEngine, this, 0.1);
    //nowy obiekt timer
    timer = new Timer();
    //metoda
    timer.scheduleAtFixedRate(simTask,0,15);

    }
    //5
    @Override
    public void paint(Graphics g) {
    //czyszczenie ekranu
        g.fillRect(0,0,szerokosc,wysokosc);
    //wybieram kolor tla
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,szerokosc,wysokosc);
     //narysowanie punktu utwierdzenia
        g.setColor(Color.CYAN);
        g.drawLine(250,(int)simEngine.getPolozeniePunktuZaczY(),350,(int)simEngine.getPolozeniePunktuZaczY());
     //rysowanie masy
        g.setColor(Color.PINK);
        g.fillOval((int)simEngine.getPolozenieMasyX()-25, (int)simEngine.getMasaPozY(), 50,50);
     //rysowanie linii
        g.setColor(Color.GREEN);
        g.drawLine((int)simEngine.getPolozeniePunktuZaczX(), (int)simEngine.getPolozeniePunktuZaczY(), (int)simEngine.getPolozenieMasyX(), (int)simEngine.getMasaPozY());
    }
}
