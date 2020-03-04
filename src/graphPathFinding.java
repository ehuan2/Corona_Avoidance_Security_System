
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
   
   if(inContaminationAreas(xLocation, yLocation, xValues, yValues, radius){
    return null;
   }
   
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
   
   return null;
    
  
  }
 
 
 public static boolean withinRadius(int xLocale, int yLocale, int xRadius, int yRadius, int radius){ // returns true if in radius
  
  return Math.pow((xLocale-xRadius), 2) + Math.pow((yLocale - yRadius), 2) <= Math.pow(radius, 2);
  
 }


 public static boolean inContaminationAreas(int xLocation, int yLocation, int[]xValues, int[]yValues, int[]radius){
  int numContamination = xValues.length;
   
   for(int i = 0; i < numContamination; i++){
     if(withinRadius(xLocation, yLocation, xValues[i], yValues[i], radius[i])){
      return true;
     }
   }
  
  return false;
  
 }
 
}
