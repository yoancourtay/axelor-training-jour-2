package com.axelor.contact.db.repo;

import com.axelor.contact.db.Country;
import com.axelor.inject.Beans;

public class CountryRepositoryTest {

  void testGetFrance() {
    CountryRepository countryRepository = Beans.get(CountryRepository.class);
    Country franceCountry = countryRepository.all().filter("self.code = 'FR'").fetchOne();

    String actual = franceCountry.getName();
    String expected = "France";
  }
}
