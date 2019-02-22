package de.mgeo.jcontest.controllers;

import de.mgeo.jcontest.JContTestApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = LogManager.getLogger(JContTestApplication.class);

    @Autowired
    private Environment env;

    @RequestMapping(method = RequestMethod.GET)
    String index() {
        String loglevel = logger.getLevel().toString();
        String cssc;
        switch (loglevel.toLowerCase()) {
            case "debug": cssc = "body{background-color: darkgreen; color:white;} a, a:hover{color:white;}";
                break;
            case "info": cssc = "body{background-color: white; color:black;} a, a:hover{color:black;}";
                break;
            case "warn": cssc = "body{background-color: yellow; color:black;} a, a:hover{color:black;}";
                break;
            case "fatal": cssc = "body{background-color: red; color:black;} a, a:hover{color:black;}";
                break;
            case "trace": cssc = "body{background-color: darkblue; color:white;} a, a:hover{color:white;}";
                break;
            case "error": cssc = "body{background-color: brown; color:white;} a, a:hover{color:white;}";
                break;
            case "off": cssc = "body{background-color: black; color:white;} a, a:hover{color:white;}";
                break;
            default: cssc = "body{background-color: red; color:black;} a, a:hover{color:black;}";
                break;
        }

        printFileToString("./secrets/user.secret");
        printFileToString("./secrets/password.secret");


        String html_title=env.getProperty("de.mgeo.title");
        StringBuilder out = new StringBuilder();
        out.append("<html><head><title>"+html_title.toUpperCase()+"</title>");
        out.append("<link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet' type='text/css'>");
        out.append("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.6.3/css/all.css' integrity='sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/' crossorigin='anonymous'>");
        out.append("<link href='/style.css' rel='stylesheet' type='text/css'>");
        out.append("<style>"+cssc+"</style>");
        out.append("</head><body><div class='container'><h1><span class='fas fa-hippo'></span> "+html_title+"</h1>");
        out.append("<div class='navigation'>Start - <a href='env.html'>ENV-Sets</a> - <a href='secrets.html'>Secrets</a> - <a href='aufgabe.html'>Aufgabe</a></div>");
        out.append("<h3><span class='fab fa-linux'></span> Env-Sets</h3><ul>");
        out.append(printEnv("LOG_LEVEL"));
        out.append(printEnv("LOG_LEVEL_ROOT"));
        out.append(printEnv("EMPTY"));
        out.append(printString("BUILD_NUMBER", loadFileToString("./version")));
        out.append("</ul>");
        out.append("<h3><span class='fas fa-key'></span> Secrets</h3><ul>");
        out.append(printString("user.secret", loadFileToString("./secrets/user.secret")));
        out.append(printString("password.secret", loadFileToString("./secrets/password.secret")));
        out.append("</ul></div>");
        out.append("</body></html>");

        return out.toString();
    }

    private static void printout(String str) {
        System.out.println(str);
    }

    private String printEnv (String name) {
        return "<li><b>"+name+":</b> "+System.getenv(name)+"</li>";
    }
    private String printString (String name, String str) {
        return "<li><b>"+name+":</b> "+str+"</li>";
    }


    private static String loadFileToString(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
            return "";
        }
        return contentBuilder.toString();
    }

    private static void printFileToString(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
        }
        printout( contentBuilder.toString() );
    }
}
