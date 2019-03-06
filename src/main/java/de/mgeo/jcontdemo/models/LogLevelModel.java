package de.mgeo.jcontdemo.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogLevelModel {
    private static final Logger logger = LogManager.getLogger(LogLevelModel.class);

    public boolean isSet = false;
    public String value = "empty";
    public String envtype = "env";
    public String btn = "danger";


    public LogLevelModel() {

        if (System.getenv("ENVTYPE") != null)
            envtype = System.getenv("ENVTYPE");

        if (envtype.equals("configmap")) {
            value = System.getenv("LOGLEVEL_DOMAIN");
        } else {
            value = System.getenv("LOGLEVEL_APP");
        }


        if (value == null)
            value = "error";

        //Switch Colors
        this.setBtn(value);
    }

    public boolean isEnv() {
        logger.debug("LOGTYPE: " + envtype);
        if (envtype.equals("env"))
            return true;

        return false;
    }

    public boolean isSecret() {
        if (envtype.equals("secret"))
            return true;

        return false;
    }

    public boolean isConfigmap() {
        if (envtype.equals("configmap"))
            return true;

        return false;
    }

    private void setBtn(String value) {
        switch (value.toLowerCase()) {
            case "info":
                this.btn = "success";
                break;
            case "off":
                this.btn = "dark";
                break;
            case "fatal":
                this.btn = "secondary";
                break;
            case "error":
                this.btn = "danger";
                break;
            case "warn":
            case "warning":
                this.btn = "warning";
                break;
            case "debug":
                this.btn = "primary";
                break;
            case "trace":
                this.btn = "info";
                break;
            case "*":
                this.btn = "primary";
                break;
        }
    }

    public void disable() {
        this.isSet = false;
    }

}
