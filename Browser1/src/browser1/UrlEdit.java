/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser1;

/**
 *
 * @author dipu
 */
public class UrlEdit {
    
    public String urlEdit(String userText)
    {
        //userText= userText.trim();
        userText = userText.replaceAll("\\s","");
        if(userText.charAt(0)!='h'){
         
        String st = "https://www.";
        st+=userText;
        return st;
        }
        else{
            return userText;
        }
        
        
    }
}
