package com.assessment.Controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.Model.LohemResponse;

@RestController
@RequestMapping
public class LohemController {

	public static String res = "";

	@GetMapping("/price")
	public LohemResponse<String> getprice() {

		LohemResponse<String> response = new LohemResponse<>();
		try {
			Document dc = Jsoup.connect("https://www.metal.com/Lithium-ion-Battery/202303240001").get();
			Elements elements = dc.select("div.wrap___PUo5o");
			for (Element element : elements.select("div")) {
				String t = element.select("div.block___2RfAT span").text();
				if (t.equals("Avg.: 0.12 -0.01 (-4.62%) Price Range: 0.12 -0.12")) {
					res = res + t;
					break;
				}
			}
			String[] var = res.split(" ");
			response.setStatus(HttpStatus.FOUND.value());
			response.setMessage("Data Founded");
			response.setData(var[1]);
			return response;
		} catch (IOException e) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("Not Found the Data");
			response.setData("Invalid calls");
			return response;
		}

	}

}
