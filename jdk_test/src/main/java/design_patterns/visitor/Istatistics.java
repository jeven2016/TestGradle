package design_patterns.visitor;


public interface Istatistics {
  void calculateSalary(IWorker worker);

  void collectAge(IWorker worker);

}
