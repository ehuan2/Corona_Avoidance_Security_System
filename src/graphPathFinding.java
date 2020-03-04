
class pointLocation {
 
  int x,y;
  pointLocation parent;
  
  public pointLocation(){
    x = -1;
    y = -1;
    parent = null;
  }
  
  public pointLocation(int x, int y){
    this.x = x;
    this.y = y;
  }
  
  public void setParent(pointLocation par){
    this.parent = par;
  }
  
  public boolean equals(Object T){
   
    if(T instanceof pointLocation){
      pointLocation a = (pointLocation)T;
      return a.x == this.x && a.y == this.y;
    }
    
    return false;
    
  }
  
  public int hashCode(){
    
    return this.x + this.y;
    
  }
  
}

public class graphPathFinding {

  static int[] retracePath;
  static HashMap<String, Boolean> flagMap;
  
  public static pointLocation[] findPath(int xLocation, int yLocation, int xDest, int yDest, int[]xValues, int[]yValues, int[]radius){ // BFS for path
  
    Queue<Integer> qX = new LinkedList<>(); // queues needed, each for x coordinate and y coordinate
    Queue<Integer> qY = new LinkedList<>();
    
    qX.add(xLocation); // adds starting ones
    qY.add(yLocation);
    
    flagMap = new HashMap<>(); // flags the ones down
    
    while(!qX.isEmpty() && !qY.isEmpty()){
      
      int xNext = qX.poll();
      int yNext = qY.poll();
      
      if(xNext == xDest && yNext == yDest){
         
        return;
      }
      
      
      
    }
    
  
  }
 
 
 
  


}
