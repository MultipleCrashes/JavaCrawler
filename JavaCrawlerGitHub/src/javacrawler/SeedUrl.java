/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javacrawler;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class SeedUrl {
    public ArrayList<String> getSeedUrl()
    {
       ArrayList<String> seedUrlList=new ArrayList<String>();
       seedUrlList.add("http://www.labnol.org");
       seedUrlList.add("http://www.mashable.com");
       seedUrlList.add("http://www.flipkart.com");
       seedUrlList.add("http://www.amazon.com");
       seedUrlList.add("http://www.youtube.com");
       seedUrlList.add("http://www.linkedin.com");
       seedUrlList.add("http://www.facebook.com");
       seedUrlList.add("http://www.redtube.com");
       return seedUrlList;
    }    
}
