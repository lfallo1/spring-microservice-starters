package com.lancefallon.springstarter.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * handle index route when app starts. this will start the angular application
 * also handles 404 redirects
 *
 * @author lancefallon
 */
@Controller
public class IndexController {

    /**
     * default route
     *
     * @return
     */
    @RequestMapping("/")
    public String getIndex() {
        return "index.html";
    }


}
