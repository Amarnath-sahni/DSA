class RandomizedSet {
    HashSet<Integer> set;
    Random random;

    public RandomizedSet() {
       set = new HashSet<>();
        random = new Random(); 
        
    }
    
    public boolean insert(int val) {
         if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int index = random.nextInt(set.size());

        int i = 0;
        for (int num : set) {
            if (i == index) {
                return num;
            }
            i++;
        }

        return -1; // never reached if set is not empty
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */