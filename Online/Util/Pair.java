/**
* Clase que representa la estructura de datos de pares.
* Los parametros 'a' y 'b' pueden ser de diferente tipo.
* El objeto puede ser inmutable o no.
*
* @author  Los Marcos
* @version 1.0
* @since   11-02-20 
*/
public class Pair<A, B> {
  private A a;    // Primer elemento del Pair
  private B b;    // Segundo elemento del Pair
  private boolean isMutable;    // Indica si se pueden modificar los parametros en ejecución

  /**
   * Crea un nuevo Pair mutable con el primer elemento 'a' y segundo 'b'.
   * @param a, primer elemento del Pair.
   * @param b, segundo elemento del Pair.
   * @exception NullPointerException, si algún parametro de entrada es null.
   */
  public Pair(A a, B b) {
    if (a == null || b == null) {
      throw new NullPointerException("No se aceptan parametros null.");
    }
    this.a = a;
    this.b = b;
    isMutable = true;
  }

  /**
   * Crea un nuevo Pair con el primer elemento 'a', segundo 'b' e indicando si es mutable.
   * @param a, primer elemento del Pair.
   * @param b, segundo elemento del Pair.
   * @param isMutable, indica si el par será o no mutable.
   * @exception NullPointerException, si algún parametro de entrada es null.
   */
  public Pair(A a, B b, boolean isMutable) {
    if (a == null || b == null) {
      throw new NullPointerException("No se aceptan parametros null.");
    }
    this.a = a;
    this.b = b;
    this.isMutable = isMutable;
  }

  /**
   * Devuelve el primer elemento.
   * @return a, el primer elemento.
   */
  public A getA() {
    return a;
  }

  /**
   * Devuelve el segundo elemento.
   * @return b, el segundo elemento.
   */
  public B getB() {
    return b;
  }

  /**
   * Si el Pair es mutable, cambia el valor del primer parametro.
   * @param a, el nuevo valor del primer elemento.
   * @exception UnsupportedOperationException, si el objeto es inmutable.
   */
  public void setA(A a) {
    if (isMutable) {
      this.a = a;
    } else {
      throw new UnsupportedOperationException("El objeto es inmutable.");
    }
  }

  /**
   * Si el Pair es mutable, cambia el valor del segundo parametro.
   * @param b, el nuevo valor del segundo elemento.
   * @exception UnsupportedOperationException, si el objeto es inmutable.
   */
  public void setB(B b) {
    if (isMutable) {
      this.b = b;
    } else {
      throw new UnsupportedOperationException("El objeto es inmutable.");
    }
  }

  /**
   * Si el Pair es mutable, cambia el valor de ambos parametros.
   * @param a, el nuevo valor del primer elemento.
   * @param b, el nuevo valor del segundo elemento.
   * @exception UnsupportedOperationException, si el objeto es inmutable.
   */
  public void setAB(A a, B b) {
    if (isMutable) {
      this.a = a;
      this.b = b;
    } else {
      throw new UnsupportedOperationException("El objeto es inmutable.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Pair) {
      Pair<A, B> aux = (Pair<A, B>) o;
      return a.equals(aux.getA()) && b.equals(aux.getB());
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    int hash = 1;
    hash *= 17 + a.hashCode();
    hash *= 31 + b.hashCode();
    return hash;
  }
}
