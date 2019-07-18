package marchingcubes;

public class Polygonise {
    
    public Triangle[] triangles;

    public int callPolygonise(Gridcell grid,double isolevel) {
        int i, ntriang;
        int cubeindex;
        Point3D [] vertlist = new Point3D[12];

        Points points = new Points();

        cubeindex = 0;
        if (grid.val[0] < isolevel) cubeindex |= 1;
        if (grid.val[1] < isolevel) cubeindex |= 2;
        if (grid.val[2] < isolevel) cubeindex |= 4;
        if (grid.val[3] < isolevel) cubeindex |= 8;
        if (grid.val[4] < isolevel) cubeindex |= 16;
        if (grid.val[5] < isolevel) cubeindex |= 32;
        if (grid.val[6] < isolevel) cubeindex |= 64;
        if (grid.val[7] < isolevel) cubeindex |= 128;
        
        /*System.out.print("Grid Val: ");
        for (int q=0; q<8; q++)
        {
            System.out.print(grid.val[q]);
        }
        System.out.println("");
        
        System.out.println("cubeindex: " + cubeindex);*/

        /* Cube is entirely in/out of the surface */
        if (points.edgeTable[cubeindex] == 0)
            return(0);

        /* Find the vertices where the surface intersects the cube */
        if ((points.edgeTable[cubeindex] & 1) != 0)
            vertlist[0] =
                    VertexInterp(isolevel,grid.edges[0],grid.edges[1],grid.val[0],grid.val[1]);
        if ((points.edgeTable[cubeindex] & 2) != 0)
            vertlist[1] =
                    VertexInterp(isolevel,grid.edges[1],grid.edges[2],grid.val[1],grid.val[2]);
        if ((points.edgeTable[cubeindex] & 4) != 0)
            vertlist[2] =
                    VertexInterp(isolevel,grid.edges[2],grid.edges[3],grid.val[2],grid.val[3]);
        if ((points.edgeTable[cubeindex] & 8) != 0)
            vertlist[3] =
                    VertexInterp(isolevel,grid.edges[3],grid.edges[0],grid.val[3],grid.val[0]);
        if ((points.edgeTable[cubeindex] & 16) != 0)
            vertlist[4] =
                    VertexInterp(isolevel,grid.edges[4],grid.edges[5],grid.val[4],grid.val[5]);
        if ((points.edgeTable[cubeindex] & 32) != 0)
            vertlist[5] =
                    VertexInterp(isolevel,grid.edges[5],grid.edges[6],grid.val[5],grid.val[6]);
        if ((points.edgeTable[cubeindex] & 64) != 0)
            vertlist[6] =
                    VertexInterp(isolevel,grid.edges[6],grid.edges[7],grid.val[6],grid.val[7]);
        if ((points.edgeTable[cubeindex] & 128) != 0)
            vertlist[7] =
                    VertexInterp(isolevel,grid.edges[7],grid.edges[4],grid.val[7],grid.val[4]);
        if ((points.edgeTable[cubeindex] & 256) != 0)
            vertlist[8] =
                    VertexInterp(isolevel,grid.edges[0],grid.edges[4],grid.val[0],grid.val[4]);
        if ((points.edgeTable[cubeindex] & 512) != 0)
            vertlist[9] =
                    VertexInterp(isolevel,grid.edges[1],grid.edges[5],grid.val[1],grid.val[5]);
        if ((points.edgeTable[cubeindex] & 1024) != 0)
            vertlist[10] =
                    VertexInterp(isolevel,grid.edges[2],grid.edges[6],grid.val[2],grid.val[6]);
        if ((points.edgeTable[cubeindex] & 2048) != 0)
            vertlist[11] =
                    VertexInterp(isolevel,grid.edges[3],grid.edges[7],grid.val[3],grid.val[7]);

        /* Create the triangle */
        ntriang = 0;
        for (i = 0;points.triTable[cubeindex][i]!=-1; i += 3) {
            ntriang++;
        }
        
        triangles = new Triangle[ntriang];
        
        ntriang = 0;
        
        for (i = 0;points.triTable[cubeindex][i]!=-1; i += 3) {
            triangles[ntriang] = new Triangle();
            triangles[ntriang].setEdge(vertlist[points.triTable[cubeindex][i  ]], 0);
            triangles[ntriang].setEdge(vertlist[points.triTable[cubeindex][i+1]], 1);
            triangles[ntriang].setEdge(vertlist[points.triTable[cubeindex][i+2]], 2);
            ntriang++;
        }

        return(ntriang);

    }

    private Point3D VertexInterp(double isolevel,Point3D p1,Point3D p2,double valp1, double valp2)
    {
        double mu;
        Point3D p = new Point3D();

        if (java.lang.Math.abs(isolevel-valp1) < 0.00001)
            return(p1);
        if (java.lang.Math.abs(isolevel-valp2) < 0.00001)
            return(p2);
        if (java.lang.Math.abs(valp1-valp2) < 0.00001)
            return(p1);
        mu = (isolevel - valp1) / (valp2 - valp1);
        p.setX(p1.getX() + mu * (p2.getX() - p1.getX()));
        p.setY(p1.getY() + mu * (p2.getY() - p1.getY()));
        p.setZ(p1.getZ() + mu * (p2.getZ() - p1.getZ()));

        return(p);
    }

}
