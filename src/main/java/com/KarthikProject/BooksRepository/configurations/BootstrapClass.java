package com.KarthikProject.BooksRepository.configurations;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class BootstrapClass implements CommandLineRunner {
 Logger log=Logger.getAnonymousLogger();
  @Override
    public void run(String... args) {
      try {
          Thread.sleep(10000);
      } catch (InterruptedException ex) {
          throw new RuntimeException(ex);
      }
  }
}
