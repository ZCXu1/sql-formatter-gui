package com.github.zcxu.ui.menu;

import com.github.zcxu.MainWindow;
import com.github.zcxu.global.Constants;

import javax.swing.*;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui.menu
 * @className: SettingMenu
 * @author: Z. XU
 * @description: Settings
 * @date: 2024/3/9 21:43
 * @version: 1.0
 */
public class SettingMenu extends JMenu {
    public SettingMenu(MainWindow frame) {
        super(Constants.MENU_SETTINGS);
        add(new FontMenuItem(frame));
        add(new DialectMenu());
    }
}
