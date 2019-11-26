package baserelacionale;

public class Produtos {


     private String codigo;
     private String descricion;
     private int prezo;

    public Produtos() {
    }

	
    public Produtos(String codigo) {
        this.codigo = codigo;
    }
    public Produtos(String codigo, String descricion, int prezo) {
       this.codigo = codigo;
       this.descricion = descricion;
       this.prezo = prezo;
    }
   
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescricion() {
        return this.descricion;
    }
    
    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }
    public int getPrezo() {
        return this.prezo;
    }
    
    public void setPrezo(int prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "Produtos{" + "codigo=" + codigo + ", descricion=" + descricion + ", prezo=" + prezo + '}';
    }




}


