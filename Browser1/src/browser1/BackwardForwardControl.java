/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser1;

import java.util.Stack;

/**
 *
 * @author dipu
 */
public class BackwardForwardControl {
    
    Stack<String> forwardUrls = new Stack<String>();
    Stack<String> backwardUrls = new Stack<String>();
    
    public String get_back(String str){
        
        String st = null;
        boolean x = true;
        
        while(x){
            if(backwardUrls.empty()){
               set_forward(str);
               return str;
            }

            st = backwardUrls.firstElement();
            backwardUrls.remove(0);

            if(st.compareTo(str)!=0){
                x = false;
                set_forward(st);
                return st;
            }
            if(backwardUrls.empty() && st==null){
                set_forward(str);
                return str;
            }
            if(backwardUrls.empty() && st!=null){
                set_forward(st);
                return st;
            }
        }
        set_forward(st);
        return st;
    }
    
    public String get_forward(String str){
        String st = null;
        
        if(!forwardUrls.empty()){
            st = forwardUrls.lastElement();
            forwardUrls.remove(forwardUrls.size()-1);
        }
        if(!forwardUrls.empty()){
            if(st == str){
                st = forwardUrls.lastElement();
                forwardUrls.remove(forwardUrls.size()-1);
            }
        }
        if(st == null){
            st = str;
        }
        
        set_backward(st);
        return st;
    }
    
    public void set_forward(String string){
        forwardUrls.add(string);
    }
    
    public void set_backward(String string){
        backwardUrls.insertElementAt(string, 0);
    }
    
    public void set_forward(){
        forwardUrls.clear();
    }
}
