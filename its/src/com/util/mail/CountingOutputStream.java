package com.util.mail;

import java.io.OutputStream;

class CountingOutputStream extends OutputStream   
{   
    private int count = 0;   
  
    public void write(int b) { count++; }   
  
    public int getCount() { return count; }   
}   
