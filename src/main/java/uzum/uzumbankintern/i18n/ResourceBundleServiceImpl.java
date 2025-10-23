package uzum.uzumbankintern.i18n;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import uzum.uzumbankintern.enums.AppLanguage;

import java.util.Locale;


@Service
@RequiredArgsConstructor
public class ResourceBundleServiceImpl implements ResourceBundleService {
    private final ResourceBundleMessageSource resourceBundleMessageSource;

    @Override
    public String getMessages(String key, AppLanguage language) {
        return resourceBundleMessageSource.getMessage(key, null, new Locale(language.name()));
    }
}
