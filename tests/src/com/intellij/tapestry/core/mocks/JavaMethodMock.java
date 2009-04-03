package com.intellij.tapestry.core.mocks;

import com.intellij.tapestry.core.java.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Utility class for easy creation of IJavaMethod mocks.
 */
public class JavaMethodMock implements IJavaMethod {
    private String _name;
    private IJavaType _returnType;
    private Collection<IMethodParameter> _parameters = new ArrayList<IMethodParameter>();
    private Collection<IJavaAnnotation> _annotations = new ArrayList<IJavaAnnotation>();
    private IJavaClassType _containingClass;
    private String _documentation;

    public JavaMethodMock(String name) {
        _name = name;
    }

    public JavaMethodMock(String name, IJavaType returnType) {
        _name = name;
        _returnType = returnType;
    }

    public JavaMethodMock(String name, IJavaType returnType, Collection<IMethodParameter> parameters) {
        _name = name;
        _returnType = returnType;
        _parameters = parameters;
    }

    public String getName() {
        return _name;
    }

    public IJavaType getReturnType() {
        return _returnType;
    }

    public Collection<IMethodParameter> getParameters() {
        return _parameters;
    }

    public JavaMethodMock addParameter(IMethodParameter parameter) {
        _parameters.add(parameter);

        return this;
    }

    public Collection<IJavaAnnotation> getAnnotations() {
        return _annotations;
    }

    public void addAnnotation(IJavaAnnotation annotation) {
        _annotations.add(annotation);
    }

    public IJavaAnnotation getAnnotation(String annotationQualifiedName) {
        for (IJavaAnnotation annotation : _annotations)
            if (annotation.getFullyQualifiedName().equals(annotationQualifiedName))
                return annotation;

        return null;
    }

    public IJavaClassType getContainingClass() {
        return _containingClass;
    }

    public void setContainingClass(IJavaClassType containingClass) {
        _containingClass = containingClass;
    }

    public String getDocumentation() {
        return _documentation;
    }

    public void setDocumentation(String documentation) {
        _documentation = documentation;
    }
}
