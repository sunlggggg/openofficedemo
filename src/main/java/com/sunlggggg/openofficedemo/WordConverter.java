package com.sunlggggg.openofficedemo;

import java.io.File;
import java.net.ConnectException;

/**
 * @author sunligang
 * @date 2019/01/29
 */
public interface WordConverter {
    /**
     * word 转 pdf
     *
     * @param inFile    指定word 文件 和 类型
     * @param outFile 输出文件,由文件后缀确定输出文件格式
     * @return
     * @throws ConnectException openOffice服务异常
     */
    void transfer(File inFile, File outFile) throws RenameFailException;
}
