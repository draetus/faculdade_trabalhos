/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marchingcubes;

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class MarchingCubes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polygonise poly = new Polygonise();
        
        ArrayList<Gridcell> grids = new ArrayList<>();
        
        ArrayList<Triangle> triangles = new ArrayList<>();
        
        
        double isolevel = 3.234;
        
        Data data = new Data();
        
        int aux = 0;
        
        for (int i=0; i<data.data.length-8; i+=8)
        {
            Gridcell grid = new Gridcell();
            for (int j=0; j<8; j++)
            {
                grid.val[j] = data.data[aux][0] + 
                          data.data[aux][1] +
                          data.data[aux][2];
                aux++;
            }
            poly.callPolygonise(grid, isolevel);
            if (poly.triangles != null)
            {
                for (int k=0; k<poly.triangles.length; k++)
                {
                    triangles.add(poly.triangles[k]);
                }
            }
            
            
        }
        
        
        float [][] points = new float[triangles.size() * 3][3];
        aux = 0;
        System.out.println(points.length);
        for (int i=0; i<triangles.size(); i++)
        {
            for (int j=0; j<3; j++)
            {
                points[aux][0] = (float)triangles.get(i).getEdge(j).getX();
                points[aux][1] = (float)triangles.get(i).getEdge(j).getY();
                points[aux][2] = (float)triangles.get(i).getEdge(j).getZ();
                aux++;
            }
            
        }

        
        for (int i=0; i<points.length; i++)
        {
            System.out.print("Coordenada " + i + ": ");
            for (int j=0; j<3; j++)
            {
                System.out.print(points[i][j] + " ");
            }
            System.out.println("");
        }
        
        System.out.println(points.length);
        DrawTriangle3d.run(points);
        
        
    }
    
}
