package edu.mcckc.gui;

import edu.mcckc.dao.Check;
import edu.mcckc.dao.CheckDao;
import org.apache.log4j.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelEdit extends JPanel implements ActionListener
{

    private static Logger logger = Logger.getLogger(PanelEdit.class);


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
    private JButton btnDelete;
    private CheckDao dao;
    private JComboBox<Check> cboProducts;
    private List<Object> listProducts;
    private Check selectedCheck;

    private PanelView viewPanelReference;


    public void setViewPanelReference(PanelView viewPanelReference)
    {
        this.viewPanelReference = viewPanelReference;
    }


    public PanelEdit()
    {
        try
        {
            dao = new CheckDao();
            lblPaidTo = new JLabel("Paid To: ");
            lblCheckAmount = new JLabel("Check Amount: ");
            lblAccountNumber = new JLabel("Account Number: ");
            lblSequenceNumber = new JLabel("Sequence Number: ");
            lblCheckDate = new JLabel("Date: ");

            lblMessage = new JLabel("");

            txtPaidTo = new JTextField(25);
            txtCheckAmount = new JTextField(25);
            txtAccountNumber = new JTextField(25);
            txtSequenceNumber = new JTextField(25);
            txtCheckDate = new JTextField(25);


            btnSave = new JButton("Save");
            btnSave.setActionCommand("save");
            btnSave.addActionListener(this);

            btnDelete = new JButton("Delete");
            btnDelete.setActionCommand("delete");
            btnDelete.addActionListener(this);

            cboProducts = new JComboBox<Check>();
            listProducts = new ArrayList<Object>();

            refreshComboBox();

            cboProducts.setActionCommand("pick");
            cboProducts.addActionListener(this);






            JPanel row1 = new JPanel();
            JPanel row2 = new JPanel();
            JPanel row3 = new JPanel();
            JPanel row4 = new JPanel();
            JPanel row5 = new JPanel();
            JPanel row6 = new JPanel();
            JPanel row7 = new JPanel();
            JPanel row8 = new JPanel();



            row1.add(cboProducts);
            row2.add(lblPaidTo);
            row2.add(txtPaidTo);
            row3.add(lblCheckAmount);
            row3.add(txtCheckAmount);
            row4.add(lblAccountNumber);
            row4.add(txtAccountNumber);
            row5.add(lblSequenceNumber);
            row5.add(txtSequenceNumber);
            row6.add(lblCheckDate);
            row6.add(txtCheckDate);
            row7.add(lblMessage);
            row8.add(btnSave);
            row8.add(btnDelete);



            this.setLayout(new GridLayout(8,1));
            this.add(row1);
            this.add(row2);
            this.add(row3);
            this.add(row4);
            this.add(row5);
            this.add(row6);
            this.add(row7);
            this.add(row8);


        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
            System.out.println(ex.getMessage());

        }
    }


    public void refreshComboBox()
    {
        try
        {
            cboProducts.removeAllItems();

            listProducts = dao.selectMany(new Check(-1, "%", 1, "1",1,"D"));

            for (Object obj: listProducts)
            {
                Check tmp = (Check)obj;
                cboProducts.addItem(tmp);
            }

        }catch (Exception ex)
        {
            logger.error(ex.getMessage());
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
        if (e.getActionCommand().toLowerCase().equals("pick")){

            try
            {
                selectedCheck = (Check)cboProducts.getSelectedItem();
                System.out.println(selectedCheck);
                logger.debug(selectedCheck);

                txtPaidTo.setText(selectedCheck.getPaidTo());
                txtCheckAmount.setText(String.valueOf(selectedCheck.getCheckAmount()));
                txtAccountNumber.setText(selectedCheck.getAccountNumber());
                txtSequenceNumber.setText(String.valueOf(selectedCheck.getSequenceNumber()));
                txtCheckDate.setText(selectedCheck.getCheckDate());


            }catch (Exception ex)
            {
                logger.debug("Ignoring : " +  ex.getMessage());
            }


        }


        if (e.getActionCommand().toLowerCase().equals("save"))
        {
            try
            {
                selectedCheck.setPaidTo(txtPaidTo.getText());
                selectedCheck.setCheckAmount(Double.parseDouble(txtCheckAmount.getText()));
                selectedCheck.setAccountNumber(txtAccountNumber.getText());
                selectedCheck.setSequenceNumber(Integer.parseInt(txtSequenceNumber.getText()));
                selectedCheck.setCheckDate(txtCheckDate.getText());

                dao.saveOne(selectedCheck);
                refreshComboBox();
                clearTextFields();
                viewPanelReference.refreshTextArea();
            }
            catch (Exception ex)
            {
                lblMessage.setText(ex.getMessage());
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }


        if (e.getActionCommand().toLowerCase().equals("delete"))
        {
            try
            {
                dao.deleteOne(selectedCheck);
                refreshComboBox();
                clearTextFields();
                viewPanelReference.refreshTextArea();
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
