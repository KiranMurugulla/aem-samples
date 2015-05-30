package com.aem.samples.readrepository;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;


/**
 * This sample interface demonstrates how a resource from the repository can be read with JCR API.
 * Please note that for all simple reads it is the best practice to use Sling API , 
 * look at {{@link SlingResourceReader} in the same package. The reason to use Sling API is to abstract out
 * lots of internal details to be supplied when using JCR API.For more details check the blog at
 * http://cqdump.wordpress.com/2012/11/06/cq5-coding-patterns-sling-vs-jcr-part-1/
 * 
 * @author Kiran Murugulla
 *
 */

public interface JCRResourceReader {

	public String getProperty(String property , String path,Session session) throws PathNotFoundException, RepositoryException;

}
