package com.intellij.tapestry.core.mocks;

import com.intellij.tapestry.core.resource.xml.XmlAttribute;
import com.intellij.tapestry.core.resource.xml.XmlTag;

import java.util.ArrayList;
import java.util.List;

/**
 * Description Class
 *
 * @author <a href="mailto:monica.carvalho@logical-software.com">Monica Carvalho</a>
 */

public class XmlTagMock implements XmlTag {

    private String _name;
    private String _namespace;
    private String _localName;
    private String _text;
    private List<XmlAttribute> _attributes = new ArrayList<XmlAttribute>();

    public XmlTagMock() {
    }

    public XmlTagMock(String localName) {
        _localName = localName;
    }

    public String getName() {
        return _name;
    }

    public XmlTagMock setName(String name) {
        _name = name;

        return this;
    }

    public String getNamespace() {
        return _namespace;
    }

    public XmlTagMock setNamespace(String namespace) {
        _namespace = namespace;

        return this;
    }

    public String getLocalName() {
        return _localName;
    }

    public XmlTagMock setLocalName(String localName) {
        _localName = localName;

        return this;
    }

    public String getText() {
        return _text;
    }

    public XmlTagMock setText(String text) {
        _text = text;

        return this;
    }

    public  XmlAttribute[] getAttributes() {
        return _attributes.toArray(new XmlAttribute[_attributes.size()]);
    }

    public XmlTagMock addAttribute(XmlAttribute attribute) {
        _attributes.add(new XmlAttributeMock(attribute.getLocalName(), attribute.getValue()));

        return this;
    }

    public XmlAttribute getAttribute(String name, String namespace) {
        return null;
    }
}
