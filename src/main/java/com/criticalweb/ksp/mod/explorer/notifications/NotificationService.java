package com.criticalweb.ksp.mod.explorer.notifications;

import com.criticalweb.ksp.mod.explorer.entities.User;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
public interface NotificationService {

	public NotificationStatus sendRegistrationMessage(User user, String baseUrl);

}
