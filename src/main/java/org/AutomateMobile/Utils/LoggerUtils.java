package org.AutomateMobile.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class LoggerUtils {

    protected final Logger log = LogManager.getLogger(this.getClass());

    private static final Logger logger = LogManager.getLogger(LoggerUtils.class);

    public static void info(String message) {
        logger.info(message);
    }

    public void logInfo(String message) {
        log.info(message);
    }

    public void logError(String message) {
        log.error(message);
    }

    public void logDebug(String message) {
        log.debug(message);
    }

    public void logStep(String step) {
        log.info(">>> STEP: {}", step);
    }
}
