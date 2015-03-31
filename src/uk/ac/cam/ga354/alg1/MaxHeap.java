package uk.ac.cam.ga354.alg1;

public class MaxHeap
{
  private char heapName;
  private char [] heap;
  private int heapsize; //current size of the heap at full capacity
  private int filled; //contains how many elements are in the heap already - for resizing issues and points to the last item inserted
  
  private boolean isFull(){ //returns true if no item can be inserted into the array without making it full.
	  if (heapsize-1 == filled) return true;
	  else return false;
  }
  
  MaxHeap(char name)
  {
   heap = new char[2];
   heapsize = 2;
   filled = 0;
  }

  MaxHeap(char name, String str)
  {
	 char[] unheaped = str.toCharArray();
	 heap = new char[2];
	   heapsize = 2;
	   filled = 0;
	 for (int i = 0; i<unheaped.length; i++){
		 insert(unheaped[i]);
	 }
  }

  void insert(char x)
  {
	 if (isFull()){
		 char[] newHeap = new char[2*heapsize]; //if the array is full then create a new one of double the size;
		 for (int i = 0; i<heapsize; i++){
			 newHeap[i] = heap[i]; //put everything in the old heap into the new one O(n)
		 }
		 heap = newHeap; //reassign heap
		 heapsize = heapsize*2;
		 ins(x);
		 filled++;
		 
		 
	 } else {
		 
		 ins(x);
		 filled++;
	 }
  }
  
  void swap (int i, int j){
	  char swap = heap[i];
	  heap[i] = heap[j];
	  heap[j] = swap;
  }
  
  void ins(char x){
	  int index = filled;
	  heap[index] = x;
	  while(index != 0 && heap[index]>heap[(index+1)/2 -1]){ //while parent is smaller than current element being bubbled swap them
		  swap(index, (index+1)/2 -1 );
		  index = (index+1)/2 -1;
	  }
	  
	  
	  
  }
  
  
  public char getMax(){
	  char rtn = heap[0];
	  heap[0] = heap[filled-1];
	  filled--;
	  int index = 0;
	  while(((index+1)*2<=filled)&&(heap[index] <= heap[(index+1)*2-1]||heap[index] < heap[(index+1)*2])){ //while node is smaller than its two children
		  if(heap[(index+1)*2-1]>heap[(index+1)*2]){ //if left child bigger than right then swap with left
			  swap((index+1)*2-1, index);
			  index = (index+1)*2-1;
		  } else{
			  swap((index+1)*2, index); //else swap with right
			  index = (index+1)*2;
		  }
	  }  
	  return rtn;
  }
  
  
  public static void main(String[] args)
  {
      char c;
      MaxHeap h = new MaxHeap('h', "BEWILDERMENT");
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      System.out.println(h.getMax());
      
  }
}
