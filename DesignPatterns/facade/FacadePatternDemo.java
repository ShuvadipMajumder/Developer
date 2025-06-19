package facade;

//Subsystem Classes
class DvdPlayer {
 public void on() {
     System.out.println("DVD Player On");
 }
 public void play(String movie) {
     System.out.println("Playing movie: " + movie);
 }
 public void off() {
     System.out.println("DVD Player Off");
 }
}

class Projector {
 public void on() {
     System.out.println("Projector On");
 }
 public void wideScreenMode() {
     System.out.println("Projector in widescreen mode");
 }
 public void off() {
     System.out.println("Projector Off");
 }
}

class SoundSystem {
 public void on() {
     System.out.println("Sound System On");
 }
 public void setVolume(int volume) {
     System.out.println("Sound System volume set to " + volume);
 }
 public void off() {
     System.out.println("Sound System Off");
 }
}

//Facade Class
class HomeTheaterFacade {
 private DvdPlayer dvdPlayer;
 private Projector projector;
 private SoundSystem soundSystem;

 public HomeTheaterFacade(DvdPlayer dvdPlayer, Projector projector, SoundSystem soundSystem) {
     this.dvdPlayer = dvdPlayer;
     this.projector = projector;
     this.soundSystem = soundSystem;
 }

 public void watchMovie(String movie) {
     System.out.println("Get ready to watch a movie...");
     dvdPlayer.on();
     projector.on();
     projector.wideScreenMode();
     soundSystem.on();
     soundSystem.setVolume(10);
     dvdPlayer.play(movie);
 }

 public void endMovie() {
     System.out.println("Shutting down home theater...");
     dvdPlayer.off();
     projector.off();
     soundSystem.off();
 }
}

//Client Usage
public class FacadePatternDemo {
 public static void main(String[] args) {
     DvdPlayer dvd = new DvdPlayer();
     Projector projector = new Projector();
     SoundSystem sound = new SoundSystem();

     HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound);

     homeTheater.watchMovie("The Matrix");
     System.out.println("\n");
     homeTheater.endMovie();
 }
}
