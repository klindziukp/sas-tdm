package com.klindziuk.sas.tdm.gen.generator;

import com.klindziuk.sas.tdm.database.domain.Employee;
import com.klindziuk.sas.tdm.database.domain.Office;
import com.klindziuk.sas.tdm.database.repository.EmployeeRepository;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.model.EmployeeModelGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeGenerator {

  private final EmployeeRepository employeeRepository;
  private final EmployeeModelGenerator employeeModelGenerator;
  private final GeneratorConfig generatorConfig;

  @Autowired
  public EmployeeGenerator(
      EmployeeRepository employeeRepository,
      EmployeeModelGenerator employeeModelGenerator,
      GeneratorConfig generatorConfig) {
    this.employeeRepository = employeeRepository;
    this.employeeModelGenerator = employeeModelGenerator;
    this.generatorConfig = generatorConfig;
  }

  public List<Employee> generateEmployees(List<Office> offices) {
    List<Employee> existingEmployees = employeeRepository.findAll();
    List<Employee> employees = employeeModelGenerator.getEmployees(itemsToGenerate(existingEmployees),
        existingEmployees, offices);
    List<Employee> savedEmployees = employeeRepository.saveAllAndFlush(employees);
    updateReportsToField(savedEmployees);
    return employeeRepository.saveAllAndFlush(savedEmployees);
  }

  private void updateReportsToField(List<Employee> employees) {
    int itemsToUpdate = calculateItemsToUpdate(employees);
    if (!employees.isEmpty()) {
      for (int i = 1; i < itemsToUpdate; i++) {
        employees.get(i).setReportsTo(employees.get(i - 1));
      }
    }
  }

  private long itemsToGenerate(List<Employee> employees) {
    if (!employees.isEmpty() && generatorConfig.getIsRealDataEnabled() &&
        generatorConfig.employee().getIsPercentageCalculationEnabled()) {
      int employeeSyntheticPercentage = generatorConfig.employee().getSyntheticPercentage();
      return Math.round(((double) employees.size() / 50) * employeeSyntheticPercentage);
    }
    return generatorConfig.employee().getSize() > 0 ? generatorConfig.employee().getSize() : 2;
  }

  private int calculateItemsToUpdate(List<Employee> employees) {
    int percentage = generatorConfig.employee().getInvalidPercentage() < 80
        ? generatorConfig.employee().getInvalidPercentage() : 80;
    double invalidSize = (((double) employees.size() / 100)) * percentage;
    return (int) (employees.size() - invalidSize);
  }
}
