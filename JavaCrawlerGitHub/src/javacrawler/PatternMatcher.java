/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javacrawler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ubuntu
 */
public class PatternMatcher {
    
      
    public int ifUrl(String URL) throws IOException
    {   //String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
        String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
        Pattern pat=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher=pat.matcher(URL);
        int countOfLinks=0;
        //System.out.println(matcher.matches());
        try{
        
        while(matcher.find())
        {
            //System.out.println(URL);
            System.out.println(matcher.find());
            boolean matcherState=matcher.find();
           // What the API documentation further says is:

//The explicit state of a matcher is initially undefined; attempting to query 
//        any part of it before a successful match 
//                will cause an IllegalStateException to be thrown.
            if(matcherState)
            {
            System.out.println(matcher.group(0));
            
            }
            //System.out.println(matcher.group(2));
            //System.out.println(matcher.group(3));
            System.out.println(countOfLinks);
            countOfLinks++;
            //System.out.println(matcher.matches());
//            try
//            {
//            TimeUnit.SECONDS.wait(5);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
           }
        }
        catch(IllegalStateException e)
                {
               e.printStackTrace();
                }
        
               
       
        return 0;
        
    }    
}
