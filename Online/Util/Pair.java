public class Pair<A, B> {
  private A a;
  private B b;
  private boolean isMutable;

  public Pair(A a, B b) {
    if (a == null || b == null) {
      throw new NullPointerException("No se aceptan parametros null.");
    }
    this.a = a;
    this.b = b;
    isMutable = true;
  }

  public Pair(A a, B b, boolean isMutable) {
    if (a == null || b == null) {
      throw new NullPointerException("No se aceptan parametros null.");
    }
    this.a = a;
    this.b = b;
    this.isMutable = isMutable;
  }

  public A getA() {
    return a;
  }

  public B getB() {
    return b;
  }

  public void setA(A a) {
    if (isMutable) {
      this.a = a;
    } else {
      throw new UnsupportedOperationException("El objeto es inmutable.");
    }
  }

  public void setB(B b) {
    if (isMutable) {
      this.b = b;
    } else {
      throw new UnsupportedOperationException("El objeto es inmutable.");
    }
  }

  @override
  public boolean equals(Object o) {
    if (o instanceof Pair) {
      Pair<A, B> aux = (Pair<A, B>) o;
      return a.equals(aux.getA()) && b.equals(aux.getB());
    } else {
      return false;
    }
  }

@override
  public int hashCode() {
    int hash = 1;
    hash *= 17 + a.hashCode();
    hash *= 31 + b.hashCode();
    return hash;
  }
}
