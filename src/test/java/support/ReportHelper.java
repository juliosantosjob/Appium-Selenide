package support;

import java.io.File;

import org.junit.Test;

public class ReportHelper {

  @Test
  public void report() {
    File arquivo = new File("target/cucumber-html-reports/feature-overview.html");
    File dir = new File("target/cucumber-html-reports/embeddings");

    boolean ok = arquivo.renameTo(new File(dir, arquivo.getName()));

    if (ok) {
      System.out.println("Arquivo foi movido com sucesso");
    } else {
      System.out.println("Não foi possível mover o arquivo");
    }
  }
}
