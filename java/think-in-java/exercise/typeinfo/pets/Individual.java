package typeinfo.pets;
public class Individual implements Comparable<Individual> {
  private static long counter;
  private final long id = counter++;
  private String name;
  public Individual(String name) { this.name = name; }
  public Individual() {}
  public String toString() {
    return getClass().getSimpleName() +
    (name==null?"" : " " + name);
  }
  public long id() { return id; }
  public boolean equals(Object o) {
    return o instanceof Individual &&
      id == ((Individual)o).id;
  }
  public int hashCode() {
    int result = 17;
    if (name != null) {
      result = 37*result + name.hashCode();
    }
    result = 37*result + (int)id;
    return result;
  }
  public int compareTo(Individual arg) {
    String cn = getClass().getSimpleName();
    String cnArg = arg.getClass().getSimpleName();
    int cnCompare = cn.compareTo(cnArg);
    if (cnCompare != 0) {
      return cnCompare;
    }
    if (name != null && arg.name != null) {
      int nameCompare = name.compareTo(arg.name);
      if (nameCompare != 0) {
        return nameCompare;
      }
    }
    return (arg.id < id ? -1 : (arg.id==id ? 0 : 1));
  }
}