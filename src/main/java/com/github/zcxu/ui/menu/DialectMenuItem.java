package com.github.zcxu.ui.menu;

import com.github.vertical_blank.sqlformatter.languages.Dialect;
import com.github.zcxu.global.Constants;
import com.github.zcxu.global.Metadata;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui.menu
 * @className: DialectMenuItem
 * @author: Z. XU
 * @description: Dialect Selection
 * @date: 2024/3/9 23:33
 * @version: 1.0
 */
public class DialectMenuItem extends JMenuItem {

    private boolean checked;

    public DialectMenuItem(Dialect dialect, DialectMenu menu) {
        super(dialect.name());
        this.checked = Metadata.dialect.equals(dialect);
        if (checked) {
            resetIcon();
        }
        addActionListener(e -> {
            if (!checked) {
                menu.clearCheck();
                Metadata.dialect = dialect;
                setChecked(true);
                resetIcon();
            }
        });
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void resetIcon() {
        Image image;
        try {
            image = ImageIO.read(Objects.requireNonNull(DialectMenuItem.class.getClassLoader().getResourceAsStream(Constants.IMG_CHECK_PATH))).getScaledInstance(Constants.ICON_WIDTH / 2, Constants.ICON_HEIGHT / 2, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageIcon scaledIcon = new ImageIcon(image);
        setIcon(scaledIcon);
    }
}
