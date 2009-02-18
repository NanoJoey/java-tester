package org.jtester.hamcrest.iassert.impl;

import org.jtester.hamcrest.iassert.IObjectAssert;

public class ObjectAssert extends BaseAssert<Object, IObjectAssert> implements
		IObjectAssert {
	public ObjectAssert() {
		super(IObjectAssert.class);
	}

	public ObjectAssert(Object bean) {
		super(bean, IObjectAssert.class);
	}

	// public ObjectAssert(Class<? extends IAssert<?, ?>> clazE) {
	// super(clazE);
	// }
	//
	// public ObjectAssert(Class<? extends Object> clazT,
	// Class<? extends IAssert<?, ?>> clazE) {
	// super(clazT, clazE);
	// }
	//
	// public <T extends Object> ObjectAssert(T value,
	// Class<? extends IAssert<?, ?>> clazE) {
	// super(value, clazE);
	// }
}