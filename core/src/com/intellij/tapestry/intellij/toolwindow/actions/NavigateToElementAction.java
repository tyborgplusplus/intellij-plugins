package com.intellij.tapestry.intellij.toolwindow.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.tapestry.core.model.presentation.InjectedElement;
import com.intellij.tapestry.core.model.presentation.PresentationLibraryElement;
import com.intellij.tapestry.intellij.core.java.IntellijJavaClassType;
import com.intellij.tapestry.intellij.util.Icons;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class NavigateToElementAction extends AnAction {

    private JTree _tree;

    public NavigateToElementAction(JTree tree) {
        super("Navigate to Element", "Navigate to the selected element class", Icons.NAVIGATE);

        _tree = tree;
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(AnActionEvent event) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) _tree.getSelectionPath().getLastPathComponent();
        Object selectedObject = selectedNode.getUserObject();

        if (selectedObject instanceof PresentationLibraryElement) {
            ((IntellijJavaClassType) ((PresentationLibraryElement) selectedObject).getElementClass()).getPsiClass().navigate(true);
        }
        if (selectedObject instanceof InjectedElement) {
            ((IntellijJavaClassType) ((InjectedElement) selectedObject).getElement().getElementClass()).getPsiClass().navigate(true);
        }
    }
}
