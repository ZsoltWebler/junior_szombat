package java_database.view;

import java_database.model.RoomCategoryDao;
import java_database.model.RoomDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class AddRoomDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField levelField;
    private JComboBox roomCategoryBox;
    private JTextField areaField;
    private JTextField priceField;

    private JCheckBox onSaleCheckBox;

    private JCheckBox reservedCheckBox;

    private final Hotel controller;

    public AddRoomDialog(Hotel controller, List<RoomCategoryDao> roomCategories) {
        this.controller = controller;
        setModalityType(ModalityType.APPLICATION_MODAL);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel lblNewLabel = new JLabel("Level");
            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel.gridx = 0;
            gbc_lblNewLabel.gridy = 0;
            contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        }
        {
            levelField = new JTextField();
            GridBagConstraints gbc_levelField = new GridBagConstraints();
            gbc_levelField.insets = new Insets(0, 0, 5, 0);
            gbc_levelField.fill = GridBagConstraints.HORIZONTAL;
            gbc_levelField.gridx = 1;
            gbc_levelField.gridy = 0;
            contentPanel.add(levelField, gbc_levelField);
            levelField.setColumns(10);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("RoomCategoryId");
            GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
            gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_1.gridx = 0;
            gbc_lblNewLabel_1.gridy = 1;
            contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        }
        {
            roomCategoryBox  = new JComboBox();
            roomCategoryBox.setModel(new DefaultComboBoxModel(roomCategories.stream().map(RoomCategoryDao::getRoomCategoryId).toArray()));
            GridBagConstraints gbc_comboBox = new GridBagConstraints();
            gbc_comboBox.insets = new Insets(0, 0, 5, 0);
            gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
            gbc_comboBox.gridx = 1;
            gbc_comboBox.gridy = 1;
            contentPanel.add(roomCategoryBox, gbc_comboBox);
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Area");
            GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
            gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_2.gridx = 0;
            gbc_lblNewLabel_2.gridy = 2;
            contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
        }
        {
            areaField = new JTextField();
            GridBagConstraints gbc_areaField = new GridBagConstraints();
            gbc_areaField.insets = new Insets(0, 0, 5, 0);
            gbc_areaField.fill = GridBagConstraints.HORIZONTAL;
            gbc_areaField.gridx = 1;
            gbc_areaField.gridy = 2;
            contentPanel.add(areaField, gbc_areaField);
            areaField.setColumns(10);
        }
        {
            JLabel lblNewLabel_3 = new JLabel("Price");
            GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
            gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_3.gridx = 0;
            gbc_lblNewLabel_3.gridy = 3;
            contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
        }
        {
            priceField = new JTextField();
            GridBagConstraints gbc_priceField = new GridBagConstraints();
            gbc_priceField.insets = new Insets(0, 0, 5, 0);
            gbc_priceField.fill = GridBagConstraints.HORIZONTAL;
            gbc_priceField.gridx = 1;
            gbc_priceField.gridy = 3;
            contentPanel.add(priceField, gbc_priceField);
            priceField.setColumns(10);
        }
        {
            JLabel lblNewLabel_4 = new JLabel("Reserved");
            GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
            gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_4.gridx = 0;
            gbc_lblNewLabel_4.gridy = 4;
            contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
        }
        {
            reservedCheckBox = new JCheckBox("");
            GridBagConstraints gbc_reservedCheckBox = new GridBagConstraints();
            gbc_reservedCheckBox.insets = new Insets(0, 0, 5, 0);
            gbc_reservedCheckBox.gridx = 1;
            gbc_reservedCheckBox.gridy = 4;
            contentPanel.add(reservedCheckBox, gbc_reservedCheckBox);
        }
        {
            JLabel lblNewLabel_5 = new JLabel("OnSale");
            GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
            gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
            gbc_lblNewLabel_5.gridx = 0;
            gbc_lblNewLabel_5.gridy = 5;
            contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
        }
        {
            onSaleCheckBox = new JCheckBox("");
            GridBagConstraints gbc_onSaleCheckBox = new GridBagConstraints();
            gbc_onSaleCheckBox.gridx = 1;
            gbc_onSaleCheckBox.gridy = 5;
            contentPanel.add(onSaleCheckBox, gbc_onSaleCheckBox);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(e -> {

                    try {
                        int level = Integer.parseInt(levelField.getText());
                        int roomCategory = Integer.parseInt(roomCategoryBox.getSelectedItem()+"");
                        double area = Double.parseDouble(areaField.getText());
                        int price = Integer.parseInt(priceField.getText());
                        boolean reserved = reservedCheckBox.isSelected();
                        boolean onSale = onSaleCheckBox.isSelected();


                        controller.addRoom(new RoomDao(level, roomCategory, area, price, reserved, onSale));

                        dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(AddRoomDialog.this, "Hibás adatok!");
                    }


                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(e -> dispose());
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}
