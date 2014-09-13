/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crawler.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author ubuntu
 */
public class pingableUrl {

    public static void main(String args[]) throws IOException {
        String checkIfGoodUrl = " http://harishkumarupadhyay.com";
        boolean available;
        try {
            final URLConnection connection = new URL(checkIfGoodUrl).openConnection();
            connection.connect();
            System.out.println("URL Available for pinging");
            available=true;
        }
        catch(final MalformedURLException e)
                {
                    System.out.println("Malformed URL");
                    throw new IllegalStateException("Bad URl",e);
                }
        catch(final IOException e)
        {
            System.out.println("False this url is not pingable");
           available=false;
        }
    }

}
