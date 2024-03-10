package com.github.zcxu.ui.panel;

import com.github.vertical_blank.sqlformatter.SqlFormatter;
import com.github.zcxu.global.Constants;
import com.github.zcxu.global.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui
 * @className: ButtonPanel
 * @author: Z. XU
 * @description: Buttons
 * @date: 2024/3/9 20:52
 * @version: 1.0
 */
public class ButtonPanel extends JPanel {

    private static final Logger logger = LoggerFactory.getLogger(ButtonPanel.class);
    private TextPanel leftPanel;

    private TextPanel rightPanel;

    public ButtonPanel(TextPanel leftPanel, TextPanel rightPanel) {
        this(new GridBagLayout(), leftPanel, rightPanel);
    }

    public ButtonPanel(LayoutManager layoutManager, TextPanel leftPanel, TextPanel rightPanel) {
        super(layoutManager);
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;

        addButton(Button.FORMAT);
        addButton(Button.COPY);
        addButton(Button.PASTE);
        addButton(Button.CLEAR_LEFT);
        addButton(Button.CLEAR_RIGHT);
    }

    private void addButton(Button button) {
        JButton myButton = new JButton(button.getName());
        Image image;
        try {
            image = ImageIO.read(Objects.requireNonNull(ButtonPanel.class.getClassLoader().getResourceAsStream(button.getImagePath()))).getScaledInstance(Constants.ICON_WIDTH, Constants.ICON_HEIGHT, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageIcon scaledIcon = new ImageIcon(image);
        myButton.setIcon(scaledIcon);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        // Define Y position by id
        c.gridy = button.getId();
        c.weightx = 0.1;
        c.insets = new Insets(10, 10, 10, 10);
        add(myButton, c);
        switch (button.getId()) {
            case Constants.ID_FORMAT:
                myButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String before = leftPanel.getTextArea().getText();
                        String after = SqlFormatter.of(Metadata.dialect).format(before);
                        rightPanel.getTextArea().setText(after);
                    }
                });
                break;
            case Constants.ID_COPY:
                myButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        StringSelection ss = new StringSelection(rightPanel.getTextArea().getText());
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clipboard.setContents(ss, null);
                    }
                });
                break;
            case Constants.ID_PASTE:
                myButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        Transferable contents = clipboard.getContents(null);
                        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                            try {
                                String clipboardText = (String) contents.getTransferData(DataFlavor.stringFlavor);
                                leftPanel.getTextArea().setText(clipboardText);
                            } catch (UnsupportedFlavorException | IOException ex) {
                                logger.error(ex.getLocalizedMessage());
                            }
                        }
                    }
                });
                break;
            case Constants.ID_CLEAR_LEFT:
                myButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        leftPanel.getTextArea().setText("");
                    }
                });
                break;
            case Constants.ID_CLEAR_RIGHT:
                myButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        rightPanel.getTextArea().setText("");
                    }
                });
                break;

        }

    }


}
