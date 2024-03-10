package com.github.zcxu.ui.panel;

import com.github.zcxu.global.Constants;
import com.github.zcxu.global.Metadata;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * @projectName: sql-formatter-gui
 * @package: com.github.zcxu.ui
 * @className: TextPanel
 * @author: Z. XU
 * @description: Original/Formatted SQL Text Panel
 * @date: 2024/3/9 15:48
 * @version: 1.0
 */
public class TextPanel extends JPanel {

    private RSyntaxTextArea textArea;

    private RTextScrollPane pane;

    public TextPanel(int type) {
        this(new BorderLayout(), type);
    }

    public TextPanel(LayoutManager layoutManager, int type) {
        super(layoutManager);
        setBorder(BorderFactory.createTitledBorder(type == Constants.TYPE_LEFT ? Constants.TITLE_LEFT : Constants.TITLE_RIGHT));

        textArea = new RSyntaxTextArea(Constants.INIT_ROWS, Constants.INIT_COLS);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SQL);
        textArea.setCodeFoldingEnabled(true);
        textArea.setFont(Metadata.font);

        pane = new RTextScrollPane(this.textArea);

        add(pane);
    }

    public RSyntaxTextArea getTextArea() {
        return textArea;
    }

}
