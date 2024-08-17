package sbs.ashie.thestoragedimension.procedures;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class InitCoreStringProcedure {
    public static String firstLoad = "";
	public static String firstplaced = "";

    public InitCoreStringProcedure() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			execute();
		});
	}

	public static String execute() {
		//String firstLoad = "";
		//String firstplaced = "";
		if ((firstLoad).equals("false")) {
			firstLoad = "true";
			firstplaced = "false";
		} else {
			return "Not first load.";
		}
		return "???";
	}
}

