package com.intellij.tapestry.intellij.view.nodes;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeBuilder;
import com.intellij.openapi.module.Module;
import com.intellij.psi.PsiJavaFile;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.tapestry.core.model.presentation.Page;
import com.intellij.tapestry.core.model.presentation.PresentationLibraryElement;
import com.intellij.tapestry.core.resource.IResource;
import com.intellij.tapestry.intellij.core.java.IntellijJavaClassType;
import com.intellij.tapestry.intellij.core.resource.IntellijResource;
import com.intellij.tapestry.intellij.util.Icons;

import java.util.ArrayList;
import java.util.List;

/**
 * Page node.
 */
public class PageNode extends TapestryNode {

    public PageNode(PresentationLibraryElement page, Module module, AbstractTreeBuilder treeBuilder) {
        super(module, treeBuilder);

        init(page, new PresentationData(page.getElementClass().getName(), page.getName(), Icons.PAGE, Icons.PAGE, null));
    }

    /**
     * {@inheritDoc}
     */
    public SimpleNode[] getChildren() {
        Page page = (Page) getElement();
        List<SimpleNode> children = new ArrayList<SimpleNode>();

        ClassNode classNode = new ClassNode((PsiJavaFile) ((IntellijJavaClassType) page.getElementClass()).getPsiClass().getContainingFile(), getModule(), _treeBuilder);
        children.add(classNode);

        for (IResource template : page.getTemplate())
            children.add(new FileNode(((IntellijResource) template).getPsiFile(), getModule(), _treeBuilder));

        for (IResource catalog : page.getMessageCatalog())
            children.add(new FileNode(((IntellijResource) catalog).getPsiFile(), getModule(), _treeBuilder));

        return children.toArray(new SimpleNode[0]);
    }
}
