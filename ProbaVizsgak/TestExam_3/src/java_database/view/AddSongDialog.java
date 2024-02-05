package java_database.view;

import java_database.model.SongDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSongDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    private Spotify owner;

    public AddSongDialog(Spotify owner) {
        super(owner);
        this.owner = owner;
        setModalityType(ModalityType.APPLICATION_MODAL);

        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel lblNewLabel = new JLabel("Title");
            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel.gridx = 0;
            gbc_lblNewLabel.gridy = 0;
            contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        }
        {
            textField = new JTextField();
            GridBagConstraints gbc_textField = new GridBagConstraints();
            gbc_textField.anchor = GridBagConstraints.EAST;
            gbc_textField.insets = new Insets(0, 0, 5, 0);
            gbc_textField.gridx = 1;
            gbc_textField.gridy = 0;
            contentPanel.add(textField, gbc_textField);
            textField.setColumns(10);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Artist");
            GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
            gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_1.gridx = 0;
            gbc_lblNewLabel_1.gridy = 1;
            contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        }
        {
            textField_1 = new JTextField();
            GridBagConstraints gbc_textField_1 = new GridBagConstraints();
            gbc_textField_1.anchor = GridBagConstraints.EAST;
            gbc_textField_1.insets = new Insets(0, 0, 5, 0);
            gbc_textField_1.gridx = 1;
            gbc_textField_1.gridy = 1;
            contentPanel.add(textField_1, gbc_textField_1);
            textField_1.setColumns(10);
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Genre");
            GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
            gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_2.gridx = 0;
            gbc_lblNewLabel_2.gridy = 2;
            contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
        }
        {
            textField_2 = new JTextField();
            GridBagConstraints gbc_textField_2 = new GridBagConstraints();
            gbc_textField_2.anchor = GridBagConstraints.EAST;
            gbc_textField_2.insets = new Insets(0, 0, 5, 0);
            gbc_textField_2.gridx = 1;
            gbc_textField_2.gridy = 2;
            contentPanel.add(textField_2, gbc_textField_2);
            textField_2.setColumns(10);
        }
        {
            JLabel lblNewLabel_3 = new JLabel("Release year");
            GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
            gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_3.gridx = 0;
            gbc_lblNewLabel_3.gridy = 3;
            contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
        }
        {
            textField_3 = new JTextField();
            GridBagConstraints gbc_textField_3 = new GridBagConstraints();
            gbc_textField_3.anchor = GridBagConstraints.EAST;
            gbc_textField_3.insets = new Insets(0, 0, 5, 0);
            gbc_textField_3.gridx = 1;
            gbc_textField_3.gridy = 3;
            contentPanel.add(textField_3, gbc_textField_3);
            textField_3.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        okButtonPressed();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cancelButtonPressed();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    public void showDialog() {
        setVisible(true);
    }

    private void okButtonPressed() {
        owner.addSong(parseFieldsToSongDao());
        setVisible(false);
        dispose();
    }

    private void cancelButtonPressed() {
        setVisible(false);
        dispose();
    }

    private SongDao parseFieldsToSongDao() {
        try {
            String title = textField.getText();
            String artist = textField_1.getText();
            String genre = textField_2.getText();
            int releaseYear = Integer.parseInt(textField_3.getText());

            return new SongDao(title, artist, genre, releaseYear);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

}

