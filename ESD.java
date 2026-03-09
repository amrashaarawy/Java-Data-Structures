/**
  * Implements an extended SortedMultimap
  *
  * @param K parametric type limited to Comparable for the key 
  * @param V parametric type limited to Comparable for the value
  *
  * @author Amr Shaarawy
  * @version 18-12-2024	
  *
  */
public class ESD<K extends Comparable,V extends Comparable> extends D<K,V>
{      
   /**
     * checks if there is at least a mapping for the key in this multimap
     * @param key the key specified
     * @return true if this multimap contains a mapping with the specified key,
     *         otherwise false
     */
	 
	 public ESD()
	 {
	    super();	 
	 }
	 
   public boolean contains(K key)
   {
      return findAll(key).length > 0;
   }
 
   /**
     * retrieves the unique keys in this map
     * @return  a sorted array containing the keys in this multimap
     */
   public Comparable[] keySet()
   {
      Comparable[] k = keys();  //keys are sorted 
	  Comparable[] r = new Comparable[k.length];
	  
	  r[0] = k[0];
	  int ir = 1;
	  
	  for(int i = 1; i < k.length; i++)
	  {
		  if(k[i].compareTo(r[ir - 1]) != 0)
		  {
			  r[ir++] = k[i];
		  }
	  }
	  
      Comparable[] ret = new Comparable[ir];
      System.arraycopy(r, 0, ret, 0, ret.length);
            
      return ret;
   } 
   
   /**
     * Retrieves the sorted non-duplicated value in this multimap
     * @return un array ordinato contenente i valori univoci di questa
     * multimappa
     */
   public Comparable[] valueSet()
   {
      ESD<V, String> m = new ESD();
	  
	  Comparable[] k = keySet();  //unique keys	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
   }    
}
