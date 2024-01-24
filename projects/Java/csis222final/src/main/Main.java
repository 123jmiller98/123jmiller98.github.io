package edu.mcckc.main;


import edu.mcckc.gui.FrameGui;
import org.apache.log4j.*;

import javax.swing.*;


public class Main
{

    private static Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args)
    {
        FrameGui frm = new FrameGui();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(900,600);
        frm.setVisible(true);


    }
}

