package com.intellij.tapestry.intellij.facet.ui;

import javax.swing.*;

public class NewFacetDialog extends JDialog {

    private JPanel _mainPanel;
    private JTextField _filterName;
    private JTextField _applicationPackage;
    private JCheckBox _generateStartupApplication;
    private JCheckBox _generatePom;

    public NewFacetDialog() {
        setContentPane(_mainPanel);
        setModal(true);
    }

    public String getFilterName() {
        return _filterName.getText();
    }

    public String getApplicationPackage() {
        return _applicationPackage.getText();
    }

    public boolean shouldGenerateStartupApplication() {
        return _generateStartupApplication.isSelected();
    }

    public boolean shouldGeneratePom() {
        return _generatePom.isSelected();
    }

    public void setGenerateStartupApplication(boolean value) {
        _generateStartupApplication.setSelected(value);
    }

    public void setGeneratePom(boolean value) {
        _generatePom.setSelected(value);
    }

    public JPanel getMainPanel() {
        return _mainPanel;
    }
}
