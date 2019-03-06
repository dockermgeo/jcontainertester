package de.mgeo.jcontdemo.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CurrentLogger {
    private static final Logger logger = LogManager.getLogger(CurrentLogger.class);

    public CurrentLogger() {
        System.out.print("\n\n");
        this.printLine("-",150);
        System.out.print("Working on loglevel '"+logger.getLevel()+"'! See output now:\n");
        this.printLine("-",150);
        logger.debug("* Test: Debugging log");
        logger.info("* Test: Info log");
        logger.warn("* Test: Hey, This is a warning!");
        logger.error("* Test: Oops! We have an Error. OK");
        logger.fatal("* Test: Damn! Fatal error. Please fix me.");
        this.printLine("-",150);
        System.out.print("\n\n");
    }

    private static void printLine(String str, int max) {
        for (int i=0; i<max;i++){
            System.out.print(str);
        }
        System.out.println("");
    }
}
