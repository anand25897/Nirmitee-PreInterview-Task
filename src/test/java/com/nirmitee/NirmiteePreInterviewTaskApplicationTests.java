package com.nirmitee;

import com.nirmitee.entity.Car;
import com.nirmitee.entity.Details;
import com.nirmitee.entity.Location;
import com.nirmitee.entity.Manufacturer;
import com.nirmitee.repository.CarRepository;
import com.nirmitee.service.impl.CarServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class NirmiteePreInterviewTaskApplicationTests {

	@Autowired
	private CarServiceImpl carServiceImpl;

	@MockBean
	private CarRepository carRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getCarTest(){
		when(carRepository.findAll()).thenReturn(Stream.of(
				new Car(1011L,"Used",
						new Details(1011L,"Large", "Zedan 25X", 4, "Gasoline", "3.6L V6", 2020, 2020, "white",
								new Manufacturer(1011L,102, "Fiat")),
									new Location(1011L,45.3522, -72.935242 )))
						.collect(Collectors.toList()));
		assertEquals("GetCar Method Testing ",1, carServiceImpl.getAllCars().size());
	}
}
