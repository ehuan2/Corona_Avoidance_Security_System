import java.util.*;

class pointLocation {

    int x, y;
    pointLocation parent;

    public pointLocation() {
        x = -1;
        y = -1;
        parent = null;
    }

    public pointLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setParent(pointLocation par) {
        this.parent = par;
    }

    public boolean equals(Object T) {

        if (T instanceof pointLocation) {
            pointLocation a = (pointLocation) T;
            return a.x == this.x && a.y == this.y;
        }

        return false;

    }

    public int hashCode() {

        return this.x + this.y;

    }

    @Override
    public String toString() {
        return "pointLocation{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class graphPathFinding {

    static int[] retracePath;
    static HashMap<String, Boolean> flagMap;

    public static LinkedList<pointLocation> findPath(int xLocation, int yLocation, int xDest, int yDest, int[] xValues, int[] yValues, int[] radius) { // BFS for path

        if (inContaminationAreas(xLocation, yLocation, xValues, yValues, radius)) {
            return null;
        }

        Queue<pointLocation> qPoint = new LinkedList<>(); // queues needed, each for x coordinate and y coordinate


        qPoint.add(new pointLocation(xLocation, yLocation)); // adds starting ones

        flagMap = new HashMap<>(); // flags the ones down

        while (!qPoint.isEmpty()) {


            pointLocation next = qPoint.poll();


            int xNext = next.x;
            int yNext = next.y;

            if (xNext == xDest && yNext == yDest) {
                return buildPath(next);
            }


            int[] xVector = new int[]{25, -25, 0, 0};
            int[] yVector = new int[]{0, 0, 25, -25};

            for (int i = 0; i < 4; i++) {
                int xNew = xNext + xVector[i];
                int yNew = yNext + yVector[i];

                if (flagMap.get(xNew + "|" + yNew) == null) {
                    if (xNew >= 0 && xNew <= 750 && yNew >= 0 && yNew <= 750) {

                        if (!inContaminationAreas(xNew, yNew, xValues, yValues, radius)) {

                            pointLocation addPoint = new pointLocation(xNew, yNew);


                            addPoint.parent = next;

                            qPoint.add(addPoint);

                            flagMap.put(xNew + "|" + yNew, true);


                        }

                    }

                }
            }

        }

        return null;


    }



    public static boolean withinRadius(int xLocale, int yLocale, int xRadius, int yRadius, int radius) { // returns true if in radius

        return Math.pow((xLocale - xRadius), 2) + Math.pow((yLocale - yRadius), 2) <= Math.pow(radius/2, 2);

    }


    public static boolean inContaminationAreas(int xLocation, int yLocation, int[] xValues, int[] yValues, int[] radius) {
        int numContamination = xValues.length;

        for (int i = 0; i < numContamination; i++) {
            if (withinRadius(xLocation, yLocation, xValues[i], yValues[i], radius[i])) {
                return true;
            }
        }

        return false;

    }

    public static LinkedList<pointLocation> buildPath(pointLocation endPoint) {
        if (endPoint.parent == null) {
            return new LinkedList<pointLocation>(Arrays.asList(endPoint));
        }
        LinkedList<pointLocation> out = buildPath(endPoint.parent);

        out.add(endPoint);

        return out;
    }

}
