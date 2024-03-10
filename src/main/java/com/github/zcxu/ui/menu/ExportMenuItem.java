package com.github.zcxu.ui.menu;

import com.github.zcxu.MainWindow;
import com.github.zcxu.global.Constants;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin2.util.SystemUtil;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui.menu
 * @className: ExportMenuItem
 * @author: Z. XU
 * @description: Export
 * @date: 2024/3/10 8:50
 * @version: 1.0
 */
public class ExportMenuItem extends JMenuItem {
    private static final Logger LOG = LoggerFactory.getLogger(ExportMenuItem.class);

    public ExportMenuItem(MainWindow frame) {
        super(Constants.MENU_EXPORT);
        addActionListener(e -> {
            String s = frame.getMainPanel().getRightPanel().getTextArea().getText();
            JFileChooser dirChooser = new JFileChooser();
            dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int ret = dirChooser.showOpenDialog(frame);
            if (ret == JFileChooser.APPROVE_OPTION) {
                // Choose a directory and export to it
                File dir = dirChooser.getSelectedFile();
                File file = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + "formatted_" + System.currentTimeMillis() + ".sql");
                try {
                    FileUtils.write(file, s, StandardCharsets.UTF_8);
                } catch (IOException ex) {
                    LOG.error(ex.getMessage());
                }
            }
        });
    }
}
