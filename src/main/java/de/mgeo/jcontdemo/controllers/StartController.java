package de.mgeo.jcontdemo.controllers;


import de.mgeo.jcontdemo.models.LogLevelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StartController {

    private String buttonclass="";
    private String buttontext="";

    @Autowired
    private Environment env;

    // inject via application.properties
    @Value("${html.title}")
    private String html_title;

    @Value("${ccm.envs}")
    private String link_envs;

    @Value("${ccm.secrets}")
    private String link_secrets;

    @Value("${ccm.configmaps}")
    private String link_configmaps;

    @Value("${app.version}")
    private String html_version;

    LogLevelModel LogMo = new LogLevelModel();

    @GetMapping("/")
    public String main(Model model) {
        buttonclass=LogMo.btn;
        buttontext=LogMo.value;

        model.addAttribute("html_title", html_title);
        model.addAttribute("html_version",html_version);
        model.addAttribute("isEnv",LogMo.isEnv());
        model.addAttribute("isSecret",LogMo.isSecret());
        model.addAttribute("isConfigMap",LogMo.isConfigmap());
        model.addAttribute("buttonclass",buttonclass);
        model.addAttribute("buttontext",buttontext);
        model.addAttribute("link_envs",link_envs.replace("\"",""));
        model.addAttribute("link_secrets",link_secrets.replace("\"",""));
        model.addAttribute("link_configmaps",link_configmaps.replace("\"",""));

        return "home"; //view
    }

//    private String getLogButton() {
//        return loglevel;
//    }

//    private void setButtons() {
//        if (LogMo.isSet) {
//            buttonclass=LogMo.btn;
//            buttontext=LogMo.value;
//            return;
//        }
//        else if (cfmMo.isSet)  {
//            buttonclass=cfmMo.btn;
//            buttontext=cfmMo.value;
//            secMo.disable();
//            envMo.disable();
//            return;
//        }
//        else if (envMo.isSet)  {
//            buttonclass=envMo.btn;
//            buttontext=envMo.value;
//            cfmMo.disable();
//            secMo.disable();
//            return;
//        }
//        return;
//    }


}