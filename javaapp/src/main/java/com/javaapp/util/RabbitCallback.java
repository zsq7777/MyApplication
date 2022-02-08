package com.javaapp.util;

public interface RabbitCallback {
    boolean process(String responseMsg);
}
