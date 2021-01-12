package com.tts.weatherapp;

import java.util.List;

//import com.tts.weatherapp.ZipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;

	@Autowired
	private ZipRepository zipRepository;

	public Response getForecast(String zipCode) {
		ZipCodes zipSave = new ZipCodes();
		zipSave.setZip(zipCode);
		Response response;

		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid="
				+ apiKey;
		RestTemplate restTemplate = new RestTemplate();
		try {
			response = restTemplate.getForObject(url, Response.class);
			zipRepository.save(zipSave);
		} catch (HttpClientErrorException ex) {
			response = new Response();
			response.setName("error");
		}
		return response;
	}

	public List<ZipCodes> getZips() {
		// System.out.println(zipRepository.findTop10ByOrderByDateDesc().toString());
		return zipRepository.findTop10ByOrderByDateDesc();
	}

}
