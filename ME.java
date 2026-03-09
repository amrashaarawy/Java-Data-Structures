/**
  * Extended map
  *
  * @see M
  * @author Amr Shaarawy
  * @version 13-12-2024
  */
public class ME <K extends Comparable, V extends Comparable> extends M <K, V>
{
   /**
      checks if there is a mapping with the specified key in this extended map
      @param k the specified key
      @return true if there is a mapping with the specified key in this map,
   */
   public boolean containsKey(K k)
    {
        return get(k) != null;
    }
    
   /**
      checks if there is a mapping with the specified value in this extended map
      @param k the specified value
      @return true if there is a mapping with the specified value in this map
   */
   public boolean containsValue(V val)
   {
      Object[] w = values();
      int n = linsearch(w, val);
	  
	  return n >= 0;
   }

   private int linsearch(Object[] a, Object t)
   {
      for (int i = 0; i < a.length; i++)
      {
         Comparable cur = (Comparable)a[i];
         if (cur.compareTo(t) == 0)
         {
            return i;
         }
      }
      return -1;
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
   @Override
   public V put(K k, V v) 
   { 
      return super.put(k, v); 
   }
   
   /**
      Returns a sorted array containing the values of this map without
      duplicated values
      @return sorted array containing the values of this map without
              duplicated values. The array is sorted in ascending order
              according to the natural order of the values.
   */
   public Comparable[] valueSet()
   {
       Object[] w = values();
       
       Map<V, String> m = new M();
       
	   for (int i = 0; i < w.length; i++)
       {
          m.put((V)w[i], ""); // mapping vlaue/emptyString
       }
      
       return m.keySet(); 	 
   }
}
