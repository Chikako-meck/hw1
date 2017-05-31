import java.util.*;

public class Combination implements Enumeration<int[]>{
    private int N, K, numComb;
    private BitSet X;
    private int[] indices;
    private int[][] results;

    public Combination(int n, int k){
	this.indices = indices;
	N = n;
	K = k;
	indices = new int[n];
	for (int i = 0; i < n; ++i){
	    indices[i] = i;
	}
	X = new BitSet(N + 1);
	for (int i = 0; i < k; ++i){
	    X.set(i);
	}
	results = getIndexCombinations();
    }
    
    public int getNumComb(){ //number of generated combinations
	return numComb;
    }
    
    public int[][] getResults(){ //return combinations as array of indices set
	return results;
    }

    public int[][] getIndexCombinations(){
	int[][] result;
	int[] cmb; //each combination
	ArrayList<IntArray> combis;
	
	//ArrayList of IntArray is nothing but an array of array
	combis = new ArrayList<IntArray>();
	
	int count = 0;
	while(hasMoreElements()) {
	    cmb = nextElement();
	    Arrays.sort(cmb);
	    combis.add(new IntArray(cmb));
	    count++;
	}
	numComb = count;
	
	Collections.sort(combis);
	
	result = new int[numComb][]; //List of array -> array of array conversion
	count = 0;
	for (IntArray a: combis){
	    result[count++] = a.iarray;
	}
	return result;
    }
    
    public boolean hasMoreElements() {
	return ! X.get(N);
    }
    
    private int findOne(BitSet bs) {
	int len = bs.size();
	for(int i = 0; i <= N; ++i) {
	    if (bs.get(i)){
		return i;
	    }
	}
	return -1;
    }
    
    private int incr(BitSet bs, int n) {
	int a = 0;
	for(;;) {
	    if (bs.get(n)){
		bs.clear(n); n++; a++;
	    }
	    else{
		bs.set(n); break;
	    }
	}
	return a;
    }
    
    public int[] nextElement() {
	int k = 0;
	int[] combi = new int[K];
	
	for (int i = 0; i <= N; i++){
	    if(X.get(i)){
		combi[k++] = indices[i];
	    }
	}
	int u = incr(X, findOne(X)) - 1;
	for(int i = 0; i < u; ++i){
	    X.set(i);
	}
	return combi;
    }
    
    // main() for test
    public static void main(String[] args) {
	int[][] combinations;
	int[] cmb;
	int n, k;
	
	if (args.length < 2){// 4 from 10
	    n = 10;
	    k = 4;
	}
	else{
	    n = Integer.parseInt(args[0]);
	    k = Integer.parseInt(args[1]);
	}
	
	System.out.println("N=" + n);
	System.out.println("K=" + k);
	
	Combination icmb = new Combination(n, k);
	combinations = icmb.getResults();
	
	for (int i = 0; i < combinations.length; ++i){
	    cmb = combinations[i];
	    print(cmb);
	}
	System.out.println("count = " + icmb.getNumComb());
    }
    
    static void print(int[] ar){ //this method was used for debugging
	for (int i = 0; i < ar.length; ++i){
	    System.out.print(ar[i] + " ");
	}
	System.out.println();
    }
}

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
