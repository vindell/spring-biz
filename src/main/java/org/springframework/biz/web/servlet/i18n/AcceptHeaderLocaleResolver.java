package org.springframework.biz.web.servlet.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;

public class AcceptHeaderLocaleResolver extends AbstractLocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
		if (StringUtils.hasText(language)) {
			return Locale.forLanguageTag(language);
		}
		return getDefaultLocale();
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		if(locale != null) {
			LocaleContextHolder.setLocale(locale);
		}
	}

	
	
}
