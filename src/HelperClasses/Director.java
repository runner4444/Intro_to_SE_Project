package HelperClasses;

/**
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/

/**
 
 @author gundersonn
 */
public class Director extends Person
{
   Director( String u, String p )
   {
      super( u, p );
   }
   
   public void createEnsemble( String name, MusicNetwork network )
   {
      network.addEnsemble(name);
   }
}
