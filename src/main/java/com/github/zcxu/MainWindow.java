package com.github.zcxu;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.zcxu.global.Constants;
import com.github.zcxu.ui.menu.FileMenu;
import com.github.zcxu.ui.menu.SettingMenu;
import com.github.zcxu.ui.panel.MainPanel;

import javax.swing.*;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu
 * @className: MainWindow
 * @author: Z. XU
 * @description: Main Window
 * @date: 2024/3/9 13:51
 * @version: 1.0
 */
public class MainWindow extends JFrame {

    private MainPanel mainPanel;

    public MainWindow() {
        this.mainPanel = new MainPanel();
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new FileMenu(this));
        menuBar.add(new SettingMenu(this));


        setJMenuBar(menuBar);
        setContentPane(mainPanel);
        setTitle(Constants.TITLE_WINDOW);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Use FlatLightLaf
        FlatLightLaf.setup();
        // Start all Swing applications
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
