package com.klindziuk.sas.tdm.gen.generator.model;

import com.klindziuk.sas.tdm.database.domain.Employee;
import com.klindziuk.sas.tdm.database.domain.Office;
import com.klindziuk.sas.tdm.gen.util.RandomUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeModelGenerator {

  public List<Employee> getEmployees(long size, List<Employee> existingEmployees, List<Office> offices) {
    Collections.reverse(existingEmployees);
    int employeeStartId = existingEmployees.isEmpty() ? 0 : existingEmployees.get(0).getEmployeeNumber();
    int syntheticEmployeeId = employeeStartId + 10;
    List<Employee> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      syntheticEmployeeId++;
      result.add(employee(syntheticEmployeeId, RandomUtil.getRandomElement(offices)));
    }
    return result;
  }

  public Employee employee(int employeeId, Office office){
    return new Employee()
        .setEmployeeNumber(employeeId)
        .setLastName(RandomUtil.generateStringField("last-name", 4))
        .setFirstName(RandomUtil.generateStringField("first-name", 6))
        .setExtension(RandomUtil.generateStringField("ext", 6))
        .setEmail(RandomUtil.email())
        .setOffice(office)
        .setOfficeCode(office.getOfficeCode())
        .setJobTitle(RandomUtil.generateStringField("job-title", 5));
  }

  public Employee generateEmployeeWithNullField(List<String> nullFields){
    // TODO use reflection to get name for fields
    return new Employee();
  }
}
