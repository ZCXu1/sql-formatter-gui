package com.github.zcxu.ui.panel;

import com.github.zcxu.global.Constants;

public enum Button {
    FORMAT(Constants.TITLES[Constants.ID_FORMAT], Constants.ID_FORMAT, Constants.IMG_ARROW_PATH),
    COPY(Constants.TITLES[Constants.ID_COPY], Constants.ID_COPY, Constants.IMG_COPY_PATH),
    PASTE(Constants.TITLES[Constants.ID_PASTE], Constants.ID_PASTE, Constants.IMG_PASTE_PATH),
    CLEAR_LEFT(Constants.TITLES[Constants.ID_CLEAR_LEFT], Constants.ID_CLEAR_LEFT, Constants.IMG_CLEAR_PATH),
    CLEAR_RIGHT(Constants.TITLES[Constants.ID_CLEAR_RIGHT], Constants.ID_CLEAR_RIGHT, Constants.IMG_CLEAR_PATH);

    private String name;

    // Define Y position by id
    private int id;

    private String imagePath;

    Button(String name, int id, String imagePath) {
        this.name = name;
        this.id = id;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }
}
