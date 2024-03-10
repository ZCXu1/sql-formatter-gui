package com.github.zcxu.ui.menu;

import com.github.vertical_blank.sqlformatter.languages.Dialect;
import com.github.zcxu.global.Constants;

import javax.swing.*;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui.menu
 * @className: DialectMenuItem
 * @author: Z. XU
 * @description: SQL Dialect Setting
 * @date: 2024/3/9 21:47
 * @version: 1.0
 */
public class DialectMenu extends JMenu {


    public DialectMenu() {
        super(Constants.MENU_DIALECT);
        add(new DialectMenuItem(Dialect.N1ql, this));
        add(new DialectMenuItem(Dialect.Db2, this));
        add(new DialectMenuItem(Dialect.MariaDb, this));
        add(new DialectMenuItem(Dialect.MySql, this));
        add(new DialectMenuItem(Dialect.PlSql, this));
        add(new DialectMenuItem(Dialect.PostgreSql, this));
        add(new DialectMenuItem(Dialect.Redshift, this));
        add(new DialectMenuItem(Dialect.SparkSql, this));
        add(new DialectMenuItem(Dialect.StandardSql, this));
        add(new DialectMenuItem(Dialect.TSql, this));
    }

    public void clearCheck() {
        for (int i = 0; i < getItemCount(); i++) {
            DialectMenuItem item = (DialectMenuItem) getItem(i);
            item.setIcon(null);
            item.setChecked(false);
        }
    }
}
