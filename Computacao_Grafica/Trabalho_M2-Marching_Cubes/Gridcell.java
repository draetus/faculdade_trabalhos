package marchingcubes;

public class Gridcell {

    public Point3D [] edges = new Point3D[8];
    public double [] val = new double[8];
    
    public Gridcell() {
        edges[0] = new Point3D();
        edges[0].setX(0);
        edges[0].setY(0);
        edges[0].setZ(0);
        
        edges[1] = new Point3D();
        edges[1].setX(0);
        edges[1].setY(0);
        edges[1].setZ(5);
        
        edges[2] = new Point3D();
        edges[2].setX(5);
        edges[2].setY(0);
        edges[2].setZ(0);
        
        edges[3] = new Point3D();
        edges[3].setX(5);
        edges[3].setY(0);
        edges[3].setZ(5);
        
        edges[4] = new Point3D();
        edges[4].setX(0);
        edges[4].setY(5);
        edges[4].setZ(0);
        
        edges[5] = new Point3D();
        edges[5].setX(0);
        edges[5].setY(5);
        edges[5].setZ(5);
        
        edges[6] = new Point3D();
        edges[6].setX(5);
        edges[6].setY(5);
        edges[6].setZ(0);
        
        edges[7] = new Point3D();
        edges[7].setX(5);
        edges[7].setY(5);
        edges[7].setZ(5);
        
        /*val[0] = 0;
        val[1] = 0;
        val[2] = 0;
        val[3] = 0;
        val[4] = 0;
        val[5] = 0;
        val[6] = 0;
        val[7] = 0;*/
        
    }

}
