package com.sunlggggg.openofficedemo.impl;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
import com.sunlggggg.openofficedemo.RenameFailException;
import com.sunlggggg.openofficedemo.WordConverter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.ConnectException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sunligang
 * @date 2019/01/29
 */
@NoArgsConstructor
@AllArgsConstructor
public class WordConverterImpl implements WordConverter {

    private String openOfficeServiceHost;

    private int openOfficeServicePort = 8100;

    private static Logger logger = LoggerFactory.getLogger(WordConverter.class);

    private static final String WORD_TYPE_DOCX = "docx";

    @Override
    public void transfer(File inFile, File outFile) throws RenameFailException {
        long startTime = System.currentTimeMillis();
        if (FilenameUtils.getExtension(inFile.getName()).equals(WORD_TYPE_DOCX)) {
            File newFile = new File(inFile.getPath().substring(0, inFile.getPath().length() - 1));
            if (inFile.renameTo(newFile)) {
                inFile = newFile;
            } else {
                throw new RenameFailException();
            }
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(openOfficeServiceHost, openOfficeServicePort);
        try {
            connection.connect();
        } catch (ConnectException e) {
            logger.info(e.getMessage());
        }
        //用于测试openOffice连接时间
        logger.info("连接时间:" + df.format(new Date()));
        DocumentConverter converter = new StreamOpenOfficeDocumentConverter(
                connection);
        converter.convert(inFile, outFile);
        //测试word转PDF的转换时间
        logger.info("转换时间:" + df.format(new Date()));
        long endTime = System.currentTimeMillis();
        logger.info("耗时:" + (endTime - startTime) / 1000 + "秒");
        connection.disconnect();
    }
}
