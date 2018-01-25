package com.componentwise.eval;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    boolean test(Stream in) throws IOException {
        int r=-1;
        for(r=in.read();r!=60&&r!=-1;r=in.read()){
            
        }
        List<Integer> tag = new ArrayList<>();
        if(r==60){
            for(r=in.read();r!=62;r=in.read()){
                tag.add(r);
            }
        }
        return true;
    }
}
