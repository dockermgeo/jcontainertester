package de.mgeo.jcontdemo.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RequestMapping("/env")
public class EnvPrintController {
    private static final Logger logger = LogManager.getLogger(EnvPrintController.class);


    @RequestMapping(value="/env", method = RequestMethod.GET)
    public String printEnv() {
        Map<String, String> ENV_VARS = System.getenv();
        //ENV_VARS.entrySet().forEach(logger::info);
        String rc = "<code>";
        for (Map.Entry<String, String> entry : ENV_VARS.entrySet())
        {
            rc += "<b>" + entry.getKey() + "</b>: <i>" + entry.getValue() +"</i><br>\n";
            logger.debug("KEY: '" + entry.getKey() + "' - VALUE: '" + entry.getValue() +"'");
        }
        return rc+"</code>";
    }

    @RequestMapping(value="/env/{key}", method = RequestMethod.GET)
    public String printGetEnv(@PathVariable("key") String key) {
        String rckey = System.getenv(key);
        logger.debug("KEY: '" + key + "' - VALUE: '" + rckey +"'");
        return rckey;
    }
}

