package com.klindziuk.sas.tdm.gen.generator.model;

import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Employee;
import com.klindziuk.sas.tdm.database.domain.Payment;
import com.klindziuk.sas.tdm.gen.util.RandomUtil;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PaymentModelGenerator {

  public List<Payment> generatePaymentModels(long size, List<Customer> customers) {
    List<Payment> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      result.add(payment(RandomUtil.getRandomElement(customers)));
    }
    return result;
  }

  public Payment payment(Customer customer) {
    return new Payment()
        .setCustomerNumber(customer.getCustomerNumber())
        .setCustomer(customer)
        .setCheckNumber(RandomUtil.checkNumber())
        .setPaymentDate(new Date(System.currentTimeMillis()))
        .setAmount(24.00);
  }

  public Employee generatePaymentsWithNullField(List<String> nullFields) {
    // TODO use reflection to get name for fields
    return new Employee();
  }
}
