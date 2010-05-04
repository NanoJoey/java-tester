package org.jtester.tutorial.daos;

import java.util.List;

import org.jtester.tutorial.beans.PhoneGroup;
import org.jtester.tutorial.beans.PhoneItem;

public interface PhoneGroupDao {
	List<PhoneItem> findPhoneItemsByGroupName(String groupName);
	
	long getGroupIdByName(String groupName);

	long insertPhoneGroup(PhoneGroup group);

	/**
	 * 把电话加入组
	 * 
	 * @param itemId
	 * @param groupId
	 */
	void addPhoneItemToGroup(long itemId, long groupId);
}
