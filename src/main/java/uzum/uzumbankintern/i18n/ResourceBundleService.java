package uzum.uzumbankintern.i18n;


import uzum.uzumbankintern.enums.AppLanguage;

public interface ResourceBundleService {
    String getMessages(String key, AppLanguage language);
}
