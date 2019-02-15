package com.sunlggggg.openofficedemo;

import com.sunlggggg.openofficedemo.impl.WordConverterImpl;

import java.io.File;

/**
 * 如果是docx的word直接重命名为doc文件
 * args[0]:host args[1]:port args[2]:doc file path args[3] pdf file out path
 *
 * @author sunligang
 * @date 2019/01/29
 */
public class Main {
    public static void main(String[] args) throws Exception {
        new WordConverterImpl(args[0], Integer.valueOf(args[1]))
                .transfer(new File(args[2]), new File(args[3]));
    }
}
