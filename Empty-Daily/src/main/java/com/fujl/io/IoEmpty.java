package com.fujl.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IoEmpty {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\text.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

    }
}
