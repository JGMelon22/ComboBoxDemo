package repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class FakeDataRepository {

	public List<String> fakeData() {
		List<String> cars = new ArrayList<String>();
		cars.add("BMW");
		cars.add("Camaro");
		cars.add("Mustang");
		cars.add("Golf");
		cars.add("Eclipse");

		cars.sort(Comparator.naturalOrder());

		return cars;
	}

	public List<String> fakeDataReverse() {
		List<String> cars = new ArrayList<String>();
		cars.add("BMW");
		cars.add("Camaro");
		cars.add("Mustang");
		cars.add("Golf");
		cars.add("Eclipse");

		cars.sort(Comparator.reverseOrder());

		return cars;
	}
	
	public HashSet<String> fakeDataUnordered() {
		HashSet<String> cars = new HashSet<String>();
		cars.add("BMW");
		cars.add("Camaro");
		cars.add("Mustang");
		cars.add("Golf");
		cars.add("Eclipse");
		
		return cars;
	}
}
