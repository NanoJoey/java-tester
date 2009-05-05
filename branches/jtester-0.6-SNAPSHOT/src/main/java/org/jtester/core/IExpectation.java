package org.jtester.core;

import java.util.Calendar;
import java.util.Date;

import org.jtester.hamcrest.iassert.object.impl.ArrayAssert;
import org.jtester.hamcrest.iassert.object.impl.BooleanAssert;
import org.jtester.hamcrest.iassert.object.impl.ByteAssert;
import org.jtester.hamcrest.iassert.object.impl.CalendarAssert;
import org.jtester.hamcrest.iassert.object.impl.CharacterAssert;
import org.jtester.hamcrest.iassert.object.impl.CollectionAssert;
import org.jtester.hamcrest.iassert.object.impl.DoubleAssert;
import org.jtester.hamcrest.iassert.object.impl.FileAssert;
import org.jtester.hamcrest.iassert.object.impl.FloatAssert;
import org.jtester.hamcrest.iassert.object.impl.IntegerAssert;
import org.jtester.hamcrest.iassert.object.impl.LongAssert;
import org.jtester.hamcrest.iassert.object.impl.MapAssert;
import org.jtester.hamcrest.iassert.object.impl.NumberAssert;
import org.jtester.hamcrest.iassert.object.impl.ObjectAssert;
import org.jtester.hamcrest.iassert.object.impl.ShortAssert;
import org.jtester.hamcrest.iassert.object.impl.StringAssert;
import org.jtester.hamcrest.iassert.object.intf.IArrayAssert;
import org.jtester.hamcrest.iassert.object.intf.IBooleanAssert;
import org.jtester.hamcrest.iassert.object.intf.IByteAssert;
import org.jtester.hamcrest.iassert.object.intf.ICalendarAssert;
import org.jtester.hamcrest.iassert.object.intf.ICharacterAssert;
import org.jtester.hamcrest.iassert.object.intf.ICollectionAssert;
import org.jtester.hamcrest.iassert.object.intf.IDoubleAssert;
import org.jtester.hamcrest.iassert.object.intf.IFileAssert;
import org.jtester.hamcrest.iassert.object.intf.IFloatAssert;
import org.jtester.hamcrest.iassert.object.intf.IIntegerAssert;
import org.jtester.hamcrest.iassert.object.intf.ILongAssert;
import org.jtester.hamcrest.iassert.object.intf.IMapAssert;
import org.jtester.hamcrest.iassert.object.intf.INumberAssert;
import org.jtester.hamcrest.iassert.object.intf.IObjectAssert;
import org.jtester.hamcrest.iassert.object.intf.IShortAssert;
import org.jtester.hamcrest.iassert.object.intf.IStringAssert;

/**
 * the jmock parameter expectation factory
 * 
 * @author darui.wudr
 * 
 */
public interface IExpectation {
	public static final TheExpectation the = new TheExpectation();

	public static class TheExpectation {
		/**
		 * a parameter string will be asserted
		 * 
		 * @return
		 */
		public IStringAssert string() {
			return new StringAssert();
		}

		/**
		 * a parameter boolean will be expected
		 * 
		 * @return
		 */
		public IBooleanAssert bool() {
			return new BooleanAssert();
		}

		/**
		 * a parameter number(integer, long, double,short,float) will be
		 * expected
		 * 
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public INumberAssert number() {
			return new NumberAssert(NumberAssert.class);
		}

		/**
		 * a parameter integer number will be asserted
		 * 
		 * @return
		 */
		public IIntegerAssert integer() {
			return new IntegerAssert();
		}

		/**
		 * a parameter long number will be asserted
		 * 
		 * @return
		 */
		public ILongAssert longnum() {
			return new LongAssert();
		}

		/**
		 * a parameter double number will be asserted
		 * 
		 * @return
		 */
		public IDoubleAssert doublenum() {
			return new DoubleAssert();
		}

		/**
		 * a parameter float number will be asserted
		 * 
		 * @return
		 */
		public IFloatAssert floatnum() {
			return new FloatAssert();
		}

		/**
		 * a parameter short number will be asserted
		 * 
		 * @return
		 */
		public IShortAssert shortnum() {
			return new ShortAssert();
		}

		/**
		 * a parameter character will be asserted
		 * 
		 * @return
		 */
		public ICharacterAssert character() {
			return new CharacterAssert();
		}

		/**
		 * a parameter bite will be asserted
		 * 
		 * @return
		 */
		public IByteAssert bite() {
			return new ByteAssert();
		}

		/**
		 * a parameter array will be asserted
		 * 
		 * @return
		 */
		public IArrayAssert array() {
			return new ArrayAssert();
		}

		/**
		 * a parameter map will be asserted
		 * 
		 * @return
		 */
		public IMapAssert map() {
			return new MapAssert();
		}

		/**
		 * a parameter collection will be asserted
		 * 
		 * @return
		 */
		public ICollectionAssert collection() {
			return new CollectionAssert();
		}

		/**
		 * a parameter general object will be asserted
		 * 
		 * @return
		 */
		public IObjectAssert object() {
			return new ObjectAssert();
		}

		/**
		 * a parameter file will be asserted
		 * 
		 * @return
		 */
		public IFileAssert file() {
			return new FileAssert();
		}

		/**
		 * a parameter calendar will be asserted
		 * 
		 * @return
		 */
		public ICalendarAssert<Calendar> calendar() {
			return new CalendarAssert<Calendar>();
		}

		/**
		 * a parameter date will be asserted
		 * 
		 * @return
		 */
		public ICalendarAssert<Date> date() {
			return new CalendarAssert<Date>();
		}
	}
}
