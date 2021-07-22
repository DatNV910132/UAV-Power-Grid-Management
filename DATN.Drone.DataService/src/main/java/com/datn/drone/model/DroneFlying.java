/*
 * @author DatNV 154484
 * @version 1.0
 * @copyright dom
 */
package com.datn.drone.model;

// TODO: Auto-generated Javadoc
/**
 * The Class DroneFlying.
 */
public class DroneFlying extends BeginEndFlying {
	
	/** The auto flight speed. */
	public float autoFlightSpeed;
	
	/** The max flight speed. */
	public float maxFlightSpeed;
	
	/** The set exit mission on RC signal lost enabled. */
	public boolean setExitMissionOnRCSignalLostEnabled;
	
	/** The flight path mode. */
	public String flightPathMode;
	
	/**
	 * Gets the auto flight speed.
	 *
	 * @return the auto flight speed
	 */
	public float getAutoFlightSpeed() {
		return autoFlightSpeed;
	}
	
	/**
	 * Sets the auto flight speed.
	 *
	 * @param autoFlightSpeed the new auto flight speed
	 */
	public void setAutoFlightSpeed(float autoFlightSpeed) {
		this.autoFlightSpeed = autoFlightSpeed;
	}
	
	/**
	 * Gets the max flight speed.
	 *
	 * @return the max flight speed
	 */
	public float getMaxFlightSpeed() {
		return maxFlightSpeed;
	}
	
	/**
	 * Sets the max flight speed.
	 *
	 * @param maxFlightSpeed the new max flight speed
	 */
	public void setMaxFlightSpeed(float maxFlightSpeed) {
		this.maxFlightSpeed = maxFlightSpeed;
	}
	
	/**
	 * Checks if is sets the exit mission on RC signal lost enabled.
	 *
	 * @return true, if is sets the exit mission on RC signal lost enabled
	 */
	public boolean isSetExitMissionOnRCSignalLostEnabled() {
		return setExitMissionOnRCSignalLostEnabled;
	}
	
	/**
	 * Sets the sets the exit mission on RC signal lost enabled.
	 *
	 * @param setExitMissionOnRCSignalLostEnabled the new sets the exit mission on RC signal lost enabled
	 */
	public void setSetExitMissionOnRCSignalLostEnabled(boolean setExitMissionOnRCSignalLostEnabled) {
		this.setExitMissionOnRCSignalLostEnabled = setExitMissionOnRCSignalLostEnabled;
	}

	/**
	 * Gets the flight path mode.
	 *
	 * @return the flight path mode
	 */
	public String getFlightPathMode() {
		return flightPathMode;
	}

	/**
	 * Sets the flight path mode.
	 *
	 * @param flightPathMode the new flight path mode
	 */
	public void setFlightPathMode(String flightPathMode) {
		this.flightPathMode = flightPathMode;
	}
	

	
	
}
