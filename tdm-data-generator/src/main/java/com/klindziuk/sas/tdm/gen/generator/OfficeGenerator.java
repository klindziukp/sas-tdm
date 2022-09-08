package com.klindziuk.sas.tdm.gen.generator;

import com.klindziuk.sas.tdm.database.domain.Office;
import com.klindziuk.sas.tdm.database.repository.OfficeRepository;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.model.OfficeModelGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeGenerator {

  private final OfficeRepository officeRepository;
  private final OfficeModelGenerator officeModelGenerator;
  private final GeneratorConfig generatorConfig;

  @Autowired
  public OfficeGenerator(
      OfficeRepository officeRepository,
      OfficeModelGenerator officeModelGenerator,
      GeneratorConfig generatorConfig) {
    this.officeRepository = officeRepository;
    this.officeModelGenerator = officeModelGenerator;
    this.generatorConfig = generatorConfig;
  }

  public List<Office> generateOfficeItems() {
    return officeRepository.saveAllAndFlush(officeModelGenerator.getOffices(itemsToGenerate()));
  }

  private long itemsToGenerate() {
    return generatorConfig.office().getSize() > 0 ? generatorConfig.office().getSize() : 1;
  }
}
