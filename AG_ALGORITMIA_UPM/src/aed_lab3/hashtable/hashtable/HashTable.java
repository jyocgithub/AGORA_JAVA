package aed_lab3.hashtable.hashtable;

import es.upm.aedlib.Entry;
import es.upm.aedlib.EntryImpl;
import es.upm.aedlib.InvalidKeyException;
import es.upm.aedlib.map.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * A hash table implementing using open addressing to handle key collisions.
 */
public class HashTable<K,V> implements Map<K,V> {
  Entry<K,V>[] buckets;
  int size;

  public HashTable(int initialSize) {
    this.buckets = createArray(initialSize);
    this.size = 0;
  }

  /**
   * Add here the method necessary to implement the Map api, and
   * any auxilliary methods you deem convient.
   */

  // Examples of auxilliary methods: IT IS NOT REQUIRED TO IMPLEMENT THEM
  
  @SuppressWarnings("unchecked") 
  private Entry<K,V>[] createArray(int size) {
   Entry<K,V>[] buckets = (Entry<K,V>[]) new Entry[size];
   return buckets;
  }

  // Returns the bucket index of an object
  private int index(Object obj) {
    int index = Math.abs(obj.hashCode()) % buckets.length;
    return index;
  }

  // Returns the index where an entry with the key is located,
  // or if no such entry exists, the "next" bucket with no entry,
  // or if all buckets stores an entry, -1 is returned.
  private int search(Object obj) {

    int index = index(obj);
//
//    if(size == buckets.length){
//      return -1;
//    }

    if(buckets[index] == null){
      return index;
    }


    if(buckets[index].getKey().equals(obj)){
       return index;
    }else{
      // mirar si existe en otro sitio
      for (int i = index; i < buckets.length ; i++) {
        if(buckets[i] == null){
          return i;
        }
        if(buckets[i].getKey().equals(obj)){
          return i;
        }
      }
      for (int i = 0; i < index ; i++) {
        if(buckets[i] == null){
          return i;
        }
        if(buckets[i].getKey().equals(obj)){
          return i;
        }
      }
      // no esta el elemento, buscamos un hueco vacio
      for (int i = index; i < buckets.length ; i++) {
        if(buckets[i] == null){
          return i;
        }
      }
      for (int i = 0; i < index ; i++) {
        if(buckets[i] == null){
          return i;
        }
      }

    }

    return -1;
  }

  // Doubles the size of the bucket array, and inserts all entries present
  // in the old bucket array into the new bucket array, in their correct
  // places. Remember that the index of an entry will likely change in
  // the new array, as the size of the array changes.
  private void rehash() {
    Entry[] newBuckets = createArray(buckets.length*2);
    Entry[] oldBuckets = buckets;
    buckets = newBuckets;

    for (int i = 0; i < oldBuckets.length; i++) {
       if( oldBuckets[i] != null) {
         put((K) oldBuckets[i].getKey(), (V) oldBuckets[i].getValue());
       }
    }
    size = size / 2;
  }

  @Override
  public int size() {
    int c = 0;
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size  == 0;
  }

  @Override
  public boolean containsKey(Object o) throws InvalidKeyException {
    if (size() == 0) return false;

    int position = search(o);
    if(position==-1){
      return false;
    }
    if(buckets[position] != null ){
      return true;
    }
    return false;
  }

  @Override
  public V put(K k, V v) throws InvalidKeyException {
    int position = search(k);
    if(position==-1){
      // no hay sitios lilbres....... ampliar
      rehash();

      put( k,  v);
 //     size++;
      return null;
    }
    if(buckets[position]==null){
      // aqui lo meto como elemento nuevo
      Entry<K,V> newitem = new  EntryImpl(k,v);

      buckets[position]= newitem;
      size++;
      return null;
    }
    else if(buckets[position].getKey().equals(k)){
      // aqui lo meto pero sustituyo lo que habia
      Entry<K,V> olditem = buckets[position];
      Entry<K,V> newitem = new  EntryImpl(k,v);
      buckets[position]= newitem;
      return olditem.getValue();
    }

    return null;
  }

  @Override
  public V get(K k) throws InvalidKeyException {

    int position = search(k);
    if( position == -1) {
      return null;
    }
    if(buckets[position] == null ) {
      return null;
    }

    return buckets[position].getValue();

  }

  @Override
  public V remove(K k) throws InvalidKeyException {
    // falta size -- o no
    return null;
  }
//
//  private Entry<K>[] createArray2(
//          int size
//  )


  @Override
  public Iterable<K> keys() {
   int pos = 0;
    List<K> newlist = new ArrayList<K>(size);
    for (int i = 0; i < buckets.length; i++) {

      if (buckets[i] != null) {
        newlist.add(buckets[i].getKey());
      }
    }
   return (Iterable<K>) newlist;
  }

  @Override
  public Iterable<Entry<K, V>> entries() {

      int pos = 0;
      Entry<K,V>[] newlist = createArray(size);
      for (int i = 0; i < buckets.length; i++) {

        if(buckets[i] != null){
          newlist[pos++] = buckets[i];
        }
      }

    Iterable<Entry<K, V>> mm = (Iterable<Entry<K, V>>) Arrays.asList(newlist);
    return mm;
  }

  @Override
  public Iterator<Entry<K, V>> iterator() {
    return null;
  }

  public static void main(String[] args) {
    HashTable<Integer,String> m = new HashTable<Integer,String>(2);
    m.put(2,"A");
    m.put(8,"Marti");
    m.put(0,"Marti");
    m.put(7,"rrrr");
    m.put(2,"B");
    m.put(2,"C");
    m.containsKey(5);
  }
}

