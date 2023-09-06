/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cv100
 */
import edu.escuelaing.app.taller3.arep.Seeker;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{

    /**
     * Constructor class
     * @param testName name Test
     */
    public AppTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    public void shouldSearchTitles()
    {
        HashMap<String, String> responses = new HashMap<>();
        responses.put("Blade Runner", "[{\"Title\":\"Blade Runner\",\"Year\":\"1982\",\"Rated\":\"R\",\"Released\":\"25 Jun 1982\",\"Runtime\":\"117 min\",\"Genre\":\"Action, Drama, Sci-Fi\",\"Director\":\"Ridley Scott\",\"Writer\":\"Hampton Fancher, David Webb Peoples, Philip K. Dick\",\"Actors\":\"Harrison Ford, Rutger Hauer, Sean Young\",\"Plot\":\"A blade runner must pursue and terminate four replicants who stole a ship in space and have returned to Earth to find their creator.\",\"Language\":\"English, German, Cantonese, Japanese, Hungarian, Arabic, Korean\",\"Country\":\"United States\",\"Awards\":\"Nominated for 2 Oscars. 13 wins & 19 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzQzMzJhZTEtOWM4NS00MTdhLTg0YjgtMjM4MDRkZjUwZDBlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.1/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"89%\"},{\"Source\":\"Metacritic\",\"Value\":\"84/100\"}],\"Metascore\":\"84\",\"imdbRating\":\"8.1\",\"imdbVotes\":\"775,925\",\"imdbID\":\"tt0083658\",\"Type\":\"movie\",\"DVD\":\"30 Oct 2001\",\"BoxOffice\":\"$32,914,489\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}]");
        responses.put("The Avengers", "[{\"Title\":\"The Avengers\",\"Year\":\"2012\",\"Rated\":\"PG-13\",\"Released\":\"04 May 2012\",\"Runtime\":\"143 min\",\"Genre\":\"Action, Sci-Fi\",\"Director\":\"Joss Whedon\",\"Writer\":\"Joss Whedon, Zak Penn\",\"Actors\":\"Robert Downey Jr., Chris Evans, Scarlett Johansson\",\"Plot\":\"Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.\",\"Language\":\"English, Russian, Hindi\",\"Country\":\"United States\",\"Awards\":\"Nominated for 1 Oscar. 38 wins & 80 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"91%\"},{\"Source\":\"Metacritic\",\"Value\":\"69/100\"}],\"Metascore\":\"69\",\"imdbRating\":\"8.0\",\"imdbVotes\":\"1,397,515\",\"imdbID\":\"tt0848228\",\"Type\":\"movie\",\"DVD\":\"25 Sep 2012\",\"BoxOffice\":\"$623,357,910\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}]");
        responses.put("Guardians of the galaxy", "[{\"Title\":\"Guardians of the Galaxy\",\"Year\":\"2014\",\"Rated\":\"PG-13\",\"Released\":\"01 Aug 2014\",\"Runtime\":\"121 min\",\"Genre\":\"Action, Adventure, Comedy\",\"Director\":\"James Gunn\",\"Writer\":\"James Gunn, Nicole Perlman, Dan Abnett\",\"Actors\":\"Chris Pratt, Vin Diesel, Bradley Cooper\",\"Plot\":\"A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Nominated for 2 Oscars. 52 wins & 102 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZTkwZjU3MTctMGExMi00YjU5LTgwMDMtOWNkZDRlZjQ4NmZhXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"92%\"},{\"Source\":\"Metacritic\",\"Value\":\"76/100\"}],\"Metascore\":\"76\",\"imdbRating\":\"8.0\",\"imdbVotes\":\"1,187,126\",\"imdbID\":\"tt2015381\",\"Type\":\"movie\",\"DVD\":\"09 Dec 2014\",\"BoxOffice\":\"$333,718,600\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}]");
        responses.put("Guardians", "[{\"Title\":\"Guardians\",\"Year\":\"2009\",\"Rated\":\"Not Rated\",\"Released\":\"24 Jun 2009\",\"Runtime\":\"87 min\",\"Genre\":\"Horror, Sci-Fi\",\"Director\":\"Drew Maxwell\",\"Writer\":\"Drew Maxwell\",\"Actors\":\"Chris Bell, Benjamin Budd, Tylan Canady\",\"Plot\":\"Twilight Cove, a small forgotten town, is besieged by hideous creatures summoned into our dimension. It's only a matter of time before the army of creatures attacks the rest of civilization and wreaks havoc upon the world. At dusk...\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"N/A\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjgyOTkyOTgwMV5BMl5BanBnXkFtZTgwNTM1OTkwMzE@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"3.0/10\"}],\"Metascore\":\"N/A\",\"imdbRating\":\"3.0\",\"imdbVotes\":\"285\",\"imdbID\":\"tt0486592\",\"Type\":\"movie\",\"DVD\":\"15 Jul 2008\",\"BoxOffice\":\"N/A\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}]");
        responses.put("Thor", "[{\"Title\":\"Thor\",\"Year\":\"2011\",\"Rated\":\"PG-13\",\"Released\":\"06 May 2011\",\"Runtime\":\"115 min\",\"Genre\":\"Action, Fantasy\",\"Director\":\"Kenneth Branagh\",\"Writer\":\"Ashley Miller, Zack Stentz, Don Payne\",\"Actors\":\"Chris Hemsworth, Anthony Hopkins, Natalie Portman\",\"Plot\":\"The powerful but arrogant god Thor is cast out of Asgard to live amongst humans in Midgard (Earth), where he soon becomes one of their finest defenders.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"5 wins & 30 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BOGE4NzU1YTAtNzA3Mi00ZTA2LTg2YmYtMDJmMThiMjlkYjg2XkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"77%\"},{\"Source\":\"Metacritic\",\"Value\":\"57/100\"}],\"Metascore\":\"57\",\"imdbRating\":\"7.0\",\"imdbVotes\":\"855,477\",\"imdbID\":\"tt0800369\",\"Type\":\"movie\",\"DVD\":\"13 Sep 2011\",\"BoxOffice\":\"$181,030,624\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}]");
        responses.put("Spider Man", "[{\"Title\":\"Spider Man: Lost Cause\",\"Year\":\"2014\",\"Rated\":\"N/A\",\"Released\":\"26 Sep 2014\",\"Runtime\":\"140 min\",\"Genre\":\"Action, Adventure, Comedy\",\"Director\":\"Joey Lever\",\"Writer\":\"Steve Ditko, Stan Lee, Joey Lever\",\"Actors\":\"Joey Lever, Craig Ellis, Teravis Ward\",\"Plot\":\"Peter Parker a lone child discovers that his parents were in a horrifying plot to make mankind change. getting bitten by his fathers invention he develops super powers to tries to find answers to his whole life, try and juggle a r...\",\"Language\":\"English\",\"Country\":\"United Kingdom\",\"Awards\":\"N/A\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BYmZkYWRlNWQtOGY0Zi00MWZkLWJiZTktNjRjMDY4MTU2YzAyXkEyXkFqcGdeQXVyMzYzNzc1NjY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"4.0/10\"}],\"Metascore\":\"N/A\",\"imdbRating\":\"4.0\",\"imdbVotes\":\"440\",\"imdbID\":\"tt2803854\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"N/A\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}]");
        responses.put("Harry", "[{\"Title\":\"Harry Potter and the Deathly Hallows: Part 2\",\"Year\":\"2011\",\"Rated\":\"PG-13\",\"Released\":\"15 Jul 2011\",\"Runtime\":\"130 min\",\"Genre\":\"Adventure, Family, Fantasy\",\"Director\":\"David Yates\",\"Writer\":\"Steve Kloves, J.K. Rowling\",\"Actors\":\"Daniel Radcliffe, Emma Watson, Rupert Grint\",\"Plot\":\"Harry, Ron, and Hermione search for Voldemort's remaining Horcruxes in their effort to destroy the Dark Lord as the final battle rages on at Hogwarts.\",\"Language\":\"English, Latin\",\"Country\":\"United Kingdom, United States\",\"Awards\":\"Nominated for 3 Oscars. 47 wins & 94 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMGVmMWNiMDktYjQ0Mi00MWIxLTk0N2UtN2ZlYTdkN2IzNDNlXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.1/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"96%\"},{\"Source\":\"Metacritic\",\"Value\":\"85/100\"}],\"Metascore\":\"85\",\"imdbRating\":\"8.1\",\"imdbVotes\":\"882,427\",\"imdbID\":\"tt1201607\",\"Type\":\"movie\",\"DVD\":\"11 Nov 2011\",\"BoxOffice\":\"$381,447,587\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}]");

        ArrayList<ConcurrentTest> threadTests = new ArrayList<>();
        threadTests.add(new ConcurrentTest("Blade Runner"));
        threadTests.add(new ConcurrentTest("The Avengers"));
        threadTests.add(new ConcurrentTest("Guardians of the galaxy"));
        threadTests.add(new ConcurrentTest("Guardians"));
        threadTests.add(new ConcurrentTest("Thor"));
        threadTests.add(new ConcurrentTest("Spider Man"));
        threadTests.add(new ConcurrentTest("Harry"));

        for(ConcurrentTest threadTest: threadTests){
            threadTest.run();
        }
        for(ConcurrentTest threadTest: threadTests){
            try {
                threadTest.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for(ConcurrentTest threadTest: threadTests){
            assertEquals(responses.get(threadTest.getTitle()), threadTest.getResponse());
        }
    }

    public void testCahceConcurrent(){
        Seeker.getInstance().clear();
        ArrayList<ConcurrentTest> threadTests = new ArrayList<>();
        
        threadTests.add(new ConcurrentTest("Thor"));
        threadTests.add(new ConcurrentTest("Thor"));
        threadTests.add(new ConcurrentTest("Thor"));
        threadTests.add(new ConcurrentTest("Thor"));
        threadTests.add(new ConcurrentTest("Thor"));
        
        threadTests.add(new ConcurrentTest("Emby"));
        threadTests.add(new ConcurrentTest("Emby"));
        threadTests.add(new ConcurrentTest("Emby"));
        threadTests.add(new ConcurrentTest("Emby"));
        threadTests.add(new ConcurrentTest("Emby"));

        

        for(ConcurrentTest threadTest: threadTests){
            threadTest.run();
        }
        for(ConcurrentTest threadTest: threadTests){
            try {
                threadTest.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        assertEquals(2,     Seeker.getInstance().size());
    }
}