class RandomizedSet {
    List<Integer>list;
    HashMap<Integer, Integer>map;
    Random random;

    public RandomizedSet() {
       map = new HashMap<>();
       list = new ArrayList<>(); 
        random = new Random();
    }
    
    public boolean insert(int val) {
         if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        // Index of the element to remove
        int index = map.get(val);

        // Last element in the list
        int lastElement = list.get(list.size() - 1);

        // Move the last element to the removed element's position
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element
        list.remove(list.size() - 1);

        // Remove the value from the map
        map.remove(val);

        return true;
        
    }
    
    public int getRandom() {
        int index = random.nextInt(list.size());
        

        return list.get(index); // never reached if set is not empty
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */