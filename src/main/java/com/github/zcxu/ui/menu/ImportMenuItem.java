package com.github.zcxu.ui.menu;

import com.github.zcxu.MainWindow;
import com.github.zcxu.global.Constants;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui.menu
 * @className: ImportMenuItem
 * @author: Z. XU
 * @description: Import
 * @date: 2024/3/10 8:49
 * @version: 1.0
 */
public class ImportMenuItem extends JMenuItem {

    private static final Logger LOG = LoggerFactory.getLogger(ImportMenuItem.class);

    public ImportMenuItem(MainWindow frame) {
        super(Constants.MENU_IMPORT);
        addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.sql,*.txt", "sql", "txt");
            fileChooser.setFileFilter(filter);

            int returnValue = fileChooser.showOpenDialog(frame);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    String s = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                    frame.getMainPanel().getLeftPanel().getTextArea().setText(s);
                } catch (IOException ex) {
                    LOG.error(ex.getMessage());
                }
            }
        });
    }
}
