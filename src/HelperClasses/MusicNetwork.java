package HelperClasses;

import java.util.Date;
import java.util.Vector;

/**
 
 @author gundersonn
 */
public class MusicNetwork 
{
   private Person currentUser;
   Vector<Ensemble> ensembles;
   Vector<Person> people;
   
   public MusicNetwork()
   {  
      people = new Vector<>();
      ensembles = new Vector<>();
      currentUser = null;
      Person stu1 = new Student( "Nathan Gunderson", "Gunderson" );
      people.add(stu1);
      Person stu2 = new Student( "Tristan Mansfield", "Mansfield" );
      people.add(stu2);
      Person stu3 = new Student( "Mitch Harter",  "Harter" );
      people.add(stu3);
      Person stu4 = new Student( "Charlie Laabs", "Laabs" );
      people.add(stu4);
      Person stu5 = new Student( "Bob Smith", "Smith" );
      people.add(stu5);
      Person stu6 = new Student( "Joe Smith", "Smith" );
      people.add(stu6);
      Person admin = new Administrator( "Omar Meqdadi", "Meqdadi" );
      people.add(admin);
      Person dir1 = new Director( "Keith Leinert", "Leinert" );
      people.add(dir1);
      Person dir2 = new Director( "Barry Ellis", "Ellis" );
      people.add(dir2);
      Person dir3 = new Director( "Matt Gregg", "Gregg" );
      people.add(dir3);
      
      Date d1 = new Date(115, 12, 24 , 18, 00);
      Event e1 = new Event( "Pioneer Student Center", "Steel Pan Concert", d1 );
      Date d2 = new Date( 116, 1, 15 , 19, 00);
      Event e2 = new Event( "Ulsvik", "Chamber Recital", d2 );
      Date d3 = new Date( 116, 1, 24, 5, 30 );
      Event e3 = new Event( "Ullrich", "Lab Recital Demo", d3 );
      Vector<Event> eventList1 = new Vector<>();
      eventList1.add(e1);
      eventList1.add(e2);
      eventList1.add(e3);
      
      Ensemble en1 = new Ensemble( (Director) dir1, eventList1 , "Steel Band" );
      en1.addMember(stu1);
      en1.addMember(stu2);
      ensembles.add(en1);
      
      Date d4 = new Date(115, 12, 24, 8, 59 );
      Event e4 = new Event( "Center for the Arts", "Super Pops Concert", d4 );
      Date d5 = new Date( 116, 2, 15, 19, 20 );
      Event e5 = new Event( "Ottensman Basement", "Bach Chorales Only", d5 );
      Date d6 = new Date( 116, 3, 24, 12, 01);
      Event e6 = new Event( "Stations", "Flutes featuring Triangle Ensemble", d6 );
      Vector<Event> eventList2 = new Vector<>();
      eventList2.add(e4);
      eventList2.add(e5);
      eventList2.add(e6);
      
      Ensemble en2 = new Ensemble( (Director) dir2, eventList2 , "Symphonic Wind Ensemble" );
      en2.addMember(stu3);
      en2.addMember(stu4);
      ensembles.add(en2);
      
      
      Date d7 = new Date(115, 12, 18, 1, 45 );
      Event e7 = new Event( "FieldHouse", "Clarinets vs Euphoniums", d7 );
      Date d8 = new Date( 116, 1, 25, 21, 37 );
      Event e8 = new Event( "Indoor Pool", "Cymbal Crash and Splash", d8 );
      Date d9 = new Date( 116, 3, 16, 8, 59 );
      Event e9 = new Event( "Karmann Library Third Floor", "Saints Come Marching In", d9 );
      Vector<Event> eventList3 = new Vector<>();
      eventList3.add(e7);
      eventList3.add(e8);
      eventList3.add(e9);
      
      Ensemble en3 = new Ensemble( (Director) dir3, eventList3 , "Symphony Band" );
      en3.addMember(stu5);
      en3.addMember(stu6);
      ensembles.add(en3);
   
   }
   
   public Person getCurrentUser()
   {  
      return currentUser;
   }
   
   public void setCurrentUser( Person p )
   {  
      currentUser = p;
   }
   
   public Vector<Ensemble> ensemblesFor( Person p )
   {  
      if( p instanceof Student )
      {
         Vector<Ensemble> temp = new Vector<>();
         for( Ensemble e : ensembles )
         {
            if( e.contains(p) )
               temp.add(e);
         }
         return temp;
      }
      else
      {  
         Vector<Ensemble> temp = new Vector<>();
         for( Ensemble e : ensembles )
         {
            if( e.getDirector().equals(p))
               temp.add(e);
         }
         return temp;
      }
   }
   
   public Vector<Event> eventsFor( Person p )
   {  

      Vector<Ensemble> tempEnsembles = ensemblesFor(p);
      Vector<Event> tempEvents = new Vector<>();
      Vector<Event> returnEvents = new Vector<>();
      for( Ensemble en : tempEnsembles )
      {
         tempEvents = en.getEvents();
         for( Event ev : tempEvents )
            returnEvents.add(ev);
      }
      return returnEvents;
   }
   
   public Vector<Person> getPeople()
   {
      return people;
   }
   
   // Check here if login problems
   public Person login( String username, String password )
   {  
      Person temp = null;
      Person newp = new Person( username, password );
      for( Person p : people )
      {
         if( p.equals(newp))
         {
            temp = p;
            break;
         }
      }
      return temp;
   }
   
   public boolean addPerson( Person p )
   {
      return people.add(p);
   }
   
   public boolean removePerson( Person p )
   {
      return people.remove(p);
   }
   
   public boolean addEnsemble( String name )
   {
      Vector<Event> eventList = new Vector<>();
      Ensemble en = new Ensemble( (Director) currentUser, eventList , name );
      return ensembles.add(en);
   }
   
}
