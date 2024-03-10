package com.github.zcxu.ui.menu;

import com.github.zcxu.MainWindow;
import com.github.zcxu.global.Constants;
import com.github.zcxu.global.Metadata;
import com.l2fprod.common.swing.JFontChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui.menu
 * @className: FontMenuItem
 * @author: Z. XU
 * @description: Font Settings
 * @date: 2024/3/9 21:44
 * @version: 1.0
 */
public class FontMenuItem extends JMenuItem {

    public FontMenuItem(MainWindow frame) {
        super(Constants.MENU_FONT);

        addActionListener(e -> {
                    JFontChooser fontChooser = new JFontChooser();
                    Font curFont = Metadata.font;
                    fontChooser.setSelectedFont(curFont);
                    Font newFont = fontChooser.showFontDialog(frame, "Choose Font");
                    Metadata.font = newFont == null ? curFont : newFont;
                    frame.getMainPanel().getLeftPanel().getTextArea().setFont(Metadata.font);
                    frame.getMainPanel().getRightPanel().getTextArea().setFont(Metadata.font);
                }
        );
    }
}
