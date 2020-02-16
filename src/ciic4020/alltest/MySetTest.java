package ciic4020.alltest;

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
		
//		Set<Set<String>> singletonSet = new StaticSet<Set<String>>(10);
//		
//		Set<String> temp1 = new StaticSet<String>(1);
//		temp1.add("Amy");
//		Set<String> temp2 = new StaticSet<String>(1);
//		temp2.add("Jil");
//		Set<String> temp3 = new StaticSet<String>(1);
//		temp3.add("Moe");
//		Set<String> temp4 = new StaticSet<String>(1);
//		temp4.add("Ned");
//		
//		singletonSet.add(temp1);
//		singletonSet.add(temp2);
//		singletonSet.add(temp3);
//		singletonSet.add(temp4);
//		
//		assertTrue(mySet1.singletonSets().equals(singletonSet));
		
	}

}
