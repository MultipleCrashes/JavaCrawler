/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javacrawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        
        //String regex;
        //regex = "/^(https?:\\/\\/|www[.])?([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$/";
         
    
        Pattern pat=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher=pat.matcher(URL);
        int countOfLinks=0;
        //System.out.println(matcher.matches());
        try{
        
        while(matcher.find())
        {
            
            boolean matcherState=matcher.find();
         
            if(matcherState)
            {
            //System.out.println(matcher.group(0));
            String completeUrl=matcher.group();
            
            
            ////System.out.println(completeUrl);
            
             //System.out.println(matcher.group(1));
            
            int firstIndex=completeUrl.indexOf('/');
            int secondIndex=completeUrl.indexOf('/',firstIndex+1);
            int endIndex=completeUrl.indexOf('/',secondIndex+1);
            if(endIndex==-1)   // the url consists of no more separator
            {
            endIndex=completeUrl.length();
            }
            File crawledFile=new File("/home/crawledFileList");
            //System.out.println(firstIndex);
            //System.out.println(secondIndex);
            //System.out.println(endIndex);
            System.err.println(completeUrl.substring(0,endIndex));
            if(!crawledFile.exists())
            {
                crawledFile.createNewFile();
            }
            FileWriter fw=new FileWriter(crawledFile.getAbsoluteFile(),true); 
            // True will append the data to file 
             
                BufferedWriter bw=new BufferedWriter(fw);
                bw.write(completeUrl);
                bw.write("\n");
                bw.close();
            //System.out.println(baseUrl);
            
            
            }
            //System.out.println(matcher.group(2));
            //System.out.println(matcher.group(3));
            
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
