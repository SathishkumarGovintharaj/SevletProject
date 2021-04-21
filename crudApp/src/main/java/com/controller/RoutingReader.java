package com.controller;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class RoutingReader {

   public static String getRouterFile(String id) {
	   Element eElement = null;
      try {
         
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder;
         
         dBuilder = dbFactory.newDocumentBuilder();

         Document doc = dBuilder.parse("Router.xml");
         doc.getDocumentElement().normalize();

         XPath xPath =  XPathFactory.newInstance().newXPath();
      
         String expression = "/files/router[@id = '"+id+"']";
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
            doc, XPathConstants.NODESET);
         
         for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                eElement = (Element) nNode;
             
               System.out.println("File Name : "
                  + eElement
                  .getElementsByTagName("filename")
                  .item(0)
                  .getTextContent());
             
            }
         }
      } catch (ParserConfigurationException e) {
         System.out.println(e);
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (XPathExpressionException e) {
         e.printStackTrace();
      }
      
      return eElement.getElementsByTagName("filename").item(0).getTextContent();
   }
}