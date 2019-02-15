package com.sunlggggg.openofficedemo;

/**
 * @author sunligang
 * @date 2019/02/16
 */
public class RenameFailException extends Exception {
    public RenameFailException() {
        super("rename fail");
    }

    public RenameFailException(String message) {
        super(message);
    }
}
