package com.pileproject.drivecommand.machine.device.port;

/***
 * An exception thrown when an attempt to create a subclass of
 * {@link com.pileproject.drivecommand.machine.device.DeviceBase}
 * with inappropriate {@link com.pileproject.drivecommand.machine.device.port.DevicePort} type is occurred.
 * <p>
 * Unchecked exception
 */
public class DevicePortTypeMismatchException extends IllegalArgumentException {
    private static final long serialVersionUID = -2018969863883469894L;

    public DevicePortTypeMismatchException() {
        super();
    }

    public DevicePortTypeMismatchException(String detailMessage) {
        super(detailMessage);
    }

    public DevicePortTypeMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DevicePortTypeMismatchException(Throwable cause) {
        super(cause);
    }
}
