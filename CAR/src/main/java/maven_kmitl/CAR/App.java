package maven_kmitl.CAR;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {
	Car car = new Car();
	ArrayList<Car> cars = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
                                                                             
	@RequestMapping(value="/car",method=RequestMethod.POST)
	public ResponseEntity<ArrayList<Car>>create(@RequestBody ArrayList<Car> cars) {
		cars.stream().forEach((c) -> this.cars.add(c));
//		cars.add(car);
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
	@RequestMapping(value="/car/{id}",method=RequestMethod.GET)
	public ResponseEntity<Car> get(@PathVariable("id") int id) {
		return new ResponseEntity<Car>(cars.get(id-1), HttpStatus.OK);
	}
	@RequestMapping(value="/car/{id}",method=RequestMethod.PATCH)
	public ResponseEntity<ArrayList<Car>> update(@PathVariable("id") int id, @RequestBody Car car) {
		cars.set(id-1, car);
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
	@RequestMapping(value="/car/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<ArrayList<Car>> delete(@PathVariable("id") int id) {
		cars.remove(id-1);
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
	@RequestMapping(value="/car",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Car>>get(@RequestBody Car car) {
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
}