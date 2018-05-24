import java.util.ArrayList;

public class HashTable<K, V> {
	
	static class HashNode<K, V> {
		K key;
		V value;
		HashNode<K, V> next;
		HashNode(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	private ArrayList<HashNode<K, V>> bucketArray;
	private int numBuckets;
	private int size;
	
	public HashTable() {
		bucketArray = new ArrayList<HashNode<K, V>>();
		numBuckets = 16;
		size = 0;
		for(int i=0; i< numBuckets; i++)
			bucketArray.add(null);
	}
	
	public int size() {
        return size;
    }
	
	public V put(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> node = bucketArray.get(bucketIndex);
		while(node != null) {
			if(node.key.equals(key)) {
				V oldValue = node.value;
				node.value = value;
				return oldValue;
			}
			node = node.next;
			node.value = value;
			return null;
		}
		size++;
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = node;
		bucketArray.set(bucketIndex, newNode);
		
		if(size / numBuckets >= 0.7) {
			numBuckets = 2 * numBuckets;
			
			ArrayList<HashNode<K, V>> temp = bucketArray;
			bucketArray = new ArrayList<>();
			size = 0;
			for(int i=0; i<numBuckets; i++) {
				bucketArray.add(null);
			}
			for (HashNode<K, V> headNode : temp)
            {
                while (headNode != null)
                {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
		}
		
		return null;
	}
	
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> node = bucketArray.get(bucketIndex);
		while(node != null) {
			if(node.key.equals(key)) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}
	
	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> node = bucketArray.get(bucketIndex);
		HashNode<K, V> prev = null;
		while(node != null) {
			if(node.key.equals(key)) {
				break;
			}
			prev = node;
			node = node.next;
		}
		if(node == null) {
			return null;
		}
		size--;
		if(prev != null)
			prev.next = node.next;
		else
			bucketArray.set(bucketIndex, node.next);
		return node.value;
	}
	
	public boolean isEmpty() {
        return size == 0;
    }
	
	private int getBucketIndex(K key) {
		return (key.hashCode() % numBuckets);
		
	}
}
