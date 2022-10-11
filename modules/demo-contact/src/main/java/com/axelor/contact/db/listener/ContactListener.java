package com.axelor.contact.db.listener;

import com.axelor.contact.db.Contact;
import com.axelor.contact.db.repo.ContactRepository;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ContactListener {

  @PrePersist
  @PreUpdate
  public void checkValidity(Contact contact) {
    String title = contact.getTitle();
    if (title != null
        && (!title.equals(ContactRepository.TITLE_DOC)
            && !title.equals(ContactRepository.TITLE_MISS)
            && !title.equals(ContactRepository.TITLE_MISTER))) {
      throw new RuntimeException("Invalid title");
    }
  }
}
