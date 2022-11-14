
/*
 Group 33
 Mazen alzahrani 
 Waleed Altamimi 
 Saleh Alkredes 
 Rakan Al Omairi
 Faisal Alfawaz
 kkik9o
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class HelloController extends JFrame {

    private final JRadioButton radioButtonCheese, radioButtonPepperoni, radioButtonVeggie;
    private final JCheckBox checkBoxExtraCheese, checkBoxBacon, checkBoxMushroom;
    private final JTextArea textArea;
    private final JTextField textField;
    private final JPanel panelOrderConfirm;
    private final JButton btnProceed;
    private final JButton btnConfirmOrder;
    private final DefaultTableModel model;
    private final MyTable table;
    private PizzaOrder pizzaOrder = new PizzaOrder();

    public HelloController() {

        // create 3 three radio buttons
        radioButtonCheese = new JRadioButton("Cheese");
        radioButtonPepperoni = new JRadioButton("Pepperoni");
        radioButtonVeggie = new JRadioButton("Veggie");
        // create button group for radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonCheese);
        group.add(radioButtonPepperoni);
        group.add(radioButtonVeggie);
        // set a radio button as selected
        radioButtonCheese.setSelected(true);
        // create a panel for radio buttons
        JPanel pizzaTypePanel = new JPanel();
        pizzaTypePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
        // add radio button in panel
        pizzaTypePanel.setLayout(new GridLayout(4, 1));
        pizzaTypePanel.add(new JLabel("Pizza Type"));
        pizzaTypePanel.add(radioButtonCheese);
        pizzaTypePanel.add(radioButtonPepperoni);
        pizzaTypePanel.add(radioButtonVeggie);

        // create three check boxes
        checkBoxExtraCheese = new JCheckBox("ExtraCheese");
        checkBoxBacon = new JCheckBox("Bacon");
        checkBoxMushroom = new JCheckBox("Mushroom");
        // create a panel for check boxes
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
        // add check boxex in panel
        toppingsPanel.setLayout(new GridLayout(4, 1));
        toppingsPanel.add(new JLabel("Toppings"));
        toppingsPanel.add(checkBoxExtraCheese);
        toppingsPanel.add(checkBoxBacon);
        toppingsPanel.add(checkBoxMushroom);

        // add both panels into a panel
        JPanel panelTypeTopping = new JPanel();
        panelTypeTopping.add(pizzaTypePanel);
        panelTypeTopping.add(toppingsPanel);
        // create a textArea
        textArea = new JTextArea(7, 15);
        panelTypeTopping.add(textArea);
        panelTypeTopping.setBorder(new EmptyBorder(30, 30, 30, 30));

        btnProceed = new JButton("Proceed");
        JPanel panelProceedBtn = new JPanel();
        panelProceedBtn.setLayout(new GridLayout(1, 1));
        panelProceedBtn.add(btnProceed);
        panelProceedBtn.setBorder(new EmptyBorder(0, 0, 60, 0));

        panelOrderConfirm = new JPanel();
        panelOrderConfirm.setLayout(new BoxLayout(panelOrderConfirm, BoxLayout.Y_AXIS));
        panelOrderConfirm.add(new JLabel("Asurite Label"));
        textField = new JTextField();
        panelOrderConfirm.add(textField);
        btnConfirmOrder = new JButton("Confirm Order");
        panelOrderConfirm.add(btnConfirmOrder);
        btnConfirmOrder.setEnabled(false);
        panelOrderConfirm.setVisible(false);

        model = new DefaultTableModel();
        table = new MyTable(model);
        model.addColumn("ASURITE ID");
        model.addColumn("Price");
        model.addColumn("Pizza");
        model.addColumn("Status");
        JPanel panelTable = new JPanel();
        panelTable.setLayout(new GridLayout(1, 1));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        panelTable.add(scrollPane);
        table.setEditingColumn(3);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panelTypeTopping, BorderLayout.PAGE_START);
        panel.add(panelProceedBtn, BorderLayout.CENTER);
        panel.add(panelOrderConfirm, BorderLayout.PAGE_END);

        // set title
        this.setTitle("PIZZA SHOP");
        // set window size
        this.setSize(500, 500);
        // set default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set all into frame
        Container pane = this.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 1));
        labelPanel.add(new JLabel("SunDevil Pizza"));
        pane.add(labelPanel);
        pane.add(panel);
        pane.add(panelTable);

        // set this frame as visible
        setVisible(true);

        // set action listener on button
        btnProceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnProceed.setEnabled(false);
                double price = 0;
                String pizza = "";
                if (radioButtonCheese.isSelected()) {
                    price += 10.00;
                    pizza += "Cheese";
                } else if (radioButtonPepperoni.isSelected()) {
                    price += 12.00;
                    pizza += "Pepperoni";
                } else if (radioButtonVeggie.isSelected()) {
                    price += 15.00;
                    pizza += "Veggie";
                }
                if (checkBoxExtraCheese.isSelected()) {
                    price += 1.50;
                    pizza += "+ExtraCheese";
                }
                if (checkBoxBacon.isSelected()) {
                    price += 1.50;
                    pizza += "+Bacon";
                }
                if (checkBoxMushroom.isSelected()) {
                    price += 1.50;
                    pizza += "+Mushroom";
                }
                pizzaOrder.setPrice(price);
                pizzaOrder.setPizza(pizza);
                
                textArea.setText(String.format("\n\n\n%.1f", pizzaOrder.getPrice()));
                btnConfirmOrder.setEnabled(true);
                panelOrderConfirm.setVisible(true);
                panelProceedBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
            }
        });

        btnConfirmOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().trim().length() == 0) {
                    btnProceed.setEnabled(true);
                    panelOrderConfirm.setVisible(false);
                    panelProceedBtn.setBorder(new EmptyBorder(0, 0, 60, 0));
                    return;
                }
                TableColumn statusColumn = table.getColumnModel().getColumn(3);
                JComboBox comboBox = new JComboBox();
                comboBox.addItem("ACCEPTED");
                comboBox.addItem("READY to COOK");
                comboBox.addItem("COOKING");
                comboBox.addItem("READY");
                comboBox.setSelectedIndex(0);
                comboBox.addActionListener(new ActionListener() {//add actionlistner to listen for change
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String status = (String) comboBox.getSelectedItem();//get the selected item
                        if (status.equals("READY")) {
                            String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                            JOptionPane.showMessageDialog(null, "Email sent to " + id);
                        }
                    }
                });
                statusColumn.setCellEditor(new DefaultCellEditor(comboBox));
                pizzaOrder.setId(textField.getText().trim());
                pizzaOrder.setStatus(comboBox.getSelectedItem().toString());

                btnConfirmOrder.setEnabled(false);
                model.addRow(new Object[]{pizzaOrder.getId(), String.format("%.1f", pizzaOrder.getPrice()), pizzaOrder.getPizza(), pizzaOrder.getStatus()});
                textField.setText("");
                btnProceed.setEnabled(true);
                panelOrderConfirm.setVisible(false);
                panelProceedBtn.setBorder(new EmptyBorder(0, 0, 60, 0));
            }
        });

    }

    class MyTable extends JTable {

        public MyTable(DefaultTableModel model) {
            super(model);
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 3;
        }

    }

}
