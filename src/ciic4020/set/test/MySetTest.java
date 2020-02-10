package ciic4020.set.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ciic4020.set.DynamicSet;
import ciic4020.set.Set;
import ciic4020.set.StaticSet;

public class MySetTest {

	@Test
	public void test() {
		
		Set<String> mySet1 = new StaticSet<String>(10);
		Set<String> mySet2 = new StaticSet<String>(10);

		mySet1.add("Amy");
		mySet1.add("Jil");
		mySet1.add("Moe");
		mySet1.add("Ned");
		
		mySet2.add("Amy");
		mySet2.add("Jil");
		mySet2.add("Moe");
		mySet2.add("Ned");
		
		assertTrue(mySet2.equals(mySet1));
		
		mySet1.add("Bob");
		
		assertFalse(mySet1.equals(mySet2));
		
		mySet2.add("Bob");
		assertTrue(mySet2.equals(mySet1));
		
		mySet2.add("Apu");
		assertFalse(mySet2.equals(mySet1));
		
	}

}
