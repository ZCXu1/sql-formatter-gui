package com.github.zcxu.ui.panel;

import com.github.zcxu.global.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui
 * @className: MainPanel
 * @author: Z. XU
 * @description: Main
 * @date: 2024/3/9 13:56
 * @version: 1.0
 */
public class MainPanel extends JPanel {

    private final TextPanel leftPanel;
    private final TextPanel rightPanel;

    private final ButtonPanel buttonPanel;

    public MainPanel() {
        this.leftPanel = new TextPanel(Constants.TYPE_LEFT);
        this.rightPanel = new TextPanel(Constants.TYPE_RIGHT);
        this.buttonPanel = new ButtonPanel(leftPanel, rightPanel);
        setLayout(new GridBagLayout());
        addLeftPanel();
        addRightPanel();
        addButtonPanel();
    }

    private void addLeftPanel() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.weightx = 0.45;
        c.weighty = 1;
        add(leftPanel, c);
    }

    private void addRightPanel() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.45;
        c.weighty = 1;
        add(rightPanel, c);
    }

    private void addButtonPanel() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.1;
        c.weighty = 1;
        add(buttonPanel, c);
    }

    public TextPanel getLeftPanel() {
        return leftPanel;
    }

    public TextPanel getRightPanel() {
        return rightPanel;
    }
}
