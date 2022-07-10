package dev.gegy.nvda_controller_client;

import java.util.Locale;

record Platform(OperatingSystem operatingSystem, Architecture architecture) {
    public static Platform get() {
        final OperatingSystem operatingSystem = OperatingSystem.get();
        final Architecture architecture = Architecture.get();
        return new Platform(operatingSystem, architecture);
    }

    public enum OperatingSystem {
        WINDOWS,
        MAC,
        LINUX,
        UNKNOWN,
        ;

        public static OperatingSystem get() {
            final String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
            if (osName.contains("win")) {
                return WINDOWS;
            } else if (osName.contains("mac")) {
                return MAC;
            } else if (osName.contains("linux") || osName.contains("unix")) {
                return LINUX;
            }
            return UNKNOWN;
        }
    }

    public enum Architecture  {
        X86,
        X64,
        ARM64,
        UNKNOWN,
        ;

        public static Architecture get() {
            final String archName = System.getProperty("os.arch").toLowerCase(Locale.ROOT);
            if (archName.contains("arm64")) {
                return Architecture.ARM64;
            } else if (archName.contains("64")) {
                return Architecture.X64;
            } else if (archName.contains("86")) {
                return Architecture.X86;
            }
            return Architecture.UNKNOWN;
        }
    }
}
