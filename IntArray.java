class IntArray implements Comparable<IntArray>{
    public int[] iarray;
    public int length;
    
    public IntArray(int[] a){
	iarray = a;
	length = iarray.length;
    }
    
    public int compareTo(IntArray other){ //for sorting
	int diff = 0;
	for (int i = 0; i < length && i < other.length; ++i){
	    diff = iarray[i] - other.iarray[i];
	    if (diff != 0){
		break;
	    }
	}
	if (diff == 0 && length != other.length){
	    diff = length > other.length ? 1 : -1;
	}
	return diff;
    }
    
    public String toString(){
	String s = "";
	for (int n: iarray){
	    s += n + " ";
	}
	return s;
    }
}
