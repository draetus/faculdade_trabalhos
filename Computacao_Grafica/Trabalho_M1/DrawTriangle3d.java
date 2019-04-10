/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class DrawTriangle3d implements GLEventListener {

   private GLU glu = new GLU();
   private float rtri = 0.0f;
   private float[][] points;
   
   public DrawTriangle3d(float[][] points)
   {
       this.points = points;
   }
	
   @Override
   public void display( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      
		
      gl.glShadeModel( GL2.GL_SMOOTH );
      gl.glClearColor( 0f, 0f, 0f, 0f );
      gl.glClearDepth( 1.0f );
      gl.glEnable( GL2.GL_DEPTH_TEST );
      gl.glDepthFunc( GL2.GL_LEQUAL );
      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

      // Clear The Screen And The Depth Buffer
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); 
      gl.glLoadIdentity(); // Reset The View
      gl.glTranslatef( -0.5f,0.0f,-6.0f ); // Move the triangle
      gl.glRotatef( rtri, 0.0f, 1.0f, 0.0f );
      gl.glBegin( GL2.GL_TRIANGLES ); 

      //drawing triangle in all dimensions
      //front
      gl.glColor3f( 1, 0, 0 ); // Red
      gl.glVertex3f( points[0][0], points[0][1], points[0][2] ); // Top
		
      gl.glColor3f( 1, 0, 0 ); // Green
      gl.glVertex3f( points[1][0], points[1][1], points[1][2] ); // Left
		
      gl.glColor3f( 1, 0, 0 ); // Blue
      gl.glVertex3f( points[2][0], points[2][1], points[2][2] ); // Right)

      //right
      gl.glColor3f( 0, 0, 1 );
      gl.glVertex3f( points[0][0], points[0][1], points[0][2] ); // Top
		
      gl.glColor3f( 0, 0, 1 );
      gl.glVertex3f( points[2][0], points[2][1], points[2][2] ); // Left
		
      gl.glColor3f( 0, 0, 1 );
      gl.glVertex3f( points[3][0], points[3][1], points[3][2] ); // Right

      //left
      gl.glColor3f( 0, 1, 0 );
      gl.glVertex3f( points[0][0], points[0][1], points[0][2] ); // Top
		
      gl.glColor3f( 0, 1, 0 );
      gl.glVertex3f( points[3][0], points[3][1], points[3][2] ); // Left 
		
      gl.glColor3f( 0, 1, 0 );
      gl.glVertex3f( points[1][0], points[1][1], points[1][2] ); // Right 

      //top
      gl.glColor3f( 1, 0, 0 );
      gl.glVertex3f( points[1][0], points[1][1], points[1][2] ); // Top
		
      gl.glColor3f( 1, 0, 0 );
      gl.glVertex3f( points[2][0], points[2][1], points[2][2] ); // Left
		
      gl.glColor3f( 1, 0, 0 );
      gl.glVertex3f( points[3][0], points[3][1], points[3][2] ); // Right

      gl.glEnd(); // Done Drawing 3d triangle (Pyramid)

      gl.glFlush();
      rtri += 0.2f;
   }
      
   @Override
   public void dispose( GLAutoDrawable drawable ) {
   }
   
   @Override
   public void init( GLAutoDrawable drawable) {
	
      final GL2 gl = drawable.getGL().getGL2();
		
      gl.glShadeModel( GL2.GL_SMOOTH );
      gl.glClearColor( 0f, 0f, 0f, 0f );
      gl.glClearDepth( 1.0f );
      gl.glEnable( GL2.GL_DEPTH_TEST );
      gl.glDepthFunc( GL2.GL_LEQUAL );
      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
   }
   
   @Override
   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height ) {
	
      // TODO Auto-generated method stub
      final GL2 gl = drawable.getGL().getGL2();
      if( height <= 0 ) 
         height = 1;
			
      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      gl.glMatrixMode( GL2.GL_PROJECTION );
      gl.glLoadIdentity();
		
      glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
      gl.glMatrixMode( GL2.GL_MODELVIEW );
      gl.glLoadIdentity();
   }
      
   public static void run( float[][] points) {
       
      // TODO Auto-generated method stub
      final GLProfile profile = GLProfile.get( GLProfile.GL2 );
      GLCapabilities capabilities = new GLCapabilities( profile );
		
      // The canvas
      final GLCanvas glcanvas = new GLCanvas( capabilities );
      DrawTriangle3d triangledepthtest = new DrawTriangle3d(points);
		
      glcanvas.addGLEventListener( triangledepthtest );
      glcanvas.setSize( 800, 600 );
		
      final JFrame frame = new JFrame ( "3d Triangle (solid)" );
      frame.getContentPane().add(glcanvas);
      frame.setSize( frame.getContentPane().getPreferredSize() );
      frame.setVisible( true );
      final FPSAnimator animator = new FPSAnimator( glcanvas, 300,true);
		
      animator.start();
   }
	
}