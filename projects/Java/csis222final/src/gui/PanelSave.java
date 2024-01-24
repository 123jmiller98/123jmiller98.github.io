package edu.mcckc.gui;

import edu.mcckc.dao.Check;
import edu.mcckc.dao.CheckDao;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSave extends JPanel implements ActionListener
{
    private static Logger logger = Logger.getLogger(PanelSave.class);

    private JLabel lblPaidTo;
    private JLabel lblCheckAmount;
    private JLabel lblAccountNumber;
    private JLabel lblSequenceNumber;
    private JLabel lblCheckDate;

    private JLabel lblMessage;

    private JTextField txtPaidTo;
    private JTextField txtCheckAmount;
    private JTextField txtAccountNumber;
    private JTextField txtSequenceNumber;
    private JTextField txtCheckDate;

    private JButton btnSave;

    private CheckDao dao;

    private PanelEdit editPanelReference;
    private PanelView viewPanelReference;

    public void setEditPanelReference(PanelEdit editPanelReference)
    {
        this.editPanelReference = editPanelReference;
    }

    public void setViewPanelReference(PanelView viewPanelReference)
    {
        this.viewPanelReference = viewPanelReference;
    }

    public PanelSave()
    {
        try
        {
            dao = new CheckDao();
            lblPaidTo = new JLabel("Paid To: ");
            lblCheckAmount = new JLabel("Check Amount: ");
            lblAccountNumber = new JLabel("Account Number: ");
            lblSequenceNumber = new JLabel("Sequence Number: ");
            lblCheckDate = new JLabel("Check Date: ");
            lblMessage = new JLabel("");


            txtPaidTo = new JTextField(25);
            txtCheckAmount = new JTextField(25);
            txtAccountNumber = new JTextField(25);
            txtSequenceNumber = new JTextField(25);
            txtCheckDate = new JTextField(25);

            btnSave = new JButton("Save");

            btnSave.setActionCommand("save");
            btnSave.addActionListener(this);

            JPanel row1 = new JPanel();
            JPanel row2 = new JPanel();
            JPanel row3 = new JPanel();
            JPanel row4 = new JPanel();
            JPanel row5 = new JPanel();
            JPanel row6 = new JPanel();
            JPanel row7 = new JPanel();

            row1.add(lblPaidTo);
            row1.add(txtPaidTo);
            row2.add(lblCheckAmount);
            row2.add(txtCheckAmount);
            row3.add(lblAccountNumber);
            row3.add(txtAccountNumber);
            row4.add(lblSequenceNumber);
            row4.add(txtSequenceNumber);
            row5.add(lblCheckDate);
            row5.add(txtCheckDate);

            row6.add(lblMessage);
            row7.add(btnSave);

            this.setLayout(new GridLayout(7,1));
            this.add(row1);
            this.add(row2);
            this.add(row3);
            this.add(row4);
            this.add(row5);
            this.add(row6);
            this.add(row7);



        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());

        }

    }




    private void clearTextFields()
    {
        txtPaidTo.setText("");
        txtCheckAmount.setText("");
        txtAccountNumber.setText("");
        txtSequenceNumber.setText("");
        txtCheckDate.setText("");
        lblMessage.setText("");

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(e.getActionCommand().toLowerCase().equals("save"))
        {
            try
            {
                Check check = new Check(-1, txtPaidTo.getText(), Double.parseDouble(txtCheckAmount.getText()),
                        txtAccountNumber.getText(), Integer.parseInt(txtSequenceNumber.getText()), txtCheckDate.getText());

                dao.saveOne(check);
                editPanelReference.refreshComboBox();
                viewPanelReference.refreshTextArea();
                clearTextFields();
            }
            catch (Exception ex)
            {
                lblMessage.setText(ex.getMessage());
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }

    }
}
