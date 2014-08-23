/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javacrawler;

import java.io.IOException;

/**
 *
 * @author ubuntu
 */
public class HelpFile {
    
    public void help(String args[]) throws IOException
    {
     
        System.out.println("Menu");
        System.out.println("1. Start Crawler");
        System.out.println("2. Stop crawler");
        System.out.println("-l set log level");
    }
    
}
