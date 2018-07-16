/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfuzzyfinderapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JTable;

/**
 *
 * @author Olanrewaju-PC
 */
public class Unzip {
    public void unzip( File zipFile  , String extractPath, JTable jTable1 ) throws IOException
    {                
        
        String tempPath = null;
        StringBuffer path = null;
        String directoryName = null;
        File directoryPath = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = new FileInputStream( zipFile );
        ZipInputStream zipReader = new ZipInputStream( fileInputStream );
        ZipEntry zipEntry = null;
        int bytesRead = -1;
        byte buffer[] = new byte[1024];        
        
        // each ZIP archive may contain files and directories
        // before extraction , directory hierachy must be created
        
        // create directory hierachy
        while ( ( zipEntry = zipReader.getNextEntry() ) != null  )
        {                           
            
            // is current zip entry a directory?
            // if yes and it doesn't exist, create it
            if ( zipEntry.isDirectory() == true )
            {
                File directory = new File( extractPath + "/" + zipEntry.toString() );
                
                if ( directory.exists() == false )
                {
                    directory.mkdirs();                
                }

            } 
            
            // close current entry
            zipReader.closeEntry();            
            
        } // end while
        
        zipReader.close();
        
        // reinitialize stream objects
        fileInputStream = new FileInputStream( zipFile );
        zipReader = new ZipInputStream( fileInputStream );        
        
        // extract zipped files
        while ( ( zipEntry = zipReader.getNextEntry() ) != null )        
        {
            if ( zipEntry.isDirectory() == false )
            {
               // create a file for holding unzipped version of current zipped file
               fileOutputStream = new FileOutputStream(  extractPath + "/" + zipEntry.getName() );
                                              
               // read zipped file data and
               // write it in unzipped file            
               while( ( bytesRead =  zipReader.read( buffer ) ) != -1 )
                   fileOutputStream.write( buffer , 0 , bytesRead );
                
               // close current zipped entry( file )
               zipReader.closeEntry();
            
               // flush output stream
               fileOutputStream.flush();
            
               // close output stream
               fileOutputStream.close();
            }
            
        } // end while
        
        // close object zipReader and it's 
        // underlying stream 
        zipReader.close();   
    }
}
