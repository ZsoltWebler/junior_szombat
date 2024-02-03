package java_database.view;

import java_database.model.SongDao;
import java_database.repository.SongRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Spotify extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private SongRepository repository;


    public Spotify(SongRepository repository) {
        this.repository = repository;
        init();
        refreshTable();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 631, 410);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        contentPane.add(panel, gbc_panel);
        panel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null,},
                },
                new String[]{
                        "Id", "Title", "Artist", "Genre", "Release year"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Integer.class, String.class, String.class, String.class, Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.anchor = GridBagConstraints.EAST;
        gbc_panel_1.fill = GridBagConstraints.VERTICAL;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 1;
        contentPane.add(panel_1, gbc_panel_1);

        JButton refreshRoomButton = new JButton("Refresh");
        refreshRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        panel_1.add(refreshRoomButton);

        JButton addSongButton = new JButton("Add song");
        addSongButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddSongDialog();
            }
        });
        panel_1.add(addSongButton);
    }

    private void openAddSongDialog() {

        throw new UnsupportedOperationException();
    }

    public void addSong(SongDao song) {
        throw new UnsupportedOperationException();
    }

    void refreshTable() {

        List<SongDao> songDaos = repository.getAll();

        Object[][] rows = new Object[songDaos.size()][7];

        for (int i = 0; i < songDaos.size(); i++) {
            SongDao songDao = songDaos.get(i);
            rows[i] = new Object[]{songDao.getSongId(), songDao.getTitle(), songDao.getTitle(), songDao.getGenre(), songDao.getReleaseYear()};
        }


        table.setModel(new DefaultTableModel(
                rows,
                new String[]{
                        "Id", "Title", "Artist", "Genre", "Release year"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Integer.class, String.class, String.class, String.class, Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
    }


}
