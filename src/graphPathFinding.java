
public class graphPathFinding {

  static int[] retracePath;
  static HashMap<String, Boolean> flagMap;
  
  public static void findPath(int xLocation, int yLocation, int xDest, int yDest, int[]xValues, int[]yValues, int[]radius){ // BFS for path
  
    Queue<Integer> qX = new LinkedList<>(); // queues needed, each for x coordinate and y coordinate
    Queue<Integer> qY = new LinkedList<>();
    
    qX.add(xLocation); // adds starting ones
    qY.add(yLocation);
    
    flagMap = new HashMap<>(); // flags the ones down
    
    while(!qX.isEmpty() && !qY.isEmpty()){
      
      int xNext = qX.poll();
      int yNext = qY.poll();
      
      if(xNext == xDest && yNext == yDest){
         
        
      }
      
      
      
    }
    
  
  }
  


}
