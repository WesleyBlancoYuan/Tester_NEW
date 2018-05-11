package com.WindThunderStudio.JAX_XML_Tree.logic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class JAXParser extends DefaultHandler{
    protected Object[] nodesNames;
    //index of pointer in the name array
    private int pointer;
    
    @Override
    public void startDocument() throws SAXException {
        
    }

    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        pointer--;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // TODO Auto-generated method stub
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // TODO Auto-generated method stub
        super.characters(ch, start, length);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        // TODO Auto-generated method stub
        super.warning(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        // TODO Auto-generated method stub
        super.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        // TODO Auto-generated method stub
        super.fatalError(e);
    }
    
    
}
