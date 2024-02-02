package WeatherApp.controller;

//import WeatherApp.Pojo;
import WeatherApp.Main;
import WeatherApp.WeatherappApplication;
import WeatherApp.service.PojoClaass;
import WeatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    public WeatherService service ;

    @GetMapping("/getWeather/{city}")
    public Main getWeather(@PathVariable String city){
     return  service.getWether(city);
    }

    @PostMapping("/post")
    public Main get(@RequestBody PojoClaass city){
        System.out.println(city);
      return  service.getDetails(city);
    }
}
