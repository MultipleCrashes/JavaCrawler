/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

import javacrawler.PatternMatcher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ubuntu
 */
public class JavaCrawler {

    /**
     * @param args the command line arguments
     */
    
    public void startCrawler() throws IOException {
        URL url;
        long totalNumberOfCrawledUrl=0;
        SeedUrl seedObj = new SeedUrl();
        ArrayList<String> urlList = seedObj.getSeedUrl();
        // For each URL in the url List iterating and getting the html and 
        // parsing each line to find a url  
        for (String urls :urlList) {
            try {
                url = new URL(urls);
                long totalLinksFromEachSite=0;
                PatternMatcher objOfPatternMatcher = new PatternMatcher();
                System.out.println(url);
                String inputLine;
                // Open connection to the seed page
                URLConnection connObj = url.openConnection();

                // Open a stream and put the contents in the stream
                String fileName = "/home/crawledFile.html";
                BufferedReader bfr = new BufferedReader(new InputStreamReader(connObj.getInputStream()));
                File file = new File(fileName);
                if (!file.exists()) {
                    System.out.println("File Does Not Exists Creating New File");
                    file.createNewFile();
                }
                // Using file writer to write to a file

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                while ((inputLine = bfr.readLine()) != null) {
                    bw.write(inputLine);     
                    totalLinksFromEachSite+=objOfPatternMatcher.ifUrl(inputLine);
                    totalNumberOfCrawledUrl+=objOfPatternMatcher.ifUrl(inputLine);
                    // Uncomment to print the complete HTML System.out.println(inputLine);
                    
                } // parsing of html file ends
                System.out.println("Total number of crawled URL for "+urls+"website is "+totalLinksFromEachSite);
                
                bw.close();
                bfr.close();
                System.out.println("Total number of crawled URL is "+totalNumberOfCrawledUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }  // for ends

    } // function ends

    public static void main(String[] args) throws IOException {

        JavaCrawler crawlerObj = new JavaCrawler();
        crawlerObj.startCrawler();

    } //function ends
}
