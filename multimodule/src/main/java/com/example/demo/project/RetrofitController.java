package com.example.demo.project;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class RetrofitController implements ErrorController {
	@Autowired
	RetrofitService retrofitService;
	

	@PostMapping("/saveEntity")
	public StudentEntity save(@RequestBody StudentEntity studentEntity) throws IOException {
		return retrofitService.createStudent(studentEntity);
	}
	@GetMapping("/retrofit/getAll")
	public List<StudentEntity> getAll() throws IOException {
		return retrofitService.allGet();
	}
	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "<!DOCTYPE html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
				"    <title>404 not found</title>\n" +
				"    <style>\n" +
				"        * {\n" +
				"    margin: 0;\n" +
				"    padding: 0;\n" +
				"}\n" +
				"\n" +
				"html {\n" +
				"    height: 100%;\n" +
				"    overflow: hidden;\n" +
				"}\n" +
				"\n" +
				"canvas {\n" +
				"    z-index: 1;\n" +
				"    position: absolute;\n" +
				"    left: 0;\n" +
				"    top: 0;\n" +
				"    width: 100%;\n" +
				"    height: 100%;\n" +
				"}\n" +
				"\n" +
				".caps {\n" +
				"    z-index: 2;\n" +
				"    position: absolute;\n" +
				"    left: 0;\n" +
				"    top: 0;\n" +
				"    width: 100%;\n" +
				"    height: 100%;\n" +
				"    opacity: 0;\n" +
				"    animation: as 8s linear infinite;\n" +
				"}\n" +
				"\n" +
				".caps img {\n" +
				"    display: block;\n" +
				"    width: 100%;\n" +
				"    height: 100%;\n" +
				"}\n" +
				"\n" +
				"@keyframes as {\n" +
				"    0% {\n" +
				"        opacity: 0;\n" +
				"    }\n" +
				"    10% {\n" +
				"        opacity: .3;\n" +
				"    }\n" +
				"    20% {\n" +
				"        opacity: .1;\n" +
				"    }\n" +
				"    30% {\n" +
				"        opacity: .5;\n" +
				"    }\n" +
				"    40% {\n" +
				"        opacity: 0;\n" +
				"    }\n" +
				"    50% {\n" +
				"        opacity: .8;\n" +
				"    }\n" +
				"    55% {\n" +
				"        opacity: 0;\n" +
				"    }\n" +
				"    55% {\n" +
				"        opacity: 0;\n" +
				"    }\n" +
				"}\n" +
				"\n" +
				".frame {\n" +
				"    z-index: 3;\n" +
				"    position: absolute;\n" +
				"    left: 0;\n" +
				"    top: 0;\n" +
				"    width: 100%;\n" +
				"    height: 100%;\n" +
				"    background: -moz-radial-gradient(center, ellipse cover, rgba(0, 0, 0, 0) 0%, rgba(0, 0, 0, 0) 19%, rgba(0, 0, 0, 0.9) 100%); /* FF3.6+ */\n" +
				"    background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, rgba(0, 0, 0, 0)), color-stop(19%, rgba(0, 0, 0, 0)), color-stop(100%, rgba(0, 0, 0, 0.9))); /* Chrome,Safari4+ */\n" +
				"    background: -webkit-radial-gradient(center, ellipse cover, rgba(0, 0, 0, 0) 0%, rgba(0, 0, 0, 0) 19%, rgba(0, 0, 0, 0.9) 100%); /* Chrome10+,Safari5.1+ */\n" +
				"    background: -o-radial-gradient(center, ellipse cover, rgba(0, 0, 0, 0) 0%, rgba(0, 0, 0, 0) 19%, rgba(0, 0, 0, 0.9) 100%); /* Opera 12+ */\n" +
				"    background: -ms-radial-gradient(center, ellipse cover, rgba(0, 0, 0, 0) 0%, rgba(0, 0, 0, 0) 19%, rgba(0, 0, 0, 0.9) 100%); /* IE10+ */\n" +
				"    background: radial-gradient(ellipse at center, rgba(0, 0, 0, 0) 0%, rgba(0, 0, 0, 0) 19%, rgba(0, 0, 0, 0.9) 100%); /* W3C */\n" +
				"    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr = '#00000000', endColorstr = '#e6000000', GradientType = 1); /* IE6-9 fallback on horizontal gradient */\n" +
				"\n" +
				"}\n" +
				"\n" +
				".frame div {\n" +
				"    position: absolute;\n" +
				"    left: 0;\n" +
				"    top: -20%;\n" +
				"    width: 100%;\n" +
				"    height: 20%;\n" +
				"    background-color: rgba(0, 0, 0, .12);\n" +
				"    box-shadow: 0 0 10px rgba(0, 0, 0, .3);\n" +
				"    animation: asd 12s linear infinite;\n" +
				"}\n" +
				"\n" +
				".frame div:nth-child(1) {\n" +
				"    animation-delay: 0;\n" +
				"}\n" +
				"\n" +
				".frame div:nth-child(2) {\n" +
				"    animation-delay: 4s;\n" +
				"}\n" +
				"\n" +
				".frame div:nth-child(3) {\n" +
				"    animation-delay: 8s;\n" +
				"}\n" +
				"\n" +
				"@keyframes asd {\n" +
				"    0% {\n" +
				"        top: -20%;\n" +
				"    }\n" +
				"    100% {\n" +
				"        top: 100%;\n" +
				"    }\n" +
				"}\n" +
				"\n" +
				"h1 {\n" +
				"    z-index: 3;\n" +
				"    position: absolute;\n" +
				"    font: bold 200px/200px Arial, sans-serif;\n" +
				"    left: 50%;\n" +
				"    top: 50%;\n" +
				"    margin-top: -100px;\n" +
				"    width: 100%;\n" +
				"    margin-left: -50%;\n" +
				"    height: 200px;\n" +
				"    text-align: center;\n" +
				"    color: transparent;\n" +
				"    text-shadow: 0 0 30px rgba(0, 0, 0, .5);\n" +
				"    animation: asdd 2s linear infinite;\n" +
				"}\n" +
				"\n" +
				"@keyframes asdd {\n" +
				"    0% {\n" +
				"        text-shadow: 0 0 30px rgba(0, 0, 0, .5);\n" +
				"    }\n" +
				"    33% {\n" +
				"        text-shadow: 0 0 10px rgba(0, 0, 0, .4);\n" +
				"    }\n" +
				"    66% {\n" +
				"        text-shadow: 0 0 20px rgba(0, 0, 0, .2);\n" +
				"    }\n" +
				"    100% {\n" +
				"        text-shadow: 0 0 40px rgba(0, 0, 0, .8);\n" +
				"    }\n" +
				"}\n" +
				"    </style>\n" +
				"    <script>\n" +
				"        var Application = ( function () {\n" +
				"        var canvas;\n" +
				"        var ctx;\n" +
				"        var imgData;\n" +
				"        var pix;\n" +
				"        var WIDTH;\n" +
				"        var HEIGHT;\n" +
				"        var flickerInterval;\n" +
				"\n" +
				"        var init = function () {\n" +
				"            canvas = document.getElementById('canvas');\n" +
				"            ctx = canvas.getContext('2d');\n" +
				"            canvas.width = WIDTH = 700;\n" +
				"            canvas.height = HEIGHT = 500;\n" +
				"            ctx.fillStyle = 'white';\n" +
				"            ctx.fillRect(0, 0, WIDTH, HEIGHT);\n" +
				"            ctx.fill();\n" +
				"            imgData = ctx.getImageData(0, 0, WIDTH, HEIGHT);\n" +
				"            pix = imgData.data;\n" +
				"            flickerInterval = setInterval(flickering, 3);\n" +
				"        };\n" +
				"\n" +
				"        var flickering = function () {\n" +
				"            for (var i = 0; i < pix.length; i += 4) {\n" +
				"                var color = (Math.random() * 255) + 50;\n" +
				"                pix[i] = color;\n" +
				"                pix[i + 1] = color;\n" +
				"                pix[i + 2] = color;\n" +
				"            }\n" +
				"            ctx.putImageData(imgData, 0, 0);\n" +
				"        };\n" +
				"\n" +
				"        return {\n" +
				"            init: init\n" +
				"        };\n" +
				"    }());\n" +
				"\n" +
				"    Application.init();\n" +
				"    </script>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <h1>404\n" +
				"        <h5>Page Not F</h5>\n" +
				"    </h1>\n" +
				"\n" +
				"<div class=\"frame\">\n" +
				"    <div></div>\n" +
				"    <div></div>\n" +
				"    <div></div>\n" +
				"</div>\n" +
				"<div class=\"caps\"><img src=\"http://ademilter.com/caps.png\" alt=\"\"></div>\n" +
				"<canvas id=\"canvas\"></canvas>\n" +
				"\n" +
				"</body>\n" +
				"</html>";
	}

	//	@GetMapping("/retrofit/{id}")
//	public StudentEntity studentDetails(@PathVariable int id) throws IOException {
//		return retrofitService.allById(id);
//	}
	

}
