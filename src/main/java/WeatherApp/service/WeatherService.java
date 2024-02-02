package WeatherApp.service;

//import WeatherApp.Pojo;
import WeatherApp.Main;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

     @Autowired
     public Main main ;

    @Autowired
    public RestTemplate restTemplate;

    public Main getWether(String city) {

      String apikey = "6dd4faaa921670cbc86bb13da963a0ac" ;
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apikey;
//         return restTemplate.getForObject(url , Main.class) ;

        try{
            JsonNode  node = restTemplate.getForObject(url , JsonNode.class) ;
            System.out.println(node);
            Double temp = node.path("main").path("temp").asDouble() ;
            int humidity = node.path("main").path("temp").asInt() ;
            int cloud = node.path("main").path("all").intValue() ;
            int pressure = node.path("main").path("pressure").asInt() ;
            String name = node.path("name").asText() ;

            main.setCloud(cloud);
            main.setHumidity(humidity);
            main.setName(name);
            main.setTemp(temp);
            main.setPressure(pressure);


            return main ;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null ;
        }


    }

    public Main getDetails(PojoClaass city) {
        String n = city.getCityName();
        String apikey = "6dd4faaa921670cbc86bb13da963a0ac" ;
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + n + "&appid=" + apikey;
//         return restTemplate.getForObject(url , Main.class) ;

        try{
            JsonNode  node = restTemplate.getForObject(url , JsonNode.class) ;
            System.out.println(node);
            Double temp = node.path("main").path("temp").asDouble() ;
            int humidity = node.path("main").path("temp").asInt() ;
            int cloud = node.path("main").path("all").intValue() ;
            int pressure = node.path("main").path("pressure").asInt() ;
            String name = node.path("name").asText() ;

            main.setCloud(cloud);
            main.setHumidity(humidity);
            main.setName(name);
            main.setTemp(temp);
            main.setPressure(pressure);

            System.out.println(main);
            return main ;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null ;
        }



    }
}
