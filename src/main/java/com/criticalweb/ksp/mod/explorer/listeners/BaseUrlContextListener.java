package com.criticalweb.ksp.mod.explorer.listeners;

import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
public class BaseUrlContextListener extends RequestContextListener {

	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		super.requestInitialized(requestEvent);
		ServletRequest servletRequest = requestEvent.getServletRequest();

		StringBuilder sb = new StringBuilder();

		sb.append(servletRequest.getScheme()).append("://").append(servletRequest.getServerName());

		if (servletRequest.getServerPort() != 80 && servletRequest.getServerPort() != 443) {
			sb.append(":").append(servletRequest.getServerPort());
		}

		sb.append(servletRequest.getServletContext().getContextPath());

		servletRequest.setAttribute("baseUrl", sb.toString());

	}
}
