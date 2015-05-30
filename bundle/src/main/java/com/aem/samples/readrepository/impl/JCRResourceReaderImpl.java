package com.aem.samples.readrepository.impl;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.samples.readrepository.JCRResourceReader;
@Component(name="JCRResourceReader", description="Service to read a JCR node property using JCR API")
@Service(value=JCRResourceReader.class)
public class JCRResourceReaderImpl implements JCRResourceReader {
	
	private static final Logger log = LoggerFactory.getLogger(JCRResourceReaderImpl.class);
	
	public String getProperty(String property, String path,Session session) throws PathNotFoundException, RepositoryException {
		if(log.isInfoEnabled())
			log.info("JCRResourceReaderImpl reading node {} and property {}",path,property);
		StringBuffer propertyValue= new StringBuffer(property).append(" value of node at ").append(path).append(" is : ");
		//Returns true if a node exists at absPath and this Session has read access to it; otherwise returns false. 
	
		if(session.nodeExists(path) && session.propertyExists(new StringBuffer(path).append("/").append(property).toString())){
			Node page = session.getNode(path);
			Property prop= page.getProperty (property);
			propertyValue.append(prop.getValue().getString());
		} 
		
		return propertyValue.toString();
	}
	

}
