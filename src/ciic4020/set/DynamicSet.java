package ciic4020.set;

import java.util.Iterator;

import ciic4020.bag.Bag;

public class DynamicSet<E> implements Set<E> {

	// static set
	private StaticSet<E> theSet;
	
	// current max capacity
	private int maxCapacity;

	private static final int DEFAULT_SET_SIZE = 10;

	public DynamicSet(int initialCapacity) {
		this.theSet = new StaticSet<E>(initialCapacity);
		this.maxCapacity = initialCapacity;
	}
	@Override
	public Iterator<E> iterator() {
		return theSet.iterator();
	}

	@Override
	public boolean add(E obj) {
		if (this.isMember(obj)) // Avoid extending the set unnecessarily
			return false;
		if (this.maxCapacity == this.theSet.size())
		{
			this.maxCapacity *= 2;
			StaticSet<E> newSet = new StaticSet<E>(this.maxCapacity);
			copySet(theSet, newSet);
			this.theSet = newSet;
		}
		return this.theSet.add(obj);
	}

	private void copySet(Set<E> src, Set<E> dst) {
		for (Object obj : src)
			dst.add((E) obj);
	}

	@Override
	public boolean isMember(E obj) {
		return this.theSet.isMember(obj);
	}

	@Override
	public boolean remove(E obj) {
		return this.theSet.remove(obj);
	}

	@Override
	public boolean isEmpty() {
		return this.theSet.isEmpty();
	}

	@Override
	public int size() {
		return this.theSet.size();
	}

	@Override
	public void clear() {
		this.theSet.clear();
	}

	@Override
	public Set<E> union(Set<E> S2) {
		Set<E> temp = this.theSet.union(S2);
		DynamicSet<E> result = new DynamicSet<E>(DEFAULT_SET_SIZE);
		copySet(temp, result);
		return result;
	}

	@Override
	public Set<E> difference(Set<E> S2) {
		Set<E> temp = this.theSet.difference(S2);
		DynamicSet<E> result = new DynamicSet<E>(DEFAULT_SET_SIZE);
		copySet(temp, result);
		return result;
	}

	@Override
	public Set<E> intersection(Set<E> S2) {
		Set<E> temp = this.theSet.intersection(S2);
		DynamicSet<E> result = new DynamicSet<E>(DEFAULT_SET_SIZE);
		copySet(temp, result);
		return result;
	}

	@Override
	public boolean isSubSet(Set<E> S2) {
		return this.theSet.isSubSet(S2);
	}
	
	@Override
	public boolean equals(Set<E> S2) {
		return this.theSet.equals(S2);
	}
	
	@Override
	public Set<Set<E>> singletonSets() {
		return this.theSet.singletonSets();
	}
	
	public static boolean checkDisjoint(Object[] sets) {
		
		/* O(n^2) solution
		Set<Integer> temp = new DynamicSet<Integer>(sets.length);
		
		//nested for loop, with inner loop 1 index ahead than outer to check every possible set
		for(int i=0; i<sets.length; i++) {
			for(int j=i+1; j<sets.length; j++) {
				
				//find the intersection between set1 and set2, and so on...
				temp = ((Set<Integer>) sets[i]).intersection(((Set<Integer>) sets[j]));
				
				//if the intersection of the set[i] and set[j] is not empty, then it is not disjoint
				if(temp.isEmpty())
					return true;
				
			}
		}
		
		return false;
		*/
		
		// O(n) solution
		Set<Integer> temp = (Set<Integer>)sets[0];
		
		//loops through the arrays, storing the common elements in temp through intersection method
		for(int i=0; i<sets.length; i++) {
			temp = temp.intersection((Set<Integer>)sets[i]);
		}
		
		//if temp is empty, then there is at least 1 disjoint set
		return temp.isEmpty();

	}
	
}