import java.io.IOException;

public class armazenamento implements Comparable <armazenamento> {
    private double limite;
    private String nomeCompra;
    private double valorCompra;
    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {

        this.valorCompra = valorCompra;
    }

    public String getNomeCompra() {
        return nomeCompra;
    }

    public void setNomeCompra(String nomeCompra) {
        this.nomeCompra = nomeCompra;
    }

    public double getLimite() {

        return limite;
}
public void setLimite(double limite) {

        this.limite = limite;
}

   
public void terminal(){
     try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
}

  @Override
  public String toString() {
      // TODO Auto-generated method stub
      return  nomeCompra +": "  + (int) (valorCompra);
            
  }
  public int compareTo(armazenamento outro) {
    return Double.compare(this.valorCompra, outro.valorCompra);
}
}
