package com.KarthikProject.BooksRepository.configurations;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/*To Handle the Docker Issue.
The application will be started after 10 secs (Once MYSQL is loaded).
* */
import java.util.logging.Logger;

@Component
public class BootstrapClass implements CommandLineRunner {
 Logger log=Logger.getAnonymousLogger();
  @Override
    public void run(String... args) {
      try {
          Thread.sleep(10000);
          log.info("Application is started");
      } catch (InterruptedException ex) {
          throw new RuntimeException(ex);
      }
  }
}
