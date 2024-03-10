package com.github.zcxu.ui.menu;

import com.github.zcxu.MainWindow;
import com.github.zcxu.global.Constants;

import javax.swing.*;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui.menu
 * @className: FileMenu
 * @author: Z. XU
 * @description: File Menu
 * @date: 2024/3/10 0:02
 * @version: 1.0
 */
public class FileMenu extends JMenu {

    public FileMenu(MainWindow frame) {
        super(Constants.MENU_FILE);
        add(new ImportMenuItem(frame));
        add(new ExportMenuItem(frame));
    }
}
