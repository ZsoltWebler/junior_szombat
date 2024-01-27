package java_database.view;

import java_database.controller.ImdbController;
import java_database.model.MovieDao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AddNewMovieDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField movieNameField;
    private JTextField imdbScoreField;
    private JTextField movieCategoryField;

    private final ImdbController controller;


    public AddNewMovieDialog(ImdbController controller) {
        this.controller = controller;
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel lblNewLabel = new JLabel("Movie name");
            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel.gridx = 0;
            gbc_lblNewLabel.gridy = 0;
            contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        }
        {
            movieNameField = new JTextField();
            GridBagConstraints gbc_movieNameField = new GridBagConstraints();
            gbc_movieNameField.insets = new Insets(0, 0, 5, 0);
            gbc_movieNameField.fill = GridBagConstraints.HORIZONTAL;
            gbc_movieNameField.gridx = 1;
            gbc_movieNameField.gridy = 0;
            contentPanel.add(movieNameField, gbc_movieNameField);
            movieNameField.setColumns(10);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("IMDB Score");
            GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
            gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_1.gridx = 0;
            gbc_lblNewLabel_1.gridy = 1;
            contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        }
        {
            imdbScoreField = new JTextField();
            GridBagConstraints gbc_imdbScoreField = new GridBagConstraints();
            gbc_imdbScoreField.insets = new Insets(0, 0, 5, 0);
            gbc_imdbScoreField.fill = GridBagConstraints.HORIZONTAL;
            gbc_imdbScoreField.gridx = 1;
            gbc_imdbScoreField.gridy = 1;
            contentPanel.add(imdbScoreField, gbc_imdbScoreField);
            imdbScoreField.setColumns(10);
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Movie Category ID");
            GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
            gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
            gbc_lblNewLabel_2.gridx = 0;
            gbc_lblNewLabel_2.gridy = 2;
            contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
        }
        {
            movieCategoryField = new JTextField();
            GridBagConstraints gbc_movieCategoryField = new GridBagConstraints();
            gbc_movieCategoryField.fill = GridBagConstraints.HORIZONTAL;
            gbc_movieCategoryField.gridx = 1;
            gbc_movieCategoryField.gridy = 2;
            contentPanel.add(movieCategoryField, gbc_movieCategoryField);
            movieCategoryField.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(e -> saveMovie());
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(e -> {
                    dispose();
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    private void saveMovie(){

        try {
            String movieName = movieNameField.getText();
            double imdbScore = Double.parseDouble(imdbScoreField.getText());
            int categoryId = Integer.parseInt(movieCategoryField.getText());

            MovieDao savable = new MovieDao(movieName, imdbScore, categoryId);

            controller.addMovie(savable);

            dispose();

        }catch (Exception e){

            JOptionPane.showMessageDialog(this,"Hibás felhasználói adatok!");

        }



    }

}

