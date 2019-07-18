package marchingcubes;

public class Triangle {

    private Point3D[] edges = new Point3D[3];

    public void setEdge(Point3D point, int edgeNumber){
        edges[edgeNumber] = point;
    }

    public Point3D getEdge(int edgeNumber){
        return edges[edgeNumber];
    }

}
