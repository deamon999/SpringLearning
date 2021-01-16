package com.gmail.deamon999.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
//    @GetMapping("/api")
    @ResponseBody
    public String mainPost() {
        return "string via response body";
    }

//    @RequestMapping(value = "/file", method = RequestMethod.POST)
//    public String loadFile(@RequestPart("file") byte file) {
//    public String loadFile(@RequestPart("file") MultipartFile file) throws IOException {
//     file.transferTo(new File("/tmp/" + file.getOriginalFilename()));
//    Servlet 3.+ and multipart bean should be commented
//    public String loadFile(@RequestPart(value = "file", required = false) Part file) throws IOException {
//        file.write(file.getSubmittedFileName());
//
//        return "index";
//    }
}
