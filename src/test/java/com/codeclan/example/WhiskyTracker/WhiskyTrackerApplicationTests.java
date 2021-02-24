package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskiesFrom2011() {
		List<Whisky> found = whiskyRepository.findByYear(2011);
		assertEquals(1, found.size());
	}
	@Test
	public void canFindDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Island");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindWhiskyByDistilleryAndYear() {
		Distillery foundDistillery = distilleryRepository.getOne(1L);
		List<Whisky> found = whiskyRepository.findByDistilleryAndAge(foundDistillery, 15);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

}
