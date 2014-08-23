/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alexa.siterating;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author ubuntu
 */
public class AlexaRating {
    
    public static void main getAlexaRating(String args[]) throws IOException
    {
        int result=0;
        String domain="http://www.google.com";
        String url="http://data.alex.com/data?cli=10&url="+domain;
        
        try 
        {
            URLConnection conn=new URL(url).openConnection();
            InputStream is=conn.getInputStream();
            DocumentBuilder dBuilder=DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc=dBuilder.parse(is);
            Element element=doc.getDocumentElement();
            NodeList nodeList=element.getElementsByTagName("POPULARITY");
            if(nodeList.getLength()>0)
            {
                Element elementAttribute=(Element) nodeList.item(0);
                String ranking= elementAttribute.getAttribute("TEXT");
                if(!"".equals(ranking))
                {
                    result=Integer.valueOf(ranking);
                }
            }
            
        }
        catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
        System.out.print("The rating is ");
        System.out.println(result);
    }
    
}
