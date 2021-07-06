package com.elinext.testingplaygrounddemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ILogger {
    default Logger log() {
        return LogManager.getLogger(this.getClass());
    }
}
