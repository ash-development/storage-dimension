
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package sbs.ashie.thestoragedimension.init;

import sbs.ashie.thestoragedimension.procedures.InitCoreStringProcedure;
import sbs.ashie.thestoragedimension.procedures.EnterStorageWorldProcedure;
import sbs.ashie.thestoragedimension.procedures.CorePlaceProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class StoragedimensionModProcedures {
	public static void load() {
		new EnterStorageWorldProcedure();
		new CorePlaceProcedure();
		new InitCoreStringProcedure();
	}
}
