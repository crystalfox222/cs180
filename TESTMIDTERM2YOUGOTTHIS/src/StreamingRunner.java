import org.junit.Test;
import java.lang.reflect.Field;
import org.junit.Assert;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * A set of public test cases for question Q2 of Exam 2.
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- Exam 2</p>
 */
public class StreamingRunner {
    public static void main(String[] args)
    {
        PrintStream restoreOutput = System.out;
        Result result = JUnitCore.runClasses(StreamingPublicTest.class);
        System.setOut(restoreOutput);

        if (result.wasSuccessful())
        {
            System.out.println("Excellent - all tests ran successfully");
        }
        else
        {
            for (Failure failure : result.getFailures())
            {
                System.out.println(failure.toString());
            }
        }
    }

    public static class StreamingPublicTest {
        private final PrintStream originalOutput = System.out;

        @Test(timeout = 1000)
        public void songTests() {
            Song s = new Song("Let It Be","The Beatles",3.45);
            Field artist;
            Field songLength;

            ByteArrayOutputStream testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
            String expected = "Song: Let It Be" + System.lineSeparator() +
                    "Artist: The Beatles" + System.lineSeparator() +
                    "Length: 3.45 minutes" + System.lineSeparator() +
                    "File Name: Let It Be.mp3" + System.lineSeparator() +
                    "Size: 10.35 MB" + System.lineSeparator();


            assertEquals("Let It Be", s.getFileName());
            assertEquals("mp3",s.getFileExtension());
            assertEquals("The Beatles",s.getArtist());
            assertEquals(3.45,s.getSongLength(),0.001);
            assertEquals(10.35,s.calcFileSize(),0.001);
            s.printInfo();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n",System.lineSeparator()));

            s.setFileName("Is This It");
            s.setArtist("The Strokes");
            s.setSongLength(2.57);
            s.setFileSize(s.calcFileSize());
            assertEquals("Is This It",s.getFileName());
            assertEquals("The Strokes",s.getArtist());
            assertEquals(2.57, s.getSongLength(),0.001);
            assertEquals(7.71,s.calcFileSize(),0.001);
            expected = "Song: Is This It" + System.lineSeparator() +
                    "Artist: The Strokes" + System.lineSeparator() +
                    "Length: 2.57 minutes" + System.lineSeparator() +
                    "File Name: Is This It.mp3" + System.lineSeparator() +
                    "Size: 7.71 MB" + System.lineSeparator();
            testOut.reset();
            s.printInfo();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            //test fields
            try {
                artist = Song.class.getDeclaredField("artist");
                if(artist.getModifiers() != Modifier.PRIVATE || (!artist.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Song class has a field String artist and it's private!");
            }
            try {
                songLength = Song.class.getDeclaredField("songLength");
                if(songLength.getModifiers() != Modifier.PRIVATE || (!songLength.getType().equals(double.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Song class has a field double songLength and it's private!");
            }

            //test methods
            Method method;
            try {
                Constructor<Song> constructor = Song.class.getDeclaredConstructor(String.class, String.class, double.class);
                if(constructor.getModifiers() != Modifier.PUBLIC) {
                    throw new NoSuchMethodException();
                }
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure Song Constructor is set up correctly.");
            }

            try {
                method = Song.class.getDeclaredMethod("printInfo");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Song's printInfo method is set up correctly.");
            }

            try {
                method = Song.class.getDeclaredMethod("getArtist");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Song's getArtist method is set up correctly.");
            }

            try {
                method = Song.class.getDeclaredMethod("getSongLength");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(double.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Song's getSongLength method is set up correctly.");
            }

            try {
                method = Song.class.getDeclaredMethod("setArtist", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Song's setArtist method is set up correctly.");
            }

            try {
                method = Song.class.getDeclaredMethod("setSongLength", double.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Song's setSongLength method is set up correctly.");
            }
            System.setOut(originalOutput);
        }

        @Test(timeout = 1000)
        public void podcastTests() {
            Podcast p = new Podcast("March 31 News","News Now","NPR",36.44);
            Field podcastShow;
            Field producer;
            Field podcastLength;

            ByteArrayOutputStream testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
            String expected = "Podcast Episode: March 31 News" + System.lineSeparator() +
                    "Podcast Show: News Now" + System.lineSeparator() +
                    "Producer: NPR" + System.lineSeparator() +
                    "Length: 36.44 minutes" + System.lineSeparator() +
                    "File Name: March 31 News.mp3" + System.lineSeparator() +
                    "Size: 109.32 MB" + System.lineSeparator();

            assertEquals("March 31 News", p.getFileName());
            assertEquals("News Now",p.getPodcastShow());
            assertEquals("NPR",p.getProducer());
            assertEquals("mp3",p.getFileExtension());
            assertEquals(36.44,p.getPodcastLength(),0.001);
            assertEquals(109.32,p.calcFileSize(),0.001);
            p.printInfo();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            p.setFileName("True Crime Story 5");
            p.setPodcastShow("Serial");
            p.setProducer("This American Life");
            p.setPodcastLength(65.34);
            p.setFileSize(p.calcFileSize());
            assertEquals("True Crime Story 5",p.getFileName());
            assertEquals("Serial",p.getPodcastShow());
            assertEquals("This American Life",p.getProducer());
            assertEquals(65.34, p.getPodcastLength(),0.001);
            assertEquals(196.02,p.calcFileSize(),0.001);
            testOut.reset();
            expected = "Podcast Episode: True Crime Story 5" + System.lineSeparator() +
                    "Podcast Show: Serial" + System.lineSeparator() +
                    "Producer: This American Life" + System.lineSeparator() +
                    "Length: 65.34 minutes" + System.lineSeparator() +
                    "File Name: True Crime Story 5.mp3" + System.lineSeparator() +
                    "Size: 196.02 MB" + System.lineSeparator();
            p.printInfo();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            //test fields
            try {
                podcastShow = Podcast.class.getDeclaredField("podcastShow");
                if(podcastShow.getModifiers() != Modifier.PRIVATE || (!podcastShow.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Podcast class has a field String podcastShow and it's private!");
            }
            try {
                producer = Podcast.class.getDeclaredField("producer");
                if(producer.getModifiers() != Modifier.PRIVATE || (!producer.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Podcast class has a field String producer and it's private!");
            }
            try {
                podcastLength = Podcast.class.getDeclaredField("podcastLength");
                if(podcastLength.getModifiers() != Modifier.PRIVATE || (!podcastLength.getType().equals(double.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Podcast class has a field double podcastLength and it's private!");
            }

            //test methods
            Method method;
            try {
                Constructor<Podcast> constructor = Podcast.class.getDeclaredConstructor(String.class, String.class, String.class, double.class);
                if(constructor.getModifiers() != Modifier.PUBLIC) {
                    throw new NoSuchMethodException();
                }
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure Podcast Constructor is set up correctly.");
            }

            try {
                method = Podcast.class.getDeclaredMethod("printInfo");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Podcast's printInfo method is set up correctly.");
            }

            try {
                method = Podcast.class.getDeclaredMethod("getPodcastShow");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Podcast's getPodcastShow method is set up correctly.");
            }

            try {
                method = Podcast.class.getDeclaredMethod("getProducer");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Podcast's getProducer method is set up correctly.");
            }

            try {
                method = Podcast.class.getDeclaredMethod("getPodcastLength");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(double.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Podcast's getPodcastLength method is set up correctly.");
            }

            try {
                method = Podcast.class.getDeclaredMethod("setPodcastShow", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Podcasts's setPodcastShow method is set up correctly.");
            }

            try {
                method = Podcast.class.getDeclaredMethod("setProducer", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Podcasts's setProducer method is set up correctly.");
            }

            try {
                method = Podcast.class.getDeclaredMethod("setPodcastLength", double.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Podcasts's setPodcastLength method is set up correctly.");
            }
            System.setOut(originalOutput);
        }

        @Test(timeout = 1000)
        public void movieTests() {
            Movie m = new Movie("Inception","Christopher Nolan",2.56);
            Field director;
            Field movieLength;

            ByteArrayOutputStream testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
            String expected = "Movie Title: Inception" + System.lineSeparator() +
                    "Director: Christopher Nolan" + System.lineSeparator() +
                    "Length: 2.56 hours" + System.lineSeparator() +
                    "File Name: Inception.mp4" + System.lineSeparator() +
                    "Size: 3072.00 MB" +  System.lineSeparator();

            assertEquals("Inception", m.getFileName());
            assertEquals("mp4",m.getFileExtension());
            assertEquals("Christopher Nolan",m.getDirector());
            assertEquals(2.56,m.getMovieLength(),0.001);
            assertEquals(3072.00,m.calcFileSize(),0.001);
            m.printInfo();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            m.setFileName("Pulp Fiction");
            m.setDirector("Quentin Tarantino");
            m.setMovieLength(1.98);
            m.setFileSize(m.calcFileSize());
            assertEquals("Pulp Fiction",m.getFileName());
            assertEquals("Quentin Tarantino",m.getDirector());
            assertEquals(1.98, m.getMovieLength(),0.001);
            assertEquals(2376.00,m.calcFileSize(),0.001);
            testOut.reset();
            m.printInfo();
            expected = "Movie Title: Pulp Fiction" + System.lineSeparator() +
                    "Director: Quentin Tarantino" + System.lineSeparator() +
                    "Length: 1.98 hours" + System.lineSeparator() +
                    "File Name: Pulp Fiction.mp4" + System.lineSeparator() +
                    "Size: 2376.00 MB" +  System.lineSeparator();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            //test fields
            try {
                director = Movie.class.getDeclaredField("director");
                if(director.getModifiers() != Modifier.PRIVATE || (!director.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Movie class has a field String director and it's private!");
            }
            try {
                movieLength = Movie.class.getDeclaredField("movieLength");
                if(movieLength.getModifiers() != Modifier.PRIVATE || (!movieLength.getType().equals(double.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Movie class has a field double movieLength and it's private!");
            }

            //test methods
            Method method;
            try {
                Constructor<Movie> constructor = Movie.class.getDeclaredConstructor(String.class, String.class, double.class);
                if(constructor.getModifiers() != Modifier.PUBLIC) {
                    throw new NoSuchMethodException();
                }
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure Movie Constructor is set up correctly.");
            }

            try {
                method = Movie.class.getDeclaredMethod("printInfo");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Movie's printInfo method is set up correctly.");
            }

            try {
                method = Movie.class.getDeclaredMethod("getDirector");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Movie's getDirector method is set up correctly.");
            }

            try {
                method = Movie.class.getDeclaredMethod("getMovieLength");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(double.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Movie's getMovieLength method is set up correctly.");
            }

            try {
                method = Movie.class.getDeclaredMethod("setDirector", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Movie's setMovie method is set up correctly.");
            }

            try {
                method = Movie.class.getDeclaredMethod("setMovieLength", double.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Movie's setMovieLength method is set up correctly.");
            }
            System.setOut(originalOutput);
        }

        @Test(timeout = 1000)
        public void audioTests() {
            Audio a = new Audio("audioTest");
            Field fileName;
            Field fileExtension;
            Field fileSize;

            ByteArrayOutputStream testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
            String expected = "File Name: audioTest.mp3" + System.lineSeparator() +
                    "Size: 0.00 MB" +  System.lineSeparator();

            assertEquals("audioTest", a.getFileName());
            assertEquals("mp3",a.getFileExtension());
            a.printInfo();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));
            testOut.reset();
            a.printFileExtension();
            assertEquals("mp3" + System.lineSeparator(),testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            a.setFileName("audioTestSet");
            assertEquals("audioTestSet",a.getFileName());
            testOut.reset();
            a.printInfo();
            expected = "File Name: audioTestSet.mp3" + System.lineSeparator() +
                    "Size: 0.00 MB" +  System.lineSeparator();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            //test fields
            try {
                fileName = Audio.class.getDeclaredField("fileName");
                if(fileName.getModifiers() != Modifier.PRIVATE || (!fileName.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Audio class has a field String fileName and it's private!");
            }
            try {
                fileSize = Audio.class.getDeclaredField("fileSize");
                if(fileSize.getModifiers() != Modifier.PRIVATE || (!fileSize.getType().equals(double.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Audio class has a field double fileSize and it's private!");
            }
            try {
                fileExtension = Audio.class.getDeclaredField("fileExtension");
                if(fileExtension.getModifiers() != Modifier.PRIVATE || (!fileExtension.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Audio class has a field String fieldExtension and it's private!");
            }

            //test methods
            Method method;
            try {
                Constructor<Audio> constructor = Audio.class.getDeclaredConstructor(String.class);
                if(constructor.getModifiers() != Modifier.PUBLIC) {
                    throw new NoSuchMethodException();
                }
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure Audio Constructor is set up correctly.");
            }

            try {
                method = Audio.class.getDeclaredMethod("printInfo");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Audio's printInfo method is set up correctly.");
            }

            try {
                method = Audio.class.getDeclaredMethod("getFileName");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Audio's getFileName method is set up correctly.");
            }

            try {
                method = Audio.class.getDeclaredMethod("getFileSize");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(double.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Audio's getFileSize method is set up correctly.");
            }

            try {
                method = Audio.class.getDeclaredMethod("getFileExtension");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Audio's getFileExtension method is set up correctly.");
            }

            try {
                method = Audio.class.getDeclaredMethod("setFileName", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Audio's setFileName method is set up correctly.");
            }

            try {
                method = Audio.class.getDeclaredMethod("setFileSize", double.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Audio's setFileSize method is set up correctly.");
            }

            try {
                method = Audio.class.getDeclaredMethod("setFileExtension", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Audio's setFileExtension method is set up correctly.");
            }
            System.setOut(originalOutput);
        }

        @Test(timeout = 1000)
        public void videoTests() {
            Video v = new Video("videoTest");
            Field fileName;
            Field fileExtension;
            Field fileSize;

            ByteArrayOutputStream testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
            String expected = "File Name: videoTest.mp4" + System.lineSeparator() +
                    "Size: 0.00 MB" + System.lineSeparator();

            assertEquals("videoTest", v.getFileName());
            assertEquals("mp4",v.getFileExtension());
            v.printInfo();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));
            testOut.reset();
            v.printFileExtension();
            assertEquals("mp4" + System.lineSeparator(),testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            v.setFileName("videoTestSet");
            assertEquals("videoTestSet",v.getFileName());
            testOut.reset();
            v.printInfo();
            expected = "File Name: videoTestSet.mp4"  + System.lineSeparator() +
                    "Size: 0.00 MB"  + System.lineSeparator();
            assertEquals(expected,testOut.toString().replaceAll("\r\n|\n", System.lineSeparator()));

            //test fields
            try {
                fileName = Video.class.getDeclaredField("fileName");
                if(fileName.getModifiers() != Modifier.PRIVATE || (!fileName.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Video class has a field String fileName and it's private!");
            }
            try {
                fileSize = Video.class.getDeclaredField("fileSize");
                if(fileSize.getModifiers() != Modifier.PRIVATE || (!fileSize.getType().equals(double.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Video class has a field double fileSize and it's private!");
            }
            try {
                fileExtension = Video.class.getDeclaredField("fileExtension");
                if(fileExtension.getModifiers() != Modifier.PRIVATE || (!fileExtension.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that the Video class has a field String fieldExtension and it's private!");
            }

            //test methods
            Method method;
            try {
                Constructor<Video> constructor = Video.class.getDeclaredConstructor(String.class);
                if(constructor.getModifiers() != Modifier.PUBLIC) {
                    throw new NoSuchMethodException();
                }
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure Video Constructor is set up correctly.");
            }

            try {
                method = Video.class.getDeclaredMethod("printInfo");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Video's printInfo method is set up correctly.");
            }

            try {
                method = Video.class.getDeclaredMethod("getFileName");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Video's getFileName method is set up correctly.");
            }

            try {
                method = Video.class.getDeclaredMethod("getFileSize");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(double.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Video's getFileSize method is set up correctly.");
            }

            try {
                method = Video.class.getDeclaredMethod("getFileExtension");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Video's getFileExtension method is set up correctly.");
            }

            try {
                method = Video.class.getDeclaredMethod("setFileName", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Video's setFileName method is set up correctly.");
            }

            try {
                method = Video.class.getDeclaredMethod("setFileSize", double.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Video's setFileSize method is set up correctly.");
            }

            try {
                method = Video.class.getDeclaredMethod("setFileExtension", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Video's setFileExtension method is set up correctly.");
            }
            System.setOut(originalOutput);
        }
    }
}