package marchingcubes;

public class Point3D {

    double [] xyz = new double[3];

    public void setX(double x){
        xyz[0] = x;
    }

    public void setY(double y){
        xyz[1] = y;
    }

    public void setZ(double z){
        xyz[2] = z;
    }

    public double getX(){
        return xyz[0];
    }

    public double getY(){
        return xyz[1];
    }

    public double getZ(){
        return xyz[2];
    }

}
