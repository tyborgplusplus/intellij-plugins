package com.intellij.tapestry.intellij.view.actions;

import com.intellij.openapi.actionSystem.ToggleAction;
import com.intellij.tapestry.intellij.util.Icons;

public abstract class StartInBasePackageAction extends ToggleAction {

    public StartInBasePackageAction() {
        super("Show From Base Package", "Only Show Content From the Application Base Package", Icons.COMPACT_BASE_PACKAGE);
    }
}
