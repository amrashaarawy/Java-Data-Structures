/**
  * Implements the Map abstract data type
  *
  * @param K the key parametric type
  * @param V the value parametric type
  *
  * @author Amr Shaarawy
  * @version 13-12-2024
  */
public class M<K extends Comparable, V> implements Map<K, V>
{
   //constant 
   private static final int INITIAL_CAPACITY = 1;
   
   //priv onstances 
   private Object[] v;
   private int vSize;
   
   //inner class entry
   private class Entry
   {
	   //priv instances 
	   private K key;
	   private V value;
	   
	   public Entry(K akey, V aval)
	   {
		   setKey(akey);
		   setVal(aval);
	   }
	   public K getKey() { return key; }
	   public V getVal() { return value; }
	   public void setKey(K akey) { key = akey; }
	   public void setVal(V aval) { value = aval; }
   }
  
   //constructor
   public M()
   {
	   v = new Object[INITIAL_CAPACITY];
       vSize = 0;   
   } 
   /**
      Returns the value to which the specified key is mapped 
      @param key the specified key
      @return the value to which the specified key is mapped, or null if this
              map contains no mapping for the key
      COMPLEXITY O(logn)
	  */ 
   public V get(K key)
   {
	   int pos = search(key);
	   
	   if(pos < 0)
		   return null;
	   
	   Entry e = (Entry)v[pos];
	   V ret = e.getVal();
	   
	   return ret;
   }
   
   //binary search               O(logn)
   private int search(K k)
   {
	   int from = 0;
	   int to = vSize - 1;
	   
	   while(from <= to)
	   {
		   int mid = (from + to)/2;
		   Entry e = (Entry)v[mid];
		   if( e.getKey().compareTo(k) == 0 ) 
		   {
			   return mid;
		   }
		   if(e.getKey().compareTo(k)<0)
		   {
			   from = mid + 1;			   
		   }			   
		   else 
		   {
			   to = mid - 1;
		   }
	   }
	   
	   return -1;
   }
   
   /**
      Returns true if this map contains no key-value mappings
      @return true if this map is empty
   */
   public boolean isEmpty()
   {
	   return vSize <= 0;
   }
   
   /**
      Returns an array containing the keys of the key/value mappings of this map
      The array is sorted in ascending order according to the natural order of
      the keys
      @return a sorted array containing the keys of the key/value mappings of
              this map, otherwise an empty array if this map is empty
   */
   public Comparable[] keySet()
   {
	   Comparable[] r = new Comparable[vSize];
	   
       for(int i = 0; i < vSize; i++)
	   {
		   Entry e = (Entry)v[i];
		   r[i] = e.getKey();
	   }		   
	   return r;
   }   

   /**
      Associates the specified value with the specified key in this map. If this
      map previously contained a mapping for the key, the old value is replaced
      by the specified value
      @param key with which the specified value is to be associated
      @param value value to be associated with the specified key
      @return the previous value associated with key, or null if there was no
              mapping for key.
      @throws IllegalArgumentException if the specified key or value is null
   */
   public V put(K key, V value)
   {
	   if (key == null || value == null) throw new IllegalArgumentException();
	   
	   int n = search(key);
	   if(n >= 0)
	   {
		   Entry e = (Entry)v[n];
		   V old = e.getVal();
		   
		   v[n] = new Entry(key, value);
		   return old;
	   }
	   
	   //key not found 
	   //dynamic array 
	   if(vSize >= v.length)
	   {
		   Object[] newv = new Object[v.length*2];
		   System.arraycopy(v, 0, newv, 0, v.length);
		   v = newv;
	   }
	   
	   //insertion (inner loop of insertion sort)
       int j = vSize - 1;
	   while(j >= 0 && key.compareTo(((Entry)v[j]).getKey()) < 0)
	   {
		   v[j+1] = v[j];
		   j--;
	   }
       
	   v[j+1] = new Entry(key, value);
	   vSize ++;
	   
	   return null;
   }
   
   /**
      Removes the mapping for the specified key from this map
      @param key the specified key of the mapping to be removed
      @return the previous value associated with key, or null if there was no
              mapping for key.
   */
   public V remove(K k)
   {
	   int n = search(k);
	   
	   if(n < 0)
	   {
		   return null;
	   }
	   
	   Entry e = (Entry)v[n];
	   V val = e.getVal();
	   
	   for(int i = n; i < vSize - 1; i++)
	   {
		   v[i] = v[i + 1];
	   }
	   
	   v[vSize - 1] = null;
	   vSize--;
	   return val; 
   }
   
   /**
      Returns the number of key-value mappings in this map
      @return the number of key-value mappings in this map
   */
   public int size()
   {
	   return vSize;
   }
   
   /**
      Returns an array view of the values contained in this map
      @return an array containing the values of this map or an empty array if
              this map is empty
   */ 
   public Object[] values()
   {
	   Object[] ret = new Object[vSize];
       
	   for(int i = 0; i < vSize; i++)
	   {
		   Entry e = (Entry)v[i];
		   ret[i] = e.getVal();
	   }

	   return ret;
   }   
}
