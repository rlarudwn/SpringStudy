package com.sist.main;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlerMapping extends DefaultHandler{
	private Map map=new HashMap();
	public Map getMap() {
		return map;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if(qName.equals("bean")) {
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				map.put(id, obj);
			}
		} catch (Exception e) {}
	}
	
}
