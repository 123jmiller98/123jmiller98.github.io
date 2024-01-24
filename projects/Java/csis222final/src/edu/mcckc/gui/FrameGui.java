package edu.mcckc.gui;

import edu.mcckc.dao.SetupDao;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGui extends JFrame implements ActionListener
{

    private static Logger logger = Logger.getLogger(FrameGui.class);
    private PanelSave pnlSave;
    private PanelEdit pnlEdit;
    private PanelView pnlView;

    private JTabbedPane tbPanels;


    public FrameGui()
    {
        pnlSave = new PanelSave();
        pnlEdit = new PanelEdit();
        pnlView = new PanelView();


        pnlSave.setEditPanelReference(pnlEdit);
        pnlSave.setViewPanelReference(pnlView);
        pnlEdit.setViewPanelReference(pnlView);


        tbPanels = new JTabbedPane(JTabbedPane.TOP);

        tbPanels.add("Check Save", pnlSave);
        tbPanels.add("Check Edit", pnlEdit);
        tbPanels.add("Check View", pnlView);

        this.add(tbPanels);


        JMenu menu = new JMenu("Database");
        JMenuItem setupItem = new JMenuItem("Setup");
        menu.add(setupItem);
        setupItem.setActionCommand("setup");
        setupItem.addActionListener(this);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(menu);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        logger.debug("CREATING TABLES!!!!!!");
        if(e.getActionCommand().toLowerCase().equals("setup"))
        {
            try
            {
                SetupDao dao = new SetupDao();
                dao.createDatabaseTables();
            }
            catch (Exception ex)
            {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
    }
}
