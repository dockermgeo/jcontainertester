package de.mgeo.jenvsecrets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ContentEnv {
    private static final Logger logger = LogManager.getLogger(JenvsecretsApplication.class);

    ContentEnv() {
        printline("*",150);
        System.out.println(" * Working on LOG_LEVEL='"+logger.getLevel()+"'");
        printline("*",150);

        logger.debug("* Test: Debugging log");
        logger.info("* Test: Info log");
        logger.warn("* Test: Hey, This is a warning!");
        logger.error("* Test: Oops! We have an Error. OK");
        logger.fatal("* Test: Damn! Fatal error. Please fix me.");

        printline("*",150);
    }

    private static void printline(String str, int max) {
        for (int i=0; i<max;i++){
            System.out.print(str);
        }
        System.out.println("");
    }
}
