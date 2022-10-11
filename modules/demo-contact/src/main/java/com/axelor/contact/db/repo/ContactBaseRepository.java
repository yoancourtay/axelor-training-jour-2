package com.axelor.contact.db.repo;

import com.axelor.contact.db.Contact;
import com.axelor.db.Query;
import java.time.LocalDate;
import java.util.List;

public class ContactBaseRepository extends ContactRepository {

  public List<Contact> findByFirstNameLastNameAndBirthDate(
      String firstName, String lastName, LocalDate birthDate) {
    return this.all()
        .filter(
            "self.lastName = :lastNameParam AND self.firstName = :firstName AND self.birthDate = :birthDate")
        .bind("lastNameParam", lastName)
        .bind("firstName", firstName)
        .bind("birthDate", birthDate)
        .fetch();
  }

  @Override
  public Contact findByPhone(String phone) {
    return Query.of(Contact.class)
        .filter("self.phone = :phone")
        .bind("phone", "+33" + phone)
        .fetchOne();
  }

  public Contact findByTitle(String title) {
    String titleForQuery;
    if (title.equals("Madame") || title.equals("Mrs") || title.equals("Mme")) {
      titleForQuery = TITLE_MISS;
    } else {
      titleForQuery = title;
    }

    return Query.of(Contact.class)
        .filter("self.title = :title")
        .bind("title", titleForQuery)
        .fetchOne();
  }
}
