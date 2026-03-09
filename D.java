/**
  * Implements a sorted multimap
  * 
  * @author Amr Shaarawy 
  * @version 18-12-2024
*/
public class D<K extends Comparable,V> implements SortedMultimap<K,V>
{
	//constants 
	private static final int INITIAL_CAPACITY = 1;
	
	//priv instances
	private Object[] v;
	private int vSize;
	
	//entry inner class 
	private class Entry
	{
		 //priv instances 
		 private K key;
		 private V val;

         //constructor		
	     public Entry(K akey, V aval)
		 {
			 setKey(akey);
			 setVal(aval);
		 }		 
		 
		 public K getKey() { return key; }
		 public V getVal() { return val; }
		 public void setKey(K akey) { key = akey; }
		 public void setVal(V aval) { val = aval; } 
	}
	
	//constructor
	public D()
	{
		makeEmpty();
	}
	
	public void makeEmpty()
	{
		v = new Object[INITIAL_CAPACITY];
		vSize = 0;
	}
	
	public int size()
	{
		return vSize;
	}
	
	public boolean isEmpty()
	{
		return vSize <= 0;
	}
	
	public Object[] findAll(K akey)
	{
		if (akey == null)          // the null key cannot be a key in the multimap
        {                         // see preconditions in the insert method
            return new Object[0];
        }
	  
		Object[] r = new Object[vSize];
		int ir = 0;
		
		for(int i = 0; i < vSize; i++)
		{
			Entry e = (Entry)v[i];
			if(e.getKey().compareTo(akey) == 0)
			{
				r[ir++] = e.getVal();
			}
		}
		
		Object[] ret = new Object[ir];
		System.arraycopy(r, 0, ret, 0, ir);
		
		return ret;	
	}
	
	public void insert(K akey, V aval) throws IllegalArgumentException
	{
		if( akey == null || aval == null)
        {
			throw new IllegalArgumentException();
		}
		
		//dynamic resize 
		if(vSize >= v.length)
		{
			Object[] newv = new Object[v.length*2];
			System.arraycopy(v, 0, newv, 0, vSize);
		    v = newv;
		}
		
		v[vSize++] = new Entry(akey, aval);
	}
	
	public Comparable[] keys()   //sorted 
	{
		if(vSize <= 0)
		{
			return new Comparable[0];
		}
		Comparable[] r = new Comparable[vSize];
		
		for(int i = 0; i < r.length; i++)
		{
			Entry e = (Entry)v[i];
			r[i] = e.getKey();
		}
		
		sort(r);
		return r;
	}
	
	private static void sort(Comparable[] a)   //merge sort 
	{
		// base case
        if (a.length < 2)
            return;
	
        int mid = a.length/2;
		
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[a.length - mid];
		
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);
		
		sort(left);
		sort(right);
		
		merge(a, left, right);		
	}
	
	private static void merge(Comparable[] a, Comparable[] b, Comparable[] c)
	{
		int ia = 0, ib = 0, ic = 0;
		
		while(ib < b.length && ic < c.length)
		{
			if(b[ib].compareTo(c[ic]) < 0)
				a[ia++] = b[ib++];
			else 
				a[ia++] = c[ic++];
		}
		
		while(ib < b.length)
		{
			a[ia++] = b[ib++];
		}
		while(ic < c.length)
		{
			a[ia++] = c[ic++];
		}
		
	}
	
	public Object[] removeAll(K akey)
	{
		Object[] r = findAll(akey);
		
		while(remove(akey) != null)
		{
			;
		}
		
		return r;
	}
	
	private V remove(K akey)
	{
		 // linear search
      for (int i = 0; i < vSize; i++)  // attention: use vSize. Don't use v.length!
      {
         Entry e = (Entry)v[i];   // current mapping - type cast is needed
         if (e.getKey().compareTo(akey) == 0)
         {
            // temporarily store old value
            V oldValue = e.getVal();
            
            // remove mapping
            v[i] = v[vSize - 1];   // sequence is not important!
            v[vSize - 1] = null;   // clears the replicated value
            vSize--;               // updates mapping counter
            
            return oldValue; 
         }
      }
      
	  // there is no mapping for the specified key
      return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
