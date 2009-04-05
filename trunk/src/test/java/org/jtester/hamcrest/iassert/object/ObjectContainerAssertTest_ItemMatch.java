package org.jtester.hamcrest.iassert.object;

import java.util.ArrayList;
import java.util.List;

import org.jtester.testng.JTester;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = { "JTester" })
public class ObjectContainerAssertTest_ItemMatch extends JTester {
	private List<String> list = new ArrayList<String>();

	@BeforeMethod
	public void setup() {
		list.clear();
		list.add("test.hello.one");
		list.add("test.hello.two");
		list.add("test.hello.three");
	}

	public void allItemMatch() {
		want.bool("test.hello.three".matches(".*hello.*")).is(true);

		want.collection(list).sizeIs(3).allItemMatch("test.*", ".*hello.*");
	}

	public void allItemMatch_2() {
		want.collection(list).sizeIs(3).allItemMatch(".*hello.*");
	}

	@Test(expectedExceptions = { AssertionError.class })
	public void allItemMatch_3() {
		want.collection(list).sizeIs(3).allItemMatch(".*hello.*", "test1.*");
	}

	public void hasItemMatch() {
		want.collection(list).sizeIs(3).hasItemMatch(".*one", ".*two");
	}

	public void hasItemMatch_2() {
		want.collection(list).sizeIs(3).hasItemMatch(".*three");
	}

	@Test(expectedExceptions = { AssertionError.class })
	public void hasItemMatch_3() {
		want.collection(list).sizeIs(3).hasItemMatch(".*four");
	}

	@Test(expectedExceptions = { AssertionError.class })
	public void hasItemMatch_4() {
		want.collection(list).sizeIs(3).hasItemMatch("test1", ".*four");
	}
}
