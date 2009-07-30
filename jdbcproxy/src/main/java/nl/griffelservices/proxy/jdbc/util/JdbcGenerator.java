/*
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * The Original Code is JdbcProxy.
 * 
 * The Initial Developer of the Original Code is Frans van Gool.
 * Portions created by the Initial Developer are Copyright (C) 2006
 * Frans van Gool. All Rights Reserved.
 * 
 * Contributor(s): Frans van Gool.
 * 
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU Lesser General Public License (the �LGPL License�), in which case the
 * provisions of LGPL License are applicable instead of those above. If you wish
 * to allow use of your version of this file only under the terms of the LGPL
 * License and not to allow others to use your version of this file under the MPL,
 * indicate your decision by deleting the provisions above and replace them with
 * the notice and other provisions required by the LGPL License. If you do not
 * delete the provisions above, a recipient may use your version of this file
 * under either the MPL or the LGPL License.
 */
package nl.griffelservices.proxy.jdbc.util;

import java.sql.*;

import nl.griffelservices.proxy.Generator;

/**
 * This class uses the {@link Generator} class to generate the proxy classes for
 * the interfaces in <code>java.sql</code>.
 * 
 * @author Frans van Gool
 */
public class JdbcGenerator {
	/**
	 * Entry point.
	 * 
	 * @param args
	 *            command line arguments (unused)
	 * @throws Exception
	 *             if an error occurs
	 */
	public static void main(String args[]) throws Exception {
		Class<?> originals[] = new Class[] { Array.class, /** <br> */
		Blob.class, /** <br> */
		CallableStatement.class, /** <br> */
		Clob.class, /** <br> */
		Connection.class, /** <br> */
		DatabaseMetaData.class, /** <br> */
		Driver.class, /** <br> */
		ParameterMetaData.class, /** <br> */
		PreparedStatement.class, /** <br> */
		Ref.class, /** <br> */
		ResultSetMetaData.class, /** <br> */
		ResultSet.class, /** <br> */
		Savepoint.class, /** <br> */
		SQLData.class, /** <br> */
		SQLInput.class, /** <br> */
		SQLOutput.class, /** <br> */
		Statement.class, /** <br> */
		Struct.class, /** <br> */
		};
		new Generator(originals, "nl.griffelservices.proxy.jdbc", "JdbcProxy").generate("java");
	}
}
