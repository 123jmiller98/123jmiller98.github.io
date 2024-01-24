package edu.mcckc.gui;

import edu.mcckc.dao.Check;
import edu.mcckc.dao.CheckDao;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelView extends JPanel
{
    private static Logger logger = Logger.getLogger(PanelView.class);


    private JTextArea taOutput;
    private List<Object> listProducts;
    private CheckDao dao;
    private double totalCheckAmount;

    public PanelView()
    {
        try
        {
            dao = new CheckDao();
            taOutput = new JTextArea(25,80);
            listProducts = new ArrayList<Object>();

            JPanel row1 = new JPanel();
            row1.add(taOutput);

            this.setLayout(new GridLayout(1,1));
            this.add(row1);

            refreshTextArea();

        } catch (Exception ex)
        {
            logger.debug(ex.getMessage());
        }
    }


    public void refreshTextArea()
    {
        try
        {
            taOutput.setText("");
            totalCheckAmount = 0;

            listProducts = dao.selectMany(new Check(-1, "%", 1, "1",1,"1"));

            for (Object obj: listProducts)
            {
                Check tmp = (Check)obj;
                totalCheckAmount += tmp.getCheckAmount();
                taOutput.append(tmp.toString());
                taOutput.append("\n");
            }

            taOutput.append("------------\n");
            taOutput.append(String.format("Total Check Amount: $%4.2f ", totalCheckAmount));

            taOutput.setEditable(false);

        }catch (Exception ex)
        {
            logger.error(ex.getMessage());
            System.out.println(ex.getMessage());

        }

    }

}
